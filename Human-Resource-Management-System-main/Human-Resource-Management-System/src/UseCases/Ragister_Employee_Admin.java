package UseCases;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;
import Exceptions.Employee_Exception;
import JavaBean.Employee;


/*--------------------------------------------     Register Employee By Admin   -----------------------------------------------*/

public class Ragister_Employee_Admin {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImp() ;
		Employee employee = new Employee() ;
		
		try {
			String result = employeeDao.ragisterEmployee(employee) ;
			System.out.println(result);
		} catch (Employee_Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
