# Spring REST using Spring Boot

## Cognizant Digital Nurture Program

### Hands-On 3 - RESTful Web Services

## Project Overview

This project demonstrates the implementation of RESTful Web Services using Spring Boot. The application follows the Controller-Service-DAO architecture and uses Spring XML configuration to manage Employee and Department data.

---

# Module 1: Create Static Employee List using Spring XML

## Objective

Configure Employee and Department data using Spring XML.

### Implemented

- Created Department beans
- Created Skill beans
- Created Employee beans
- Created Employee List
- Created Department List
- Configured all data in `employee.xml`

### Files Used

- employee.xml
- Employee.java
- Department.java
- Skill.java

---

# Module 2: Create Employee REST Service

## Objective

Develop a REST API to retrieve all employees.

### Implemented

### DAO Layer

- EmployeeDao
- Static Employee List
- Read Employee data from Spring XML

### Service Layer

- EmployeeService
- @Service Annotation
- @Transactional Annotation

### Controller Layer

- EmployeeController
- GET /employees

### REST API

**Endpoint**

```
GET /employees
```

**Description**

Returns the complete list of employees.

---

# Module 3: Create Department REST Service

## Objective

Develop a REST API to retrieve all departments.

### Implemented

### DAO Layer

- DepartmentDao
- Static Department List
- Read Department data from Spring XML

### Service Layer

- DepartmentService
- @Service Annotation
- @Transactional Annotation

### Controller Layer

- DepartmentController
- GET /departments

### REST API

**Endpoint**

```
GET /departments
```

**Description**

Returns the complete list of departments.

---

# Technologies Used

- Java 21
- Spring Boot 3.5.16
- Maven
- Spring Web
- Spring Boot DevTools
- Spring Transaction Management
- Spring XML Configuration
- RESTful Web Services
- Postman

---

# Project Structure

```
spring-learn
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.cognizant.spring_learn
│   │   │       ├── controller
│   │   │       │   ├── EmployeeController.java
│   │   │       │   └── DepartmentController.java
│   │   │       │
│   │   │       ├── service
│   │   │       │   ├── EmployeeService.java
│   │   │       │   └── DepartmentService.java
│   │   │       │
│   │   │       ├── dao
│   │   │       │   ├── EmployeeDao.java
│   │   │       │   └── DepartmentDao.java
│   │   │       │
│   │   │       ├── model
│   │   │       │   ├── Employee.java
│   │   │       │   ├── Department.java
│   │   │       │   └── Skill.java
│   │   │       │
│   │   │       └── SpringLearnApplication.java
│   │   │
│   │   └── resources
│   │       └── employee.xml
│   │
│   └── test
│
├── pom.xml
└── README.md
```

---

# API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/employees` | Retrieve all employees |
| GET | `/departments` | Retrieve all departments |

---

# Testing

The REST APIs were tested successfully using Postman.

### Verified Endpoints

- GET `/employees`
- GET `/departments`

---

# Learning Outcomes

- Spring Boot REST API Development
- Spring XML Configuration
- Controller-Service-DAO Architecture
- Dependency Injection
- Transaction Management
- REST API Development
- Postman API Testing

---

# Author

**Jakkula Varsha**

Cognizant Digital Nurture Program