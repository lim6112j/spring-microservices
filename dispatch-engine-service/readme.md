# Dispatch Engine Service

This is a microservice application built with Spring Boot for handling dispatch operations.

## Prerequisites

- Java 18
- Maven 3.6+
- Spring Boot 3.3.1
- Spring Cloud 2023.0.2

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
    │   │               └── dispatch_engine_service
    │   │                   ├── DispatchEngineServiceApplication.java
    │   │                   └── DispatchEngineServiceController.java
    │   └── resources
    │       ├── application.properties
    │       └── application.yml
    └── test
        └── java
            └── com
                └── ciel
                    └── microservices
                        └── dispatch_engine_service
                            └── DispatchEngineServiceApplicationTests.java
```

## Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   cd dispatch-engine-service
   ```

2. Build the project:
   ```
   ./mvnw clean install
   ```

## Running the Application

You can run the application using the following command:

```
./mvnw spring-boot:run
```

The application will start on port 8201 by default.

## Configuration

The main configuration file is `src/main/resources/application.yml`. It includes settings for:

- Spring Application Name
- Config Server URL
- Eureka Client
- Server Port
- OpenAPI Documentation

## API Documentation

The API documentation is available at:

- OpenAPI JSON: `http://localhost:8201/dispatch-engine-service/v3/api-docs`
- Swagger UI: `http://localhost:8201/dispatch-engine-service/swagger-ui.html`

## Endpoints

- GET `/dispatch-engine-service/{id}`: Retrieves dispatch information by ID
- POST `/dispatch-engine-service`: Creates a new dispatch

## Testing

Run the tests using:

```
./mvnw test
```

## Dependencies

This project uses the following main dependencies:

- Spring Boot Starter Actuator
- Spring Boot Starter Web
- Spring Cloud Starter Config
- Spring Cloud Starter Netflix Eureka Client
- SpringDoc OpenAPI UI
- Spring Boot DevTools (for development)

For a full list of dependencies, please refer to the `pom.xml` file.

## Contributing

Please read CONTRIBUTING.md for details on our code of conduct, and the process for submitting pull requests.

## License

This project is licensed under the [LICENSE NAME] - see the LICENSE.md file for details.