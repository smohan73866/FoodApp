package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String url=System.getenv("jdbc:mysql://mysql-mohan.alwaysdata.net:3306/foodapp");
	static String user=System.getenv("mohan_foodapp");
	static String password=System.getenv("Vijay@123#");
	static Connection con;
	public static Connection getConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,user,password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}


}
