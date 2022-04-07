package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Class for create or close the connection with the database
public class DB {
	
	//object for jdbc database connection
	private static Connection conn = null; 
	
	//method to connect to the database
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties(); //get the database properties using the method created below
				String url = props.getProperty("dburl"); //database url (value from dburl defined at the db.propeties file)
				conn = DriverManager.getConnection(url, props); //Obtain the db connection, save it into the conn object
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//method to close the connection with the database
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();				
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() {
		//try to open the file db.properties, read the data and save it into an object of type Properties
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs); //read the file and save values into the props object
			return props;
		} 
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
