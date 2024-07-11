* cloud-config 
http://localhost:8888/info-foo/bar

* microservices
http://localhost:8000/dispatch-service/from/(37.33, 127.33)/to/(36.232, 127.333)
http://localhost:8100/location-info/from/(37.33, 127.33)/to/(36.232,127.333)
http://localhost:8100/location-info-feign/from/(37.33, 127.33)/to/(36.232, 127.333)

* naming-server
port 8761
* api-gateway
port 8765
http://localhost:8765/dispatch-service/from/(37.33, 127.33)/to/(36.232, 127.333)
http://localhost:8765/location-info/from/(37.33, 127.33)/to/(36.232,127.333)
http://localhost:8765/location-info-feign/from/(37.33, 127.33)/to/(36.232, 127.333)


======

# Cloud Config Server

This project is a Spring Boot application configured to run as a Spring Cloud Config Server.

## Prerequisites

- JDK 18 or higher installed (tested on 21)
- Apache Maven installed

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### Installation

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   cd cloud.config.server
   ```

2. **Build the project:**

   ```bash
   ./mvnw clean install
   ```

   For Windows:

   ```bash
   mvnw.cmd clean install
   ```

### Running the Application

To run the Spring Boot application locally, execute:

```bash
./mvnw spring-boot:run
```

For Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start at `http://localhost:8080`.

### Testing

To run the tests, use:

```bash
./mvnw test
```

For Windows:

```bash
mvnw.cmd test
```

### Configuration

The application uses `application.properties` located in `src/main/resources` for configuration. Customize it according to your environment.

## References

- [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.5/maven-plugin/reference/html/)
- [Spring Cloud Config Server Documentation](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/)

## Contributing

Feel free to fork the repository and submit pull requests.

---

Replace `<repository-url>` with the actual URL of your Git repository. This `README.md` file provides a comprehensive guide to cloning, building, running, testing, and configuring your Spring Boot application. Adjust paths and commands based on your specific setup if necessary.