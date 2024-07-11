package com.ciel.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction = p -> p.path("/get")
				.filters(f -> f.addRequestHeader("MyHeader", "hello world").addRequestParameter("my param", "10"))
				.uri("http://httpbin.org:80");
		return builder.routes().route(routeFunction)
				.route(p -> p.path("/node-service/v3/api-docs").uri("lb://nodejs-service"))
				.route(p -> p.path("/state-layer-service/v3/api-docs").uri("lb://state-layer-service"))
				.route(p -> p.path("/dispatch-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://dispatch-service"))
				.route(p -> p.path("/location-info/v3/api-docs").and().method(HttpMethod.GET).uri("lb://location-info"))
				.route(p -> p.path("/dispatch-engine-service/v3/api-docs").uri("lb://dispatch-engine-service"))
				.route(p -> p.path("/dispatch-engine-servicei/**").uri("lb://dispatch-engine-service"))
				.route(p -> p.path("/dispatch-servicei/**").uri("lb://dispatch-service"))
				.route(p -> p.path("/location-info/**").uri("lb://location-info"))
				.route(p -> p.path("/location-info-feign/**").uri("lb://location-info"))
				.route(p -> p.path("/location-info-new/**").filters(
						f -> f.rewritePath("/location-info-new/(?<segment>.*)", "/location-info-feign/${segment}"))
						.uri("lb://location-info"))
				.build();
	}
}
