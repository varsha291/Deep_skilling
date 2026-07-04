# Spring REST using Spring Boot - JWT Authentication

## 📌 Description
This project demonstrates how to secure RESTful Web Services using Spring Security and JSON Web Token (JWT). It includes authentication, authorization, role-based access, JWT generation, and JWT validation using Spring Boot.

---

# 🛠 Technologies Used

- Java 21
- Spring Boot
- Spring Security
- JWT (JJWT)
- Maven
- REST API
- IntelliJ IDEA
- Postman

---

# 📚 HandsOn 1 - Secure RESTful Web Services

### Objective
Secure REST APIs using Spring Security.

### Tasks Completed
- Added Spring Security dependency.
- Configured Spring Security.
- Secured REST endpoints.
- Tested Basic Authentication.

### Status
✅ Completed

---

# 📚 HandsOn 2 - Create Users and Roles

### Objective
Create in-memory users with roles.

### Tasks Completed
- Created ADMIN user.
- Created USER user.
- Configured Password Encoder.
- Restricted endpoint access using roles.

### Users

| Username | Password | Role |
|----------|----------|------|
| admin | pwd | ADMIN |
| user | pwd | USER |

### Status
✅ Completed

---

# 📚 HandsOn 3 - Create Authentication Controller

### Objective
Create authentication endpoint.

### Tasks Completed
- Created AuthenticationController.
- Added /authenticate endpoint.
- Returned authentication response.

### Endpoint

GET /authenticate

### Status
✅ Completed

---

# 📚 HandsOn 4 - Read Authorization Header

### Objective
Extract username from Authorization Header.

### Tasks Completed
- Read Authorization Header.
- Decoded Base64 credentials.
- Extracted username.
- Validated user.

### Status
✅ Completed

---

# 📚 HandsOn 5 - Generate JWT Token

### Objective
Generate JWT Token after successful authentication.

### Tasks Completed
- Added JJWT dependency.
- Created JwtUtil.
- Created JwtResponse model.
- Generated JWT Token.
- Added Token Expiry.

### Status
✅ Completed

---

# 📚 HandsOn 6 - JWT Authentication

### Objective
Authenticate users using JWT.

### Tasks Completed
- Updated AuthenticationController.
- Generated JWT using authenticated user.
- Returned JWT Response.
- Tested using Postman.

### Status
✅ Completed

---

# 📚 HandsOn 7 - JWT Authorization

### Objective
Authorize REST APIs using JWT Token.

### Tasks Completed
- Created JwtAuthorizationFilter.
- Configured SecurityConfig.
- Validated JWT Token.
- Protected REST APIs.
- Tested Bearer Token Authentication.

### Protected Endpoint

GET /countries

Authorization Header

Authorization: Bearer <JWT_TOKEN>

### Status
✅ Completed

---

# 📂 Project Structure

```
src
├── controller
│   ├── CountryController
│   └── AuthenticationController
│
├── security
│   ├── SecurityConfig
│   └── JwtAuthorizationFilter
│
├── util
│   └── JwtUtil
│
├── model
│   └── JwtResponse
│
└── SpringLearnApplication
```

---

# 🚀 Features

- Spring Security
- HTTP Basic Authentication
- Role-Based Authorization
- Authentication Controller
- Authorization Header Processing
- JWT Token Generation
- JWT Validation
- JWT Authorization Filter
- Protected REST APIs
- Bearer Token Authentication

---

# ✅ Testing

- Basic Authentication using Postman
- JWT Token Generation
- JWT Validation
- Access Protected APIs using Bearer Token

---

# 🎯 Learning Outcomes

- Spring Security Configuration
- User Authentication
- Role-Based Authorization
- JWT Authentication
- JWT Authorization
- Spring Security Filters
- REST API Security
- Token-Based Authentication

---

# ✅ Project Status

| HandsOn | Status |
|---------|--------|
| HandsOn 1 | ✅ Completed |
| HandsOn 2 | ✅ Completed |
| HandsOn 3 | ✅ Completed |
| HandsOn 4 | ✅ Completed |
| HandsOn 5 | ✅ Completed |
| HandsOn 6 | ✅ Completed |
| HandsOn 7 | ✅ Completed |

---

# 🎉 Overall Status

**Document 5 - JWT Authentication Successfully Completed**