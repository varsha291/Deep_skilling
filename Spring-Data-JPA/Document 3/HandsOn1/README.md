# HandsOn1 - Introduction to HQL & JPQL

## Objective

The objective of this hands-on is to understand Hibernate Query Language (HQL) and Java Persistence Query Language (JPQL), their syntax, features, and advantages over SQL.

---

# What is HQL?

Hibernate Query Language (HQL) is an object-oriented query language provided by Hibernate.

Unlike SQL, HQL works with Java Entity classes and their properties instead of database tables and columns.

### Example

```java
FROM Employee
```

Here, `Employee` is a Java Entity class, not a database table.

---

# Features of HQL

* Object-oriented query language
* Database independent
* Works on Entity classes
* Supports CRUD operations
* Supports Joins
* Supports Aggregate Functions
* Supports Ordering and Grouping

---

# Advantages of HQL

* Portable across different databases
* Easy to understand
* Reduces dependency on database-specific SQL
* Supports object-oriented programming concepts
* Easy integration with Hibernate ORM

---

# What is JPQL?

Java Persistence Query Language (JPQL) is the standard query language defined by JPA (Java Persistence API).

Hibernate implements JPQL internally.

JPQL is very similar to HQL and is also object-oriented.

### Example

```java
SELECT e FROM Employee e
```

---

# Features of JPQL

* Uses Entity objects instead of tables
* Database independent
* Supports joins
* Supports aggregate functions
* Supports subqueries
* Supports sorting and grouping

---

# HQL vs SQL

| HQL                    | SQL                  |
| ---------------------- | -------------------- |
| Uses Entity Classes    | Uses Database Tables |
| Uses Object Properties | Uses Column Names    |
| Database Independent   | Database Dependent   |
| Object-Oriented        | Relational           |

---

# HQL Aggregate Functions

* COUNT()
* SUM()
* AVG()
* MIN()
* MAX()

Example:

```java
SELECT AVG(e.salary) FROM Employee e
```

---

# HQL Clauses

* SELECT
* FROM
* WHERE
* ORDER BY
* GROUP BY
* HAVING

---

# Conclusion

HQL and JPQL simplify database operations by allowing developers to write object-oriented queries. They improve portability, readability, and maintainability of applications developed using Hibernate and JPA.
