package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	
	private static final String URL = "jdbc:mysql://localhost:3306/hr?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connection is up");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		try {
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT first_name, last_name FROM employees");
			
			result.next();
			System.out.println(result.getString("first_name"));
			System.out.println(result.getString("last_name"));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
