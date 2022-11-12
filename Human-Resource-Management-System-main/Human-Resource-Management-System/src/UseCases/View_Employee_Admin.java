package UseCases;

import DAO.EmployeeLeveImp;
import DAO.EmployeeLevel;
import Exceptions.Employee_Exception;
import JavaBean.EmployeeDto;

public class View_Employee_Admin {
	public static void main(String[] args) {
		
		EmployeeLevel emp = new EmployeeLeveImp() ;
		try {
			EmployeeDto details = emp.viewDetails(1) ;
			System.out.println(details);
		} catch (Employee_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
