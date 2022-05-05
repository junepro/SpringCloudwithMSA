package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

   // @Bean  //yml 주석처리부분을 자바클래스로 옮긴것
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes() //first-service 요청오면
                .route(r-> r.path("/first-service/**")
                        .filters(f->f.addRequestHeader("first-request","first-request-header")
                                .addResponseHeader("first-response","first-response-header"))
                        .uri("http://localhost:8082")) //여기로 이동
                .route(r-> r.path("/second-service/**")
                        .filters(f->f.addRequestHeader("second-request","second-request-header")
                                .addResponseHeader("second-response","second-response-header"))
                        .uri("http://localhost:8082")) //여기로 이동
                .build();
    }
}
