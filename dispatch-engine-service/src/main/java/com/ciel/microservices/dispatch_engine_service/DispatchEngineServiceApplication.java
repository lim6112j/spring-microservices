package com.ciel.microservices.dispatch_engine_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DispatchEngineServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DispatchEngineServiceApplication.class, args);
	}

}
