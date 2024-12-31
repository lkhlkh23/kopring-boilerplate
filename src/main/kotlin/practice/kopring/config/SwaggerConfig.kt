package practice.kopring.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun openApi(): OpenAPI {
        return OpenAPI().components(Components())
            .info(getApiInfo())
    }

    private fun getApiInfo(): Info {
        return Info().title("Swagger Title")
            .description("Swagger Description")
            .version("1.0.0")
    }
}
