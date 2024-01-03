package com.arthurlevi.springcloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HrGatewaySpringCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrGatewaySpringCloudApplication.class, args);
	}

}
