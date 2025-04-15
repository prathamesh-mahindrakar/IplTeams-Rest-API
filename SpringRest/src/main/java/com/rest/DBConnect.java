package com.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	
	public static Connection getDBConn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/SpringJDBC","root","root4321");
		return connection;
	}
}
