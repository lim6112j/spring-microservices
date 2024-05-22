package com.ciel.microservices.dispatchservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Geocode {
		@Id
		private Long id;
		@Column(name="loc_from")
		private String from;
		@Column(name="loc_to")
		private String to;
		private String fromGeocode;
		private String toGeocode;
		private String environment;
		Geocode() {}
		Geocode(Long id, String from, String to) {
				super();
				this.id = id;
				this.from = from;
				this.to = to;
		}
		
		public String getFrom() {
			return from;
		}
		public void setFrom(String from) {
			this.from = from;
		}
		public String getTo() {
			return to;
		}
		public void setTo(String to) {
			this.to = to;
		}
		public String getFromGeocode() {
			return "seoul street 131";
		}
		public void setFromGeocode(String fromGeocode) {
			this.fromGeocode = fromGeocode;
		}
		public String getToGeocode() {
			return "busan streat 333";
		}
		public void setToGeocode(String toGeocode) {
			this.toGeocode = toGeocode;
		}
		public String getEnvironment() {
			return environment;
		}
		public void setEnvironment(String environment) {
			this.environment = environment;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}		
}
