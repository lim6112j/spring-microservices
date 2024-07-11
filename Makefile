.PHONY: all api-gateway dispatch-engine-service location-info cloud.config.server dispatch-service naming-server state-layer

build: api-gateway dispatch-engine-service location-info cloud.config.server dispatch-service naming-server state-layer

api-gateway:
	cd api-gateway && ./mvnw spring-boot:build-image -DskipTests

dispatch-engine-service:
	cd dispatch-engine-service && ./mvnw spring-boot:build-image -DskipTests

location-info:
	cd location-info && ./mvnw spring-boot:build-image -DskipTests

cloud.config.server:
	cd cloud.config.server && ./mvnw spring-boot:build-image -DskipTests

dispatch-service:
	cd dispatch-service && ./mvnw spring-boot:build-image -DskipTests

naming-server:
	cd naming-server && ./mvnw spring-boot:build-image -DskipTests
