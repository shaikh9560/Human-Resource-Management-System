package JavaBean;

public class Leaves {
	
	private int empId ;
	private int leave_NO ;
	private int leaveDay ;
	private String reson ;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getLeaveNo() {
		return leave_NO;
	}
	public void setLeaveNo(int leaveNo) {
		this.leave_NO = leaveNo;
	}
	public int getLeaveDay() {
		return leaveDay;
	}
	public void setLeaveDay(int leaveDay) {
		this.leaveDay = leaveDay;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	@Override
	public String toString() {
		return "Leaves [empId=" + empId + ", leaveNo=" + leave_NO + ", leaveDay=" + leaveDay + ", reson=" + reson + "]";
	}
	public Leaves(int empId, int leaveNo, int leaveDay, String reson) {
		super();
		this.empId = empId;
		this.leave_NO = leaveNo;
		this.leaveDay = leaveDay;
		this.reson = reson;
	}
	public Leaves() {
		super();
	}
	
	

}
