# Student CRUD Application (Java + MySQL)

This is a simple **Java console application** to perform CRUD (Create, Read, Update, Delete) operations on a MySQL `students` table using **JDBC (Java Database Connectivity)**.

## Features

- Add a new student record
- View all student records
- Update a student record
- Delete a student record
- Interactive console-based menu

## Technologies Used

- Java
- JDBC
- MySQL

## Database Setup

1. **Create Database:**
   ```sql
   CREATE DATABASE studentdb;

2.**Create Database:**

USE studentdb;
CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    age INT
);


Prerequisites
Java installed (JDK 8 or above)

MySQL installed and running

MySQL JDBC driver (mysql-connector-java) added to your classpath


To run 

1.  Clone or download the project source.

2. Update database credentials if needed:

  static final String URL = "jdbc:mysql://localhost:3306/studentdb";
  static final String USER = "root";
  static final String PASSWORD = "";


3. Compile and run the Java program:
  javac StudentCRUD.java
  java StudentCRUD



4. Follow the console menu to perform operations:
    --- Student CRUD Menu ---
    1. Add Student
    2. View Students
    3. Update Student
    4. Delete Student
    5. Exit
    Enter your choice:

