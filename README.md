# config file at ~/config-repo

change and git commit should be needed for cloud config 

file name => ${spring-project-name}.properties or .yaml

# cloud-config server port 8888

````http://localhost:8888/info-foo/bar````

# microservices

http://localhost:8000/dispatch-service/from/(37.33,127.33)/to/(36.232,127.333)

http://localhost:8100/location-info/from/(37.33,127.33)/to/(36.232,127.333)

http://localhost:8100/location-info-feign/from/(37.33,127.33)/to/(36.232,127.333)

# naming-server : port 8761

# api-gateway : port 8765 

http://localhost:8765/LOCATION-INFO/location-info/from/(37.33,%20127.33)/to/(36.232,%20127.333)

http://localhost:8765/DISPATCH-SERVICE/dispatch-service/from/(37.33,127.33)/to/(36.232,127.333) 

# docker image creation

pom.xml file add below to spring-boot project


	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>ciel/microservice-${project.artifactId}:${project.version}</name>
					</image>
					<pullPolicy>IF_NOT_PRESENT</pullPolicy>
				</configuration>				
			</plugin>
		</plugins>
	</build>


run below command

`./mvnw spring-boot:build-image -DskipTests`

# zipkin test

docker run -p 9411:9411 openzipkin/zipkin


# docker compose command

docker compose up  - server up

docker compose down - server down and remove container


