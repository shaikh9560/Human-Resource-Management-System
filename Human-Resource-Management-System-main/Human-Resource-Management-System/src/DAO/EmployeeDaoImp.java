package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Exceptions.Department_Exception;
import Exceptions.Employee_Exception;
import JavaBean.Department;
import JavaBean.Employee;
import JavaBean.Leaves;
import Util.Util;

public class EmployeeDaoImp implements EmployeeDao {

	@Override
	public String ragisterEmployee(Employee employee) throws Employee_Exception  {
		String result = "Not Added" ;
		if(employee.getJoinDate().length() <= 1 || employee.getName().length() <= 1 || employee.getPassword().length() <= 1 || employee.getUsername().length() <= 1){
			return "Enter proper details" ;
		}
		 try(Connection conn = Util.getConnection()) {
			 String query = "insert into employee(empName,empuser,emppass,empDepId,empSal,empJoin,empLeave,empMangId) "+
					 		"values(? , ? , ? , ? , ? , ? , ? , ?)";
			 
			 PreparedStatement ps = conn.prepareStatement(query) ;
			 ps.setString(1, employee.getName());
			 ps.setString(2, employee.getUsername());
			 ps.setString(3, employee.getPassword());
			 ps.setInt(4, employee.getDeptId());
			 ps.setInt(5, employee.getSalary());
			 ps.setString(6, employee.getJoinDate());
			 ps.setInt(7, employee.getLeaveAvi());
			 ps.setInt(8, employee.getMangId());
			 
			 int x = ps.executeUpdate() ;
			 if(x>0) {
				 result = "Employee Ragister Successfully Username and password has been send to employee" ;
			 }
			 else
				 result = "Something went wrong" ;
			
		} catch (SQLException e) {
				result = e.getMessage() ;
		}
		
		
		return result ;
	}

	@Override
	public String transferEmployee(int empId , int deptId) throws Employee_Exception {
		
		String result = "Not Transfered" ;
		
		String query = "update employee set empDepId = ? where empId = ?" ;
		
		try(Connection conn = Util.getConnection()) {
			
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setInt(1, deptId);
			ps.setInt(2, empId);
			
			int x = ps.executeUpdate() ;
			if(x>0) {
				result = "Employee Transfered to deptId no: "+deptId ;
			}
			else {
				result = "Wrong Employee Id" ;
			}
			
		} catch (SQLException e) {
			result = e.getMessage() ;
			if(e.getMessage().equals("Cannot add or update a child row: a foreign key constraint fails (`hrms`.`employee`, CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`empDepId`) REFERENCES `department` (`deptId`))")) {
				result = "No Department Presnet with this Id Number" ;
			}
			
		}
		
		
		return result;
	}

