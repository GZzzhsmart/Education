package bean;

import java.io.Serializable;
import java.util.Date;

public class CashRecordVo implements Serializable{

	private int  payrecordid;  
	private int userid;     
	private String userName;
	private int courseid;   
	private String coursename;
	private int gradeId; 
	private String gradeName;
    private  Date	cashdate;   
    private float paymoney;     
    private  float Incommoney;    
    private int status;       
    private String reason;    
	public int getPayrecordid() {
		return payrecordid;
	}
	public void setPayrecordid(int payrecordid) {
		this.payrecordid = payrecordid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public Date getCashdate() {
		return cashdate;
	}
	public void setCashdate(Date cashdate) {
		this.cashdate = cashdate;
	}
	public float getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(float paymoney) {
		this.paymoney = paymoney;
	}
	public float getIncommoney() {
		return Incommoney;
	}
	public void setIncommoney(float incommoney) {
		Incommoney = incommoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
    
    
    
}
