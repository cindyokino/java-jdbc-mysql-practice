package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
			
			//SQL command: prepared statement + attribute values
			
			//prepared statement
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS); //to return the auto-generated id of the new seller inserted to the db
			
			//attribute values to each '?'
			st.setString(1, "Carl Purple");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("1995/04/27").getTime())); //NOTE: it's not java.util.Date
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate(); //tells how many lines were changed at the database
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1); //it will get the value from the first column (Id)
					System.out.println("Done! Inserted a seller.  Id = " + id);
				}
			} else {
				System.out.println("No rows affected!");
			}
		} 
		catch (SQLException e) { //for the connection - line 21
			e.printStackTrace();
		} 
		catch (ParseException e) { //for the date parse - line 36
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
}