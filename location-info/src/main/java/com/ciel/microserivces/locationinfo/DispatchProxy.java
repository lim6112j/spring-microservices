package com.ciel.microserivces.locationinfo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="dispatch-service", url="localhost:8000")
public interface DispatchProxy {
		@GetMapping("/dispatch-service/from/{from}/to/{to}")
		public LocationInfo retrieveGeocode(@PathVariable String from, @PathVariable String to);
}
