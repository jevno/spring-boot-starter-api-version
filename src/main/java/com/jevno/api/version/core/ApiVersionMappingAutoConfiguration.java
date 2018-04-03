package com.jevno.api.version.core;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
public class ApiVersionMappingAutoConfiguration {
	
	@Bean
	public WebMvcRegistrations customWebMvcRegistrations()
	{
		return new CustomWebMvcRegistrations();
	}
}
