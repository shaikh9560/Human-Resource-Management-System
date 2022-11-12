package UseCases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.DepartmentDao;
import DAO.DepartmentDaoImp;
import Util.Util;

public class Update_Department_Admin {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = new DepartmentDaoImp() ;

		
		String deptName = "Java" ;
		String location = "Delhi" ;
		String result = departmentDao.updateDepartmentLocation(deptName, location) ;
		System.out.println(result);
	}

}
