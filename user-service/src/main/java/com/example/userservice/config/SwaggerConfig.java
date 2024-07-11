package com.example.userservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "User Service API for MSA",
                description = "User Service API with spring boot 3.2.5 + spring cloud.",
                version ="v1.0.0")
)
@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi customTestOpenAPI() {
        String[] paths = {"/check", "/users/**"};

        return GroupedOpenApi.builder()
                .group("사용자 관리를 위한 User 도메인에 대한 API")
                .pathsToMatch(paths)
                .build();
    }
}
