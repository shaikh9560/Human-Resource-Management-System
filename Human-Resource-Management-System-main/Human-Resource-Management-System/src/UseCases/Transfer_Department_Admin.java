package UseCases;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;
import Exceptions.Employee_Exception;

public class Transfer_Department_Admin {
	public static void main(String[] args) {
		
		EmployeeDao  employeeDao = new EmployeeDaoImp() ;
		int empId = 1 ;
		int deptId = 4 ;
		
		try {
			String result  = employeeDao.transferEmployee(empId, deptId) ;
			System.out.println(result);
		} catch (Employee_Exception e) {
			e.printStackTrace();
		}
	}

}
