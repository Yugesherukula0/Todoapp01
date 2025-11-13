package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	static final String URL="jdbc:mysql://localhost:3306/todo";
	static final String USER_NAME="root";
	static final String PASSWORD="root";
	static Connection con=null;
	
	public Connection dbConnect() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(URL,USER_NAME,PASSWORD);
		return con;
	}

}
