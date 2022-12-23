package UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.EmployeeLeveImp;
import DAO.EmployeeLevel;
import Util.Util;


/*--------------------------------------------     Leave Apply By Employee   -----------------------------------------------*/

public class Leave_Apply_Emp {
	
	public static void main(String[] args) {
		
		EmployeeLevel emp = new EmployeeLeveImp() ;
		int empId = 1 ;
		int day = 5 ;
		String reason = "Fever" ;
		
		String result = emp.applyForLeave(empId, day, reason) ;
		System.out.println(result);
	}
}
