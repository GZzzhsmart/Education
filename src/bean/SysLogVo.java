package bean;

import java.io.Serializable;
import java.util.Date;

public class SysLogVo implements Serializable{
	private int  syslogid ;  //系统日志
	private int managerid;   //id管理员id
	private int  Type;       ///日志类型（新增，修改，删除，登录，修改密码）
	private String Content;   //日志内容
	private Date createdate;   //发生时间 
	private String ipaddress;    //ip地址
	public int getSyslogid() {
		return syslogid;
	}
	public void setSyslogid(int syslogid) {
		this.syslogid = syslogid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	
}
