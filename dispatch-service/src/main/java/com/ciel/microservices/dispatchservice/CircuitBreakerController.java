package com.ciel.microservices.dispatchservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreakerController {
		private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

		@CircuitBreaker(name="default", fallbackMethod="fallback")
		//@Bulkhead(name="sample-api")
		//@RateLimiter(name="default")
		@GetMapping("/sample-api")
		public String sampleApi() {
				logger.info("Sample api call received");
				return "Sample Api";
		}
		public String fallback(Exception e) {
				return "fallback";
		}
}