	@Override
	public List<Leaves> getLeavesList() throws Employee_Exception {
		
		List<Leaves> list = new ArrayList<>() ;
		
		String query = "select * from leaves" ;
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery() ;
		while(rs.next()) {
			int empId = rs.getInt("empId") ;
			int leaveNo = rs.getInt("leave_NO") ;
			int leaveDay = rs.getInt("leaveday") ;
			String reason = rs.getString("leaveres") ;
			
			Leaves leaves = new Leaves(empId, leaveNo, leaveDay, reason) ;
			list.add(leaves) ;
		}
		
		if(list.size() == 0) {
			throw new Employee_Exception("There is no pending leave request") ;
		}
			
		} catch (SQLException e) {
			throw new Employee_Exception(e.getMessage()) ;
		}
		
		
		
		
		
		
		return list ;
	}

	@Override
	public List<Employee> viewEmployee() throws Employee_Exception {
List<Employee> employees = new ArrayList<>() ;
		
		
		String query = "select * from employee" ;
		
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				
				int empId = rs.getInt(1) ;
				String empName = rs.getString(2) ;
				String empuser = rs.getString(3) ;
				int depId = rs.getInt(5) ;
				int sal = rs.getInt(6) ;
				String date = rs.getDate(7).toString();
				int leave = rs.getInt(8);
				int mangId = rs.getInt(9) ;
				
				Employee emp = new Employee(empId, empuser, null, empName, depId, mangId, sal, date, leave) ;
				
				
				employees.add(emp) ;
			}
			
			if(employees.isEmpty()) {
				throw new Employee_Exception("No Employee exist please add employee first") ;
			}
			
		} catch (SQLException e) {
			throw new Employee_Exception(e.getMessage()) ;
		}
		
		
		
		
		
		
		
		return employees ;
	}

	@Override
	public List<Employee> viewEmployeeByDepartment(int deptId) throws Employee_Exception {
		
		List<Employee> employees = new ArrayList<>() ;
		

		
		String query = "select * from employee where empDepId = ? " ;
		
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setInt(1, deptId);
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				
				int empId = rs.getInt(1) ;
				String empName = rs.getString(2) ;
				String empuser = rs.getString(3) ;
				int depId = rs.getInt(5) ;
				int sal = rs.getInt(6) ;
				String date = rs.getDate(7).toString();
				int leave = rs.getInt(8);
				int mangId = rs.getInt(9) ;
				
				Employee emp = new Employee(empId, empuser, null, empName, depId, mangId, sal, date, leave) ;
				
				
				employees.add(emp) ;
			}
			
			if(employees.isEmpty()) {
				throw new Employee_Exception("No Employee exist please add employee first") ;
			}
			
		} catch (SQLException e) {
			throw new Employee_Exception(e.getMessage()) ;
		}
		
		
		
		
		
		
		
		
		return employees ;
	}

	@Override
	public String acceptLeave(int empId) {
		String result = "No Action taken" ;
		
		String query = "select empLeave from employee where empId = "+empId ;
		
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ResultSet rs = ps.executeQuery() ;
			if(rs.next()) {
				
				int ava = rs.getInt(1) ;
				
				String query2 = "select leaveday from leaves where empId = "+empId ;
				PreparedStatement ps2 = conn.prepareStatement(query2);
				ResultSet rs2 = ps2.executeQuery() ;
				if(rs2.next()) {
					int leave = rs2.getInt(1) ;
					if(ava>=leave) {
						String query3 = "delete from leaves where empId = "+empId ;
						PreparedStatement ps3 = conn.prepareStatement(query3);
						int x = ps3.executeUpdate() ;
						if(x>0) {
							result = "Leave request accepted" ;
						}
					}
					else {
						
						String query3 = "delete from leaves where empId = "+empId ;
						PreparedStatement ps3 = conn.prepareStatement(query3);
						int x = ps3.executeUpdate() ;
						if(x>0) {
							result = "This Employee don't have enough leaves left request rejected auto metically" ;
						}
						
					}
				}
				else {
					result = "Employee has not applied for the leave" ;
				}
				
			}else
			{
				result = "Enter right employee ID" ;
			}
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		
		
		
		return result ;
	}

	@Override
	public String rejectLeave(int empId) {
		
		String result = "No action taken something went wrong" ;
		
		
		
		try(Connection conn = Util.getConnection()) {
			String query2 = "select leaveday from leaves where empId = "+empId ;
			PreparedStatement ps2 = conn.prepareStatement(query2);
			ResultSet rs2 = ps2.executeQuery() ;
			if(rs2.next()) {
				
					String query3 = "delete from leaves where empId = "+empId ;
					PreparedStatement ps3 = conn.prepareStatement(query3);
					int x = ps3.executeUpdate() ;
					if(x>0) {
						result = "Leave request Rejected" ;
					}
				
			}
			else {
				result = "Employee has not applied for the leave" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		return result ;
	}

	@Override
	public boolean adminLogin(String username, String password) throws Employee_Exception{
		
		boolean result = false ;
		
		try(Connection conn = Util.getConnection()) {
			String query = "select adminuser , adminpass from admin" ;
			List<String[]> adminList = new ArrayList<>() ;
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				String[] admins = new String[2] ;
				String uname = rs.getString(1) ;
				String upass = rs.getString(2) ;
				admins[0] = uname ;
				admins[1] = upass ;
				
				adminList.add(admins) ;
				
			}
			if(adminList.isEmpty()) {
				throw new Employee_Exception("No admin data present") ;
				
			}
			for(int i=0 ;i<adminList.size() ;i++) {
				String adminListusername = adminList.get(i)[0] ;
				String adminListpassword = adminList.get(i)[1] ;
				
				if(username.equals(adminListusername) && password.equals(adminListpassword)) {
					return true ;
				}
			}
			
		} catch (SQLException e) {
			throw new Employee_Exception(e.getMessage()) ;
		}
		
		return result ;
	}

}
