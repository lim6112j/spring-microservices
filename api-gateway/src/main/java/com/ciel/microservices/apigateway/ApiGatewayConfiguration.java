package com.ciel.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
		@Bean
		public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
				Function<PredicateSpec, Buildable<Route>> routeFunction =
						p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyHeader", "hello world")
										 .addRequestParameter("my param", "10"))
						.uri("http://httpbin.org:80");
				return builder.routes()
						.route(routeFunction)
						.route(p->p.path("/dispatch-service/**").uri("lb://dispatch-service"))
						.route(p->p.path("/location-info/**").uri("lb://location-info"))
						.route(p->p.path("/location-info-feign/**").uri("lb://location-info"))						
						.build();
		}
}
