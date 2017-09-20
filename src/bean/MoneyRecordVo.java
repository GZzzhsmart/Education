package bean;

import java.io.Serializable;
import java.util.Date;

public class MoneyRecordVo implements Serializable{
	
	private int recordid;  //充值id
	private int userid;  //用户id
	private String username;//用户名称
	private Date paydate;   //充值时间
	private float paymoney;   //充值金额
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRecordid() {
		return recordid;
	}
	public void setRecordid(int recordid) {
		this.recordid = recordid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getPaydate() {
		return paydate;
	}
	public void setPaydate(Date paydate) {
		this.paydate = paydate;
	}
	public float getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(float paymoney) {
		this.paymoney = paymoney;
	}
	
}
