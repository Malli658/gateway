package com.ibm.gateway.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfiguration {
	
	@Bean
	public CorsWebFilter corsWebFilter(){
		org.springframework.web.cors.CorsConfiguration corsConfigurations=new org.springframework.web.cors.CorsConfiguration();
		corsConfigurations.setAllowedOrigins(Collections.singletonList("*"));
		corsConfigurations.setMaxAge(3600L);
		corsConfigurations.setAllowedMethods(Arrays.asList("GET", "POST","DELETE","PUT","OPTIONS","PATCH"));
		corsConfigurations.addAllowedHeader("*");
		UrlBasedCorsConfigurationSource basedCorsConfigurationSource=new UrlBasedCorsConfigurationSource();
		basedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfigurations);
		return new CorsWebFilter(basedCorsConfigurationSource);
	}

}
