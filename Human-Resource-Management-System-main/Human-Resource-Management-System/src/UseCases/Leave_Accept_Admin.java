package UseCases;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;

public class Leave_Accept_Admin {
	public static void main(String[] args) {
		
		EmployeeDao edao = new EmployeeDaoImp() ;
		
		String result = edao.acceptLeave(1) ;
		System.out.println(result);
	}

}
