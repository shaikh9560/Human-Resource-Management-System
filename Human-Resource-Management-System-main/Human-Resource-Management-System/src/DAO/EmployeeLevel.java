package DAO;

import Exceptions.Employee_Exception;
import JavaBean.EmployeeDto;

public interface EmployeeLevel {
	
	public abstract EmployeeDto viewDetails(int empId) throws Employee_Exception ;
	public abstract String applyForLeave(int empId , int day , String resaon);
	public abstract String updatePassword(int empId , String password) ;
	public boolean employeeLogin(String username, String password) throws Employee_Exception ;
	public abstract int empId(String username)  ;

}
