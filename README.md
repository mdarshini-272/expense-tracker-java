# Expense Tracker using Java, JDBC & MySQL

A console-based Expense Tracker application developed using Java, JDBC, and MySQL. It allows users to add, view, update, delete, search, and calculate total expenses through a menu-driven interface while demonstrating CRUD operations and the DAO design pattern.

## Features

- Add Expense
- View Expenses
- Update Expense
- Delete Expense
- Search Expenses by Category
- View Total Expenses
- Menu-driven Console Interface
- DAO Design Pattern
- Secure database operations using PreparedStatement

## Technologies Used

- Java 17
- Object-Oriented Programming (OOP)
- MySQL
- JDBC
- Git
- GitHub

## Project Structure

```
Expense Tracker
│
├── Main.java
├── Expense.java
├── ExpenseDAO.java
├── DBConnection.java
└── README.md
```

## Database

Database Name:

```
darshini_db
```

Table:

```
expenses
```
Columns:

| Column | Type |
|--------|------|
| id | INT (Primary Key, Auto Increment) |
| title | VARCHAR |
| amount | DOUBLE |
| category | VARCHAR |
| expense_date | DATE |

## How to Run

1. Clone the repository.
2. Import the project into VS Code or IntelliJ IDEA.
3. Create the MySQL database and expenses table.
4. Update the database username and password in `DBConnection.java`.
5. Run `Main.java`.

## Learning Outcomes

Through this project I learned:

- Java OOP Basics
- JDBC
- MySQL Integration
- DAO Pattern
- CRUD Operations
- PreparedStatement
- Git & GitHub

## Future Improvements

- User Authentication
- Monthly Expense Reports
- Expense Categories Dashboard
- Export Expenses to CSV
- Spring Boot REST API version
- Graphical User Interface (GUI)

## Author

**M Darshini**