# java-jdbc-mysql-practice
This exercise was developed using multiple projects: JDBC1, JDBC2, JDBC3, etc 

Clone the project before implementing each new feature will be helpful for a better understanding of each step in future consultations on this project.

## Before create the project - configuration using Eclipse IDE:
1. Download the MySQL Java Connector. Save the jar mysql-connector-java-5.1.48.jar under `C:/java-libs/jdbc-connectors`

2. Eclipse - create an user library called MySQLConnector containing the MySQL driver .jar: 
`Window -> Preferences -> Java -> Build path -> User Libraries -> Add external JARs` 

3. Import the library MySqlConnector and create the project.
`Create a new Java project  -> Add the user library MySqlConnector -> create`

4. For the database:
    - Download MySQL Workbench
    - Create the database `coursejdbc`
    - Create the table `department` containing the columns Id(int), Name(varchar60).
    - Create the table `seller` containing the columns Id(int), Name(varchar60), Email(varchar100), BirthDate(datetime), BaseSalary(double), DepartmentId(int).

# JDBC1
Create mysql database connection with jdbc.
- DB.java - Class containing methods for the mysql database connection with jdbc.
- DbException.java - My personalized exception of type RuntimeException (don't require any treatment, as the use of try-catch block).
- Program.java - Use of DB.java class to open and close the database connection.

# JDBC2
- Program.java - Add logic to GET data from "department" table.
- DB.java - Create static helper methods to close ResultSet and Statement.

- Use of JDBC API classes: 
    - Statement
    - ResultSet - first(), beforeFirst(), next(), absolute(int)

# JDBC3
- Program.java - Add logic to INSERT data to "seller" table.
    - Simple insertion using preparedStatement.
    - Insertion using id recovery.

- Use of JDBC API classes: 
    - PreparedStatement
    - executeUpdate()
    - Statement.RETURN_GENERATED_KEYS
    - getGeneratedKeys()

# JDBC4
- Program.java - Add logic to UPDATE data, update the column "BaseSalary" from "seller" table.

# JDBC5
- Program.java - Add logic to DELETE data, delete a department.

- DbIntegrityException.java
    - Create a personalized exception DbIntegrityException of type RuntimeException (don't require any treatment, as the use of try-catch block).
    - Handle referential integrity exception: MySQLIntegrityConstraintViolationException (when trying to delete a department which is associated to any seller).
        - throw new DbIntegrityException(e.getMessage());

