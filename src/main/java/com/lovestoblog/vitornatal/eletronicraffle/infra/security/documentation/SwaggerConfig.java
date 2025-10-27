package com.lovestoblog.vitornatal.eletronicraffle.infra.security.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI getOpenApi(){

        Contact contact = new Contact();
        contact.name("Vitor N");
        contact.email("vitornc31@gmail.com");

        return new OpenAPI().info(
                new Info()
                        .title("E-Raffle")
                        .version("1.0")
                        .description("Raffle system api's documentation")
                        .contact(contact)
        );
    }
}
