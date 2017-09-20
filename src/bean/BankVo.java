package bean;

import java.io.Serializable;

public class BankVo implements Serializable{
	
	private int bankid;  
	private String bankname;   
	public int getBankid() {
		return bankid;
	}
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	
}
