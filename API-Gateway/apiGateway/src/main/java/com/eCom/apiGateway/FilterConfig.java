package com.eCom.apiGateway;

import com.eCom.apiGateway.jwtFilter.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {

        return builder.routes()

                .route("product-service", r -> r
                        .path("/api/product/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("http://localhost:8082")
                )

                .route("order-service", r -> r
                        .path("/api/order/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("http://localhost:8084")
                )

                .route("user-service", r -> r
                        .path("/api/user/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("http://localhost:8083")
                )

                // AUTH SERVICE (NO JWT FILTER)
                .route("auth-service", r -> r
                        .path("/auth/**")
                        .uri("http://localhost:8081")
                )

                .build();
    }
}


