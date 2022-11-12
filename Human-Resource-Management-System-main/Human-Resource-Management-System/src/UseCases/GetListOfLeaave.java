package UseCases;

import java.util.List;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;
import Exceptions.Employee_Exception;
import JavaBean.Leaves;

public class GetListOfLeaave {
	
	public static void main(String[] args) {
		
		EmployeeDao emp = new EmployeeDaoImp() ;
		try {
			List<Leaves> list = emp.getLeavesList() ;
			System.out.println(list);
		} catch (Employee_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
