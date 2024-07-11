To build and run your Spring Boot application using Maven, follow these steps based on your project structure and setup:

### 1. Building the Project

First, ensure you are in the root directory of your project (where `pom.xml` is located).

#### Using Maven Wrapper (mvnw)

If you have Maven Wrapper (`mvnw` or `mvnw.cmd`), you can build your project using the following commands:

- **Linux/macOS**:
  ```bash
  ./mvnw clean package
  ```
  
- **Windows** (Command Prompt):
  ```cmd
  mvnw.cmd clean package
  ```

This command performs a clean build (`clean`) and packages (`package`) your application into a JAR file.

#### Using System-wide Maven Installation

If you have Maven installed globally on your system, you can use the `mvn` command instead:

- **Linux/macOS/Windows**:
  ```bash
  mvn clean package
  ```

### 2. Running the Application

After successfully building your application, you can run it using the following command:

#### Using Maven Wrapper (mvnw)

- **Linux/macOS**:
  ```bash
  ./mvnw spring-boot:run
  ```

- **Windows** (Command Prompt):
  ```cmd
  mvnw.cmd spring-boot:run
  ```

This command starts your Spring Boot application.

#### Using System-wide Maven Installation

- **Linux/macOS/Windows**:
  ```bash
  mvn spring-boot:run
  ```

### Additional Notes:

- **Profiles**: If you want to use specific profiles during build or run, you can specify them with `-P` option followed by profile name.
  
  Example: `./mvnw clean package -Pproduction`

- **Java Version**: Ensure you have Java 18 installed and configured properly on your system. Maven will use the configured Java version.

- **Dependencies**: Your `pom.xml` file lists various dependencies including Spring Cloud, Spring Boot, and others necessary for your application.

- **Testing**: Tests are typically executed during the `package` phase unless skipped explicitly (`-DskipTests`).

By following these steps, you should be able to build and run your Spring Boot application successfully using Maven. Adjust paths and commands as per your system setup and requirements.