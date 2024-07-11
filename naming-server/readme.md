# Naming Server

This is a Spring Boot application that serves as a Eureka Naming Server for microservices.

## Prerequisites

- Java 18
- Maven 3.6+
- Spring Boot 3.2.5
- Spring Cloud 2023.0.1

## Project Structure

```
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── ciel
    │   │           └── microservices
    │   │               └── namingserver
    │   │                   └── NamingServerApplication.java
    │   └── resources
    │       └── application.properties
    └── test
        └── java
            └── com
                └── ciel
                    └── microservices
                        └── namingserver
                            └── NamingServerApplicationTests.java
```

## Building the Application

To build the application, run the following command in the project root directory:

```
./mvnw clean install
```

This command will compile the code, run tests, and package the application into a JAR file.

## Running the Application

After building the application, you can run it using the following command:

```
./mvnw spring-boot:run
```

Alternatively, you can run the JAR file directly:

```
java -jar target/naming-server-0.0.1-SNAPSHOT.jar
```

The application will start on port 8761 by default.

## Configuration

The main configuration file is `src/main/resources/application.properties`. It includes the following settings:

```properties
spring.application.name=naming-server
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

These settings configure the application name, server port, and Eureka client behavior.

## Features

- Acts as a Eureka Server for service discovery
- Configured to not register itself with Eureka or fetch the registry

## Dependencies

This project uses the following main dependencies:

- Spring Boot Starter Actuator
- Spring Cloud Netflix Eureka Server
- Spring Boot DevTools (for development)

For a full list of dependencies, please refer to the `pom.xml` file.

## Building a Docker Image

The project is configured to build a Docker image using the Spring Boot Maven plugin. To build the image, run:

```
./mvnw spring-boot:build-image
```

This will create a Docker image named `ciel/microservice-naming-server:0.0.1-SNAPSHOT`.

## Running Tests

To run the tests for this project, execute:

```
./mvnw test
```

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the [LICENSE NAME] - see the LICENSE.md file for details.