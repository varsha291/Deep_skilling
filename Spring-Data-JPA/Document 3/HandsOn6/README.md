# HandsOn6 - Criteria API

## Objective

The objective of this hands-on is to understand the Hibernate Criteria API, its features, advantages, and how it is used to build dynamic and type-safe database queries programmatically.

# What is Criteria API?

Criteria API is a query-building API provided by JPA and Hibernate that allows developers to create database queries using Java code instead of writing HQL or SQL statements.

It is especially useful when queries need to be built dynamically based on user input.


# Why use Criteria API?

* Eliminates manual query writing.
* Provides type safety.
* Reduces syntax errors.
* Makes dynamic query creation easier.
* Improves maintainability.


# Advantages of Criteria API

* Object-Oriented Query Building
* Type Safe
* Dynamic Query Generation
* Database Independent
* Easy to Maintain
* Reduces SQL/HQL Syntax Errors


# Main Classes Used

## 1. EntityManager

Used to interact with the persistence context.

Example:

```java
EntityManager entityManager;
```

## 2. CriteriaBuilder

Used to create CriteriaQuery objects.

Example:

```java
CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
```

## 3. CriteriaQuery

Represents the query definition.

Example:

```java
CriteriaQuery<Employee> criteriaQuery =
criteriaBuilder.createQuery(Employee.class);
```

## 4. Root

Represents the entity being queried.

Example:

```java
Root<Employee> root = criteriaQuery.from(Employee.class);
```

## 5. Predicate

Represents conditions in the WHERE clause.

Example:

```java
Predicate predicate =
criteriaBuilder.equal(root.get("permanent"), true);
```

## Steps to Create a Criteria Query

1. Obtain EntityManager.
2. Create CriteriaBuilder.
3. Create CriteriaQuery.
4. Define the Root entity.
5. Add conditions using Predicate.
6. Execute the query using TypedQuery.
7. Retrieve the result.

# Criteria API Flow

```text
EntityManager
      │
      ▼
CriteriaBuilder
      │
      ▼
CriteriaQuery
      │
      ▼
Root<Entity>
      │
      ▼
Predicate (Conditions)
      │
      ▼
TypedQuery
      │
      ▼
Result List
```

# Example Workflow

```java
CriteriaBuilder cb = entityManager.getCriteriaBuilder();

CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

Root<Employee> employee = cq.from(Employee.class);

cq.select(employee);

TypedQuery<Employee> query = entityManager.createQuery(cq);

List<Employee> employees = query.getResultList();
```

# HQL vs Criteria API

| HQL                         | Criteria API                       |
| --------------------------- | ---------------------------------- |
| Query written as String     | Query built using Java Objects     |
| Suitable for static queries | Suitable for dynamic queries       |
| Less Type Safe              | Completely Type Safe               |
| Easy for simple queries     | Better for complex dynamic queries |


# Applications of Criteria API

* Search Filters
* Employee Management Systems
* E-Commerce Product Search
* Banking Applications
* Dynamic Report Generation
* Enterprise Applications

# Conclusion

Criteria API is a powerful feature of JPA and Hibernate that enables developers to build dynamic, object-oriented, and type-safe queries. It improves code readability, maintainability, and flexibility while reducing the chances of query syntax errors.
