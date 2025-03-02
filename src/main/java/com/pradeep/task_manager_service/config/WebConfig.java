package com.pradeep.task_manager_service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.Getter;
import lombok.Setter;

import org.springframework.lang.NonNull;

@Configuration
@ConfigurationProperties(prefix = "cors")
@Getter
@Setter
public class WebConfig {
    private String allowedOrigins;
    private String allowedMethods;
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/**")
                .allowedOrigins(allowedOrigins.split(","))
                .allowedMethods(allowedMethods.split(","))
               .allowedHeaders("*")
               .allowCredentials(true);
            }
        };
    }
}
