package org.ex.zomatocloneapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiDoc {

    io.swagger.v3.oas.models.info.Info info() {
        return new Info()
                .title("Zomato-Clone-API - Restaurant Management API")
                .description(
                        "Zomato-Clone-API provides RESTful endpoints for managing the restaurant system, " +
                                "including operations for users, restaurants, menus, orders, and cuisines. " +
                                "The API supports full CRUD functionality for all entities, facilitating seamless interaction " +
                                "between customers and restaurant owners."
                );
    }

    @Bean
    OpenAPI openAPI() {
        return new OpenAPI().info(this.info());
    }
}
