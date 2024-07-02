package com.ciel.microservices.dispatch_engine_service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class DispatchEngineServiceController {
		private Logger logger = LoggerFactory.getLogger(DispatchEngineServiceController.class);
		@GetMapping("/dispatch-engine-service/{id}")
		public String getId(@PathVariable String id) {
				logger.info("getId test called with {}", id);
				return id;
		}
		@PostMapping(value = "/dispatch-engine-service", consumes = "application/json", produces="applcation/json")
		public String getDispatch(@RequestBody DispatchRequest req, HttpServletResponse res) {
				return "success";
		}
}
class DispatchRequest {}
