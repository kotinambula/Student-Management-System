package com.koti.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Student Management System API")
                        .description("This is the API documentation for Student Management System.")
                        .version("v1.0")
                        .termsOfService("https://example.com/terms")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("Nambula Kotaiah")
                                .email("nambulakoti999@gmail.com"))
                );
    }
}