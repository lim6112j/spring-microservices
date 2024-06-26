package com.ciel.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "hello world").addRequestParameter("my param", "10"))
				.uri("http://httpbin.org:80");
		return builder.routes().route(routeFunction)
				.route(p -> p.path("/dispatch-service/**").uri("lb://dispatch-service"))
				.route(p -> p.path("/location-info/**").uri("lb://location-info"))
				.route(p -> p.path("/location-info-feign/**").uri("lb://location-info"))
				.route(p -> p.path("/location-info-new/**").filters(
						f -> f.rewritePath("/location-info-new/(?<segment>.*)", "/location-info-feign/${segment}"))
						.uri("lb://location-info"))
				.build();
	}
}
