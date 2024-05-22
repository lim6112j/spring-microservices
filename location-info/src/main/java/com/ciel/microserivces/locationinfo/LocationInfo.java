package com.ciel.microserivces.locationinfo;


public class LocationInfo {
		private Long id;
		private String from;
		private String  to;
		private String fromGeocode;
		private String toGeocode;
		private String environment;
		LocationInfo() {}
		LocationInfo(Long id, String from, String to, String fromGeocode, String toGeocode, String environment) {
				super();
				this.id = id;
				this.from = from;
				this.to = to;
				this.fromGeocode = fromGeocode;
				this.toGeocode = toGeocode;
				this.environment = environment;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
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
		public String getEnvironment() {
			return environment;
		}
		public void setEnvironment(String environment) {
			this.environment = environment;
		}
		public String getFromGeocode() {
			return fromGeocode;
		}
		public void setFromGeocode(String fromGeocode) {
			this.fromGeocode = fromGeocode;
		}
		public String getToGeocode() {
			return toGeocode;
		}
		public void setToGeocode(String toGeocode) {
			this.toGeocode = toGeocode;
		}
		
}
