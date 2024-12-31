plugins {
    kotlin("jvm") version "1.9.24"
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
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