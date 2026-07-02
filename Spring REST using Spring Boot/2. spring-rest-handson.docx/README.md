# Spring REST using Spring Boot

This repository contains the implementation of Spring REST Web Services using Spring Boot. The project demonstrates creating REST APIs, handling requests and responses, exception handling, and testing REST endpoints using MockMvc.

## Technologies Used

- Java 21
- Spring Boot 3.5.16
- Spring Web
- Spring Context
- Maven
- JUnit 5
- MockMvc
- IntelliJ IDEA

## Hands-On Completed

### HandsOn 1 - Hello World REST Service
- Created a REST API using `@RestController`
- Implemented `/hello` endpoint
- Returned **Hello World!!**

### HandsOn 2 - Country REST Service
- Implemented `/country` endpoint
- Loaded Country bean from `country.xml`
- Returned country details in JSON format

### HandsOn 3 - Get All Countries
- Implemented `/countries` endpoint
- Loaded all countries from XML configuration
- Returned list of countries

### HandsOn 4 - Get Country by Code
- Implemented `/countries/{code}`
- Used `@PathVariable`
- Performed case-insensitive country search
- Added Service layer

### HandsOn 5 - Exception Handling
- Created `CountryNotFoundException`
- Used `@ResponseStatus`
- Returned appropriate error for invalid country codes

### HandsOn 6 - MockMvc Testing
- Implemented unit testing using MockMvc
- Tested controller loading
- Tested REST endpoints
- Validated JSON response
- Executed JUnit test cases successfully

## Project Structure

```
spring-learn
│
├── controller
│   ├── HelloController.java
│   └── CountryController.java
│
├── service
│   └── CountryService.java
│
├── exception
│   └── CountryNotFoundException.java
│
├── Country.java
├── country.xml
└── SpringLearnApplication.java
```

## REST Endpoints

| Method | Endpoint | Description |
|----------|----------------|-----------------------------|
| GET | `/hello` | Returns Hello World |
| GET | `/country` | Returns India details |
| GET | `/countries` | Returns all countries |
| GET | `/countries/{code}` | Returns country by code |

## Testing

- JUnit 5
- Spring Boot Test
- MockMvc

## Outcome

Successfully implemented RESTful Web Services using Spring Boot with:
- REST Controllers
- XML Bean Configuration
- Service Layer
- Exception Handling
- MockMvc Testing

---
**Developed as part of Spring REST using Spring Boot Hands-On Exercises.**