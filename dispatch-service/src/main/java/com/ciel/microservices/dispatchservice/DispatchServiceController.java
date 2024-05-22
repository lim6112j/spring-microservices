package com.ciel.microservices.dispatchservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispatchServiceController {
		@Autowired
		private GeocodeRepository repo;
		@Autowired
		private Environment environment;
		@GetMapping("/dispatch-service/from/{from}/to/{to}")
		public Geocode retrieveGeocode(@PathVariable String from, @PathVariable String to) {
				//				Geocode geocode = new Geocode(1000L, from, to);
				String port = environment.getProperty("local.server.port");
				Geocode geocode = repo.findByFromAndTo(from, to);
				if(geocode == null) {
						throw new RuntimeException("Unable to find data for " + from + ", " + to);
				}
				geocode.setEnvironment(port);
				return geocode;
		}
}
