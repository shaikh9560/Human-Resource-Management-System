package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

	public static Connection getConnection() {
		Connection conn = null ;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver") ;
			String url = "jdbc:mysql://localhost:3306/HRMS" ;
			
			try {
				conn = DriverManager.getConnection(url, "root", "9953");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		return conn ;
	}
}
