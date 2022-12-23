package UseCases;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;

/*--------------------------------------------     Leave Reject By Admin   -----------------------------------------------*/

public class Leave_Reject_Admin {

	public static void main(String[] args) {
		
		EmployeeDao edao = new EmployeeDaoImp() ;
		String result = edao.rejectLeave(1) ;
		System.out.println(result);
	}

}
