package com.arthurlevi.springcloudgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayApplication {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes() 
			    .route( "hr-worker" , r -> r.path( "/hr-worker/**" ) 
			      .filters(f -> f.stripPrefix( 1 )) 
			      .uri( "lb://HR-WORKER" )) 
			    .route( "hr-payroll" , r -> r.path( "/hr-payroll/**" ) 
			      .filters(f -> f.stripPrefix( 1 )) 
			      .uri( "lb://HR-PAYROLL" ))
			    .route("hr-user", r -> r.path("/hr-user/**")
			      .filters(f -> f.stripPrefix( 1 ))
			      .uri("lb://HR-USER"))
			    .route("hr-oauth", r-> r.path("/hr-oauth/**")
			      .filters(f -> f.stripPrefix( 1 ).removeResponseHeader("Cookie").removeResponseHeader("Set-Cookie"))
			      .uri("lb://HR-OAUTH"))
			    .build(); 
			  } 

}
