package com.vits.EventCalendar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
 
 @Bean
 public OpenAPI customOpenAPI() {
     return new OpenAPI()
             .info(new Info()
                     .title("Nome da sua API")
                     .version("1.0")
                     .description("Descrição da sua API")
                     .contact(new Contact()
                             .name("Seu Nome")
                             .email("seu.email@exemplo.com")));
 }
}