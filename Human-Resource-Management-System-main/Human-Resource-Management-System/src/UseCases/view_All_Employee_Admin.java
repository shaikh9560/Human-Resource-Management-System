package UseCases;

import java.util.List;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;
import Exceptions.Employee_Exception;
import JavaBean.Employee;

public class view_All_Employee_Admin {

	public static void main(String[] args) {
		
	
		
		
		EmployeeDao edao = new EmployeeDaoImp() ;
		try {
			List<Employee> emp = edao.viewEmployee() ;
			System.out.println(emp);
		} catch (Employee_Exception e) {
			e.printStackTrace();
		}

	}

}
