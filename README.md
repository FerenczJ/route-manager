# Route Manager

A Spring Boot 4.0.2 application for managing routes.

## Requirements

- Java 17 or higher
- Maven 3.6+

## Building the Application

```bash
mvn clean install
```

## Running the Application

```bash
mvn spring-boot:run
```

Or run the JAR directly:

```bash
java -jar target/route-manager-0.0.1-SNAPSHOT.jar
```

The application will start on port 8080.

## API Endpoints

- `GET /api/health` - Health check endpoint
- `GET /api/routes` - Route manager API information

## Testing

Run the tests with:

```bash
mvn test
```

## Technology Stack

- Spring Boot 4.0.2
- Java 17
- Maven