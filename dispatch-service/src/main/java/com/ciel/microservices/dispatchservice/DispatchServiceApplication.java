package com.ciel.microservices.dispatchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DispatchServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DispatchServiceApplication.class, args);
	}

}
