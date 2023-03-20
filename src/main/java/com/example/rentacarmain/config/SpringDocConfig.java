package com.example.rentacarmain.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {

    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI().info(
                new Info()
                        .contact(new Contact()
                                .email("Rufet@gmail.com")
                                .name("Rufet")
                                .url("www.ruhusyen.com"))
                        .title("Documentation by Rufet Huseynov")
                        .version("1.0.0"));
    }

}
