package UseCases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import DAO.EmployeeDao;
import DAO.EmployeeDaoImp;
import Exceptions.Employee_Exception;
import JavaBean.Employee;
import Util.Util;


/*--------------------------------------------     Add Employee   -----------------------------------------------*/
public class Add_Employee_Admin {
	
	public static void main(String[] args) {
		
		EmployeeDao employeeDao = new EmployeeDaoImp() ;
        Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter UserNmae");
		String username= sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		
		
		System.out.println("Enter DepId");
		int  depid = sc.nextInt();
		
		
		
		System.out.println("Enter Salary");
		int  sal = sc.nextInt();

		
		System.out.println("Enter Joining Data");
		String date = sc.next();
		
		System.out.println("Enter Leave Available");
		int leaveAva = sc.nextInt();
		
		System.out.println("Enter Manager ID");
		int  manid = sc.nextInt();
		
		Employee employee = new Employee();
		
		
		
		employee.setName(name);
		employee.setUsername(username);
		employee.setPassword(pass);
		
		employee.setDeptId(depid);
		
		employee.setSalary(sal);
		employee.setJoinDate(date);
		employee.setLeaveAvi(leaveAva);
		employee.setMangId(manid);

		
		try {
			String result = employeeDao.ragisterEmployee(employee) ;
			System.out.println(result);
		} catch (Employee_Exception e) {
			e.printStackTrace();
		}
		
	}

}
