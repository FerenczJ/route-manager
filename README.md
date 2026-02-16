# Route Manager

A Spring Boot application built with the latest stable version (4.0.2) of Spring Boot.

## Prerequisites

- Java 21 or later
- Maven 3.6+

## Technologies

- **Spring Boot**: 4.0.2
- **Java**: 21
- **Build Tool**: Maven
- **Embedded Server**: Tomcat 11.0.15

## Getting Started

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### Run Tests

```bash
mvn test
```

## Building for Production

To create an executable JAR file:

```bash
mvn clean package
```

The JAR file will be created in the `target/` directory. Run it with:

```bash
java -jar target/route-manager-0.0.1-SNAPSHOT.jar
```
## Swagger API Documentation

The application provides interactive API documentation using Swagger UI. After starting the application, you can access the Swagger UI in your browser:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)

This interface allows you to explore and test the available REST endpoints directly from your browser.

## NOTES: 
 - Project works from static country list, but it can be easily extended to read from a database or external API. The current implementation is designed for simplicity and demonstration purposes.
 - Fetching countries could be implement with Feign client.