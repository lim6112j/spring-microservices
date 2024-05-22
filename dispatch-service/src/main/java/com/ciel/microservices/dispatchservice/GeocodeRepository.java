package com.ciel.microservices.dispatchservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeocodeRepository extends JpaRepository<Geocode, Long> {
		Geocode findByFromAndTo(String from, String to);
}
