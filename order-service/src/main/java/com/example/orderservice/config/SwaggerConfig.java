package com.example.orderservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Order Service API for MSA",
                description = "Order Service API with spring boot 3.2.5 + spring cloud.",
                version ="v1.0.0")
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customTestOpenAPI() {
        String[] paths = {"/order-service/**"};

        return GroupedOpenApi.builder()
                .group("제품 관리를 위한 Order 도메인에 대한 API")
                .pathsToMatch(paths)
                .build();
    }
}
