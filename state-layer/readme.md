# State Layer Service

This is a microservice that's part of a vehicle sharing service system. It provides a RESTful API for managing vehicle states, customer requests, routes, and events.

## Project Structure

```
├── config
│   └── eureka-config.yml
├── index.js
├── openapi-spec.yml
├── package.json
├── README.md
└── yarn.lock
```

- `config/eureka-config.yml`: Configuration file for Eureka client
- `index.js`: Main application file
- `openapi-spec.yml`: OpenAPI specification for the service's API
- `package.json`: Node.js project configuration and dependencies
- `README.md`: This file

## Prerequisites

- Node.js (version specified in `package.json`)
- Yarn package manager
- Eureka server running on `localhost:8761`

## Setup

1. Clone the repository:
   ```
   git clone <repository-url>
   cd state-layer
   ```

2. Install dependencies:
   ```
   yarn install
   ```

3. Start the service:
   ```
   yarn start
   ```

The service will start on port 8600 and register itself with the Eureka server.

## API Documentation

The API is documented using OpenAPI 3.0 specification. You can access the API documentation at:

```
http://localhost:8600/state-layer-service/v3/api-docs
```

## Features

- Vehicle management (registration, info retrieval, updates)
- Customer request handling
- Route calculation
- Event management

## Eureka Integration

This service uses Eureka for service discovery. It registers itself with the Eureka server on startup and de-registers on shutdown.

## Integration with API Gateway

To integrate this service with the API Gateway, follow these steps:

1. Add the API docs URL to the `application.yml` of the API Gateway:

   In the `springdoc` section, add the following entry to the `urls` list:

   ```yaml
   springdoc:
     # ... other springdoc configurations ...
     swagger-ui:
       urls:
         # ... other service URLs ...
         - url: /state-layer-service/v3/api-docs
           name: State Layer Api
   ```

2. Update the `ApiGatewayConfiguration` class:

   Add a new route for the State Layer Service in the `gatewayRouter` method:

   ```java
   @Bean
   public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
       return builder.routes()
           // ... other routes ...
           .route(p -> p.path("/state-layer-service/v3/api-docs").uri("lb://state-layer-service"))
           // ... other routes ...
           .build();
   }
   ```

3. Create a new folder for the service at the root directory of the project.

4. Implement the service with Eureka client integration:

   - Use a unique port number that doesn't conflict with other services (e.g., 8600 in this case).
   - Implement Eureka client registration as shown in the `index.js` example.
   - Provide an endpoint for the OpenAPI specification at `/state-layer-service/v3/api-docs`.

   Example (from `index.js`):

   ```javascript
   const port = 8600;
   const eureka_client = new Eureka({
       instance: {
           app: "state-layer-service",
           // ... other Eureka configurations ...
       },
       // ... other configurations ...
   });

   app.get("/state-layer-service/v3/api-docs", (req, res) => {
       const openApiSpec = loadOpenApiSpec();
       if (openApiSpec) {
           res.json(openApiSpec);
       } else {
           res.status(500).send('Error loading OpenAPI specification');
       }
   });

   // ... rest of the server setup ...
   ```

By following these steps, the new State Layer Service will be integrated with the API Gateway and discoverable through Eureka.

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the `LICENSE` file for details.