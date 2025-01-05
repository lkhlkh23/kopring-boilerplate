import nu.studer.gradle.jooq.JooqEdition

plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.spring") version "1.9.24"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("nu.studer.jooq") version "8.2"
}

group = "practice"
version = "0.0.1-SNAPSHOT"

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    // spring boot
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.jetbrains.kotlin", "kotlin-reflect")

    // db
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")
    implementation("mysql", "mysql-connector-java", "8.0.32")
    implementation("com.h2database", "h2")

    // jooq
    implementation("org.springframework.boot", "spring-boot-starter-jooq")
    jooqGenerator("com.h2database:h2:2.2.224")
    jooqGenerator("org.jooq:jooq-meta:3.18.10")
    jooqGenerator("org.jooq:jooq-codegen:3.18.10")

    // swagger
    implementation("org.springdoc", "springdoc-openapi-starter-webmvc-ui", "2.0.2")

    // snakeyaml
    implementation("org.yaml", "snakeyaml", "2.0")

    // test
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.10.2")
    testImplementation("org.assertj", "assertj-core", "3.25.3")
    testImplementation("io.kotest", "kotest-runner-junit5", "5.8.0")
}

tasks {
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
    }
}

jooq {
    version.set("3.18.10")
    edition.set(JooqEdition.OSS)

    configurations {
        create("main") {
            generateSchemaSourceOnCompilation.set(true)
            jooqConfiguration.apply {
                logging = org.jooq.meta.jaxb.Logging.WARN
                jdbc.apply {
                    driver = "org.h2.Driver"
                    url = "jdbc:h2:mem:coupon;DB_CLOSE_DELAY=-1\n"
                    user = "sa"
                    password = ""
                }
                generator.apply {
                    name = "org.jooq.codegen.KotlinGenerator"
                    database.apply {
                        name = "org.jooq.meta.h2.H2Database"
                        // excludes = "INFORMATION_SCHEMA"
                    }
                    generate.apply {
                        isDeprecated = false
                        isFluentSetters = true
                        isRecords = true
                    }
                    target.apply {
                        packageName = "practice.kopring"
                        directory = "build/generated-src/jooq/main"
                    }
                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

