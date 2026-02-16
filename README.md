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

## API Endpoints

### Health Check

```bash
GET /api/health
```

**Example:**
```bash
curl http://localhost:8080/api/health
```

**Response:**
```
Route Manager is running with Spring Boot 4.0.2
```

## Project Structure

```
route-manager/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/routemanager/
│   │   │       ├── RouteManagerApplication.java
│   │   │       └── controller/
│   │   │           └── RouteController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/routemanager/
│               └── RouteManagerApplicationTests.java
├── pom.xml
└── README.md
```

## Configuration

Application configuration is located in `src/main/resources/application.properties`:

- `spring.application.name=route-manager`
- `server.port=8080`

## Building for Production

To create an executable JAR file:

```bash
mvn clean package
```

The JAR file will be created in the `target/` directory. Run it with:

```bash
java -jar target/route-manager-0.0.1-SNAPSHOT.jar
```