package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
			
			//***** BEGIN transaction - bloc setAutoCommit(false) / commit() *****
			conn.setAutoCommit(false); //operations will not be confirmed automatically, all operations will wait for an explicit confirmation.
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			//Simulate an error during the transaction
			//with this error the rows1 will be executed, but not rows2
			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}
			
			int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

			conn.commit(); //confirm the operations.
			//***** END transaction - bloc setAutoCommit(false) / commit() *****
			
			System.out.println("rows1 = " + rows1);
			System.out.println("rows2 = " + rows2);
			
		}
		catch (SQLException e) {
			try {
				conn.rollback(); //return database to the initial status, so it will not have the operations executed partially.
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage()); //inform that the transaction was not completed.
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e.getMessage());
			} 
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
}