package com.back.crud;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configurable
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
			.allowedOrigins("http://localhost:4200/*")
	        .allowedMethods("*")
	        .maxAge(3600L)
	        .allowedHeaders("*")
			.allowCredentials(true)
			.exposedHeaders("*");
	}
}
