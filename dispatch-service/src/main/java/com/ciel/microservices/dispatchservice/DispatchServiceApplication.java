package com.ciel.microservices.dispatchservice;

import java.time.Duration;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadRegistry;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.micrometer.observation.Observation.CheckedFunction;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;

@SpringBootApplication
@EnableDiscoveryClient
public class DispatchServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DispatchServiceApplication.class, args);
	}

	// // Create a Bulkhead with default configuration
	// @Autowired
	private CircuitBreakerController cbc;
	// // Create a custom configuration for a CircuitBreaker
	// CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
	// .waitDurationInOpenState(Duration.ofMillis(10000))
	// .build();
	// // Create a CircuitBreakerRegistry with a custom global configuration
	// CircuitBreakerRegistry circuitBreakerRegistry =
	// CircuitBreakerRegistry.of(circuitBreakerConfig);
	// CircuitBreaker circuitBreaker = circuitBreakerRegistry
	// .circuitBreaker("name");
	// Supplier<String> checkedSupplier =
	// CircuitBreaker.decorateSupplier(circuitBreaker,() -> cbc.sampleApi());
	// Try<String> result = Try.ofSupplier(checkedSupplier)
	// .recover(throwable -> "Hello Recovery");
	// Given
}
