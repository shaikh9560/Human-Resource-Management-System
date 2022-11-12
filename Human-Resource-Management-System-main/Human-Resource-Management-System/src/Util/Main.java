package Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Connection conn = Util.getConnection() ;
		System.out.println(conn);
		try {
			PreparedStatement ps = conn.prepareStatement("show tables") ;
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				String table = rs.getString(1) ;
				System.out.println(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
