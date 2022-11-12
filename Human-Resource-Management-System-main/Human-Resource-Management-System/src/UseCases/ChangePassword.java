package UseCases;

import DAO.EmployeeLeveImp;
import DAO.EmployeeLevel;

public class ChangePassword {
	public static void main(String[] args) {
		
		EmployeeLevel emp = new EmployeeLeveImp() ;
		int empId = 1 ;
		String password = "123" ;
		String result = emp.updatePassword(empId, password) ;
		System.out.println(result);
	}

}
