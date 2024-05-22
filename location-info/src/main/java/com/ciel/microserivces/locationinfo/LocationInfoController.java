package com.ciel.microserivces.locationinfo;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LocationInfoController {
		@Autowired
		private DispatchProxy proxy;
		@Autowired
		private Environment environment;
		@GetMapping("/location-info/from/{from}/to/{to}")
		public LocationInfo retrieveInfo(@PathVariable String from,@PathVariable String to) {
				String url = "http://localhost:8000/dispatch-service/from/{from}/to/{to}";
				HashMap<String, String> uriVariables = new HashMap<>();
				uriVariables.put("from", from);
				uriVariables.put("to", to);
				LocationInfo response = new RestTemplate().getForEntity(url, LocationInfo.class, uriVariables).getBody();
				
				LocationInfo locationinfo = new LocationInfo(response.getId(), from, to, response.getFromGeocode(), response.getToGeocode(), response.getEnvironment() + " " + "Rest Template");
				return locationinfo;
		}
		@GetMapping("/location-info-feign/from/{from}/to/{to}")
		public LocationInfo retrieveInfoFeign(@PathVariable String from,@PathVariable String to) {
				LocationInfo response = proxy.retrieveGeocode(from, to);
				LocationInfo locationinfo = new LocationInfo(response.getId(), from, to, response.getFromGeocode(), response.getToGeocode(), response.getEnvironment() + " " + "Feign");
				return locationinfo;				
		}
}
