package UseCases;

import java.util.Scanner;

import DAO.DepartmentDao;
import DAO.DepartmentDaoImp;
import Exceptions.Department_Exception;

import JavaBean.Department;

public class Add_Department_Admin {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		
		System.out.println("Enter Name of Department ");
		String name = sc.next();
		
		System.out.print("****");
		
		System.out.println("Enter Department Location..");
		String location = sc.next();
		
		
		Department deparment = new Department();
		
		//deparment.setDeparmentId(depID);
		deparment.setDeptName(name);
        deparment.setDeptLoc(location);
        
		
		
		DepartmentDao  adDepartment = new DepartmentDaoImp() ;
		
		
		try {
			String result = adDepartment.addDepartment((Department) adDepartment) ;
			System.out.println(result);
		} catch (Department_Exception e) {
			e.printStackTrace();
		}
		
	}

}

