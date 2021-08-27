package com.ibm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
	
	
	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		return builder.routes().route("mediaservice",r->r.path("/media/v1/**").uri("lb://media-service"))
				               .route("userService", r->r.path("/user/v1/**").uri("lb://user-service"))
				               .route("miscellaneousservice",r->r.path("/miscellaneous/v1/**").uri("lb://miscellaneous-service"))
				               .build();
		
	}
	
}
