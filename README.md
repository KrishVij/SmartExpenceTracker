# Smart Expense Tracker

A deliberately small Spring Boot MVC project for understanding the complete request flow.

## Features

- Add, list and delete expenses
- Set a monthly budget
- Set a savings goal and record the amount saved so far
- Dashboard with current-month spending and category totals

## Technology

- Java 8
- Spring Boot 2.7.18
- Spring MVC
- Spring Data JPA / Hibernate
- MySQL
- JSP and JSTL

## 1. Create the database

Open MySQL and run:

```sql
CREATE DATABASE expense_tracker;
```

## 2. Configure the database password

Open `src/main/resources/application.properties` and replace:

```properties
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

with your local MySQL password. The username is `root` by default; change it if yours is different.

## 3. Run

From the project root:

```bash
mvn spring-boot:run
```

Open http://localhost:8080

Maven and a local MySQL server must be installed and running.

## Project structure

```text
src/main/java/org/example
├── SmartExpenseTrackerApplication.java
├── Controller
│   ├── DashboardController.java
│   ├── ExpenseController.java
│   └── PlanController.java
├── Entity
│   ├── ExpenseEntity.java
│   └── PlanEntity.java
├── Repository
│   ├── ExpenseRepository.java
│   └── PlanRepository.java
└── Service
    ├── ExpenseService.java
    └── ExpenseServiceImpl.java

src/main
├── resources
│   ├── application.properties
│   └── static/style.css
└── webapp/WEB-INF/views
    ├── dashboard.jsp
    ├── expenses.jsp
    └── plan.jsp
```

## How the application works

1. A browser requests a URL such as `/expenses`.
2. A Controller receives the request.
3. The Controller calls a method on `ExpenseService`.
4. `ExpenseServiceImpl` contains the application logic and calls a Repository.
5. Spring Data JPA Repository reads or writes Entity objects in MySQL.
6. The Controller puts data into the `Model` and returns a JSP view name.
7. Spring resolves that view to a JSP under `/WEB-INF/views`.

## Important design choices

- `ExpenseEntity` represents one expense row in the database.
- `PlanEntity` stores the monthly budget and one savings goal. This is intentionally a single-plan demo, not a multi-user finance system.
- `ExpenseRepository` extends `JpaRepository`, so basic save, find, and delete methods are provided by Spring Data JPA.
- `findByExpenseDateBetween` is a derived query method. Spring Data JPA creates the query from its name.
- Category totals are calculated in Java from the current month's expenses to keep the example easy to follow.
- `spring.jpa.hibernate.ddl-auto=update` lets Hibernate create/update the tables during local development.

## Scope / limitations

This is an interview-learning demo, not a production finance application. It has no login, user separation, bank integration, recurring expenses, or CSRF/security configuration. The delete action is intentionally simple for this local demo.
