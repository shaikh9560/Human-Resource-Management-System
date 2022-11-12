package UseCases;

import java.util.List;

import DAO.DepartmentDao;
import DAO.DepartmentDaoImp;
import Exceptions.Department_Exception;
import JavaBean.Department;

public class view_Department_Admin {

	public static void main(String[] args) {
		
		DepartmentDao ddao = new DepartmentDaoImp() ;
		try {
			List<Department> dep = ddao.viewDepartment() ;
			System.out.println(dep);
		} catch (Department_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
