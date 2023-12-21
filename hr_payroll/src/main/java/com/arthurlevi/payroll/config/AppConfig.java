package com.arthurlevi.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean //chamada de metodo
	public RestTemplate restTample() {
		return new RestTemplate();
	}
}
