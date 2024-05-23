package org.oril.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
public class GatewayConfig {
    @Autowired
    private AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user-service", r -> r.path("/users/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://user-service"))
                .route("auth-service", r -> r.path("/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://auth-service"))
                .route("CartService",r -> r.path("/cart/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://CartService")
                )
                .route("product-service",r -> r.path("/product/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://product-service"))
                .route("OrderService",r -> r.path("/order/**")
                        .filters(f->f.filter(filter))
                        .uri("lb://OrderService"))


                .build();
    }
}
