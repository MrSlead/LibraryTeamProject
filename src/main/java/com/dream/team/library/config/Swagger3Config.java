package com.dream.team.library.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Класс Swagger3Config, необходимый для того, чтобы подключить к web-приложению поддержку swagger.
 */
@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(
                new Info()
                        .title("Library Swagger Api")
                        .version("1.0.0")
                        .contact(
                                new Contact()
                                        .email("vadim.jykov.galanino@gmail.com")
                                        .name("Evgeny Mordyasov")
                        )
        );
    }
}
