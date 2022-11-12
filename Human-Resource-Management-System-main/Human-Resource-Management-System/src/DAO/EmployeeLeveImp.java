package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exceptions.Employee_Exception;
import JavaBean.EmployeeDto;
import Util.Util;

public class EmployeeLeveImp implements EmployeeLevel {

	@Override
	public EmployeeDto viewDetails(int empId) throws Employee_Exception {
		EmployeeDto result = null ;
		
		
		String query = "select * from employee e inner join department d on d.deptId = e.empDepId where e.empId = ?" ;
		
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery() ;
			boolean flag = true ;
			while(rs.next()) {
				flag = false ;
				int eid = rs.getInt("empId") ;
				String ename = rs.getString("empName") ;
				String euser = rs.getString("empuser") ;
				int esal = rs.getInt("empSal") ;
				java.util.Date date = rs.getDate("empJoin" ) ;
				int elev = rs.getInt("empLeave") ;
				int did = rs.getInt("deptId") ;
				int mid = rs.getInt("empMangId") ;
				String dname = rs.getString("deptName") ;
				String dloc = rs.getString("deptLoc") ;
				
				EmployeeDto employee = new EmployeeDto(empId, euser, ename, esal, date, elev, did, mid, dname, dloc) ;
				
				return employee ;
				
				
				
			}
			if(flag) {
				throw new Employee_Exception("You have entered wrong empId") ;
			}
			
		} catch (SQLException e) {
			throw new Employee_Exception(e.getMessage()) ;
			// TODO: handle exception
		}
		
		
		
		
		
		
		
		
		return result ;
	}

	@Override
	public String applyForLeave(int empId , int day , String reason )   {
		String result = "Not applied for leaves" ;
		
		String query = "insert into leaves(empId , leaveday , leaveres) values(?,?,?)" ;
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empId);
			ps.setInt(2, day);
			ps.setString(3, reason);
			
			int x = ps.executeUpdate() ;
			if( x > 0) {
				result = "You have applied for leave wait for admin to take action" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		
		
		
		return result ;
	}

	@Override
	public String updatePassword(int empId, String password) {
		String result = "Password Not changed" ;
		
		String query = "update employee set emppass = ? where empId = ?" ;
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(query) ;
			ps.setString(1, password);
			ps.setInt(2, empId);
			int x = ps.executeUpdate() ;
			if(x > 0) {
				result = "Password changed successfully" ;
			}
			
			
		} catch (SQLException e) {
			result = e.getMessage() ;
		}
		
		
		
		
		
		
		return result ;
	}
	@Override
	public boolean employeeLogin(String username, String password) throws Employee_Exception{
		
		boolean result = false ;
		
		try(Connection conn = Util.getConnection()) {
			String query = "select empuser , emppass from employee" ;
			List<String[]> employeeList = new ArrayList<>() ;
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery() ;
			while(rs.next()) {
				String[] employee = new String[2] ;
				String uname = rs.getString(1) ;
				String upass = rs.getString(2) ;
				employee[0] = uname ;
				employee[1] = upass ;
				
				employeeList.add(employee) ;
				
			}
			if(employeeList.isEmpty()) {
				throw new Employee_Exception("No Employee data present.") ;
				
			}
			for(int i=0 ;i<employeeList.size() ;i++) {
				String employeeListusername = employeeList.get(i)[0] ;
				String employeeListpassword = employeeList.get(i)[1] ;
				
				if(username.equals(employeeListusername) && password.equals(employeeListpassword)) {
					return true ;
				}
			}
			
		} catch (SQLException e) {
			throw new Employee_Exception(e.getMessage()) ;
		}
		
		return result ;
	}
	
	public int empId(String username) {
		
		try(Connection conn = Util.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select empId from employee where empuser = ?") ;
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery() ;
			if(rs.next())
				return rs.getInt(1) ;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return 0 ;
	}

}
