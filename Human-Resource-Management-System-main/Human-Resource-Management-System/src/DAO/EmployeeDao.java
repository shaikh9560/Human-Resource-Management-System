package DAO;

import java.util.List;

import Exceptions.Employee_Exception;
import JavaBean.Employee;
import JavaBean.Leaves;

public interface EmployeeDao {
	
	public String ragisterEmployee(Employee employee) throws Employee_Exception ;
	public String transferEmployee (int empId , int deptId) throws Employee_Exception ;
	public List<Leaves> getLeavesList() throws Employee_Exception ;
	public List<Employee> viewEmployee() throws Employee_Exception ;
	public List<Employee> viewEmployeeByDepartment(int deptId) throws Employee_Exception ;
	public String acceptLeave(int empId) ;
	public String rejectLeave(int empId) ;
	public boolean adminLogin(String username , String password) throws Employee_Exception;

}
