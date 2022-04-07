# java-jdbc-mysql-practice


### Before create the project - configuration using Eclipse IDE:
1. Download the MySQL Java Connector. Save the jar mysql-connector-java-5.1.48.jar under `C:/java-libs/jdbc-connectors`

2. Eclipse - create an user library called MySQLConnector containing the MySQL driver .jar: 
`Window -> Preferences -> Java -> Build path -> User Libraries -> Add external JARs` 

3. Import the library MySqlConnector and create the project.
`Create a new Java project  -> Add the user library MySqlConnector -> create`

# JDBC1
Create mysql database connection with jdbc.

# JDBC2
Application - Add logic to get data from "department" column.

DB class - create static helper methods to close ResultSet and Statement.

Use of JDBC API classes: 
- Statement
- ResultSet - first(), beforeFirst(), next(), absolute(int)


