package DAO;

import java.util.List;

import Exceptions.Department_Exception;
import JavaBean.Department;

public interface DepartmentDao {
	
	public abstract String addDepartment(Department department) throws Department_Exception;
	
	public abstract String updateDepartmentName(String original ,String after );
	
	public abstract String updateDepartmentLocation(String deptName , String location) ;
	
	public abstract List<Department> viewDepartment() throws Department_Exception ;
	
	

}
