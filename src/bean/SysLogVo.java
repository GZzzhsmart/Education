package bean;

import java.io.Serializable;
import java.util.Date;

public class SysLogVo implements Serializable{
	private int  syslogid ;  //ϵͳ��־
	private int managerid;   //id����Աid
	private int  Type;       ///��־���ͣ��������޸ģ�ɾ������¼���޸����룩
	private String Content;   //��־����
	private Date createdate;   //����ʱ�� 
	private String ipaddress;    //ip��ַ
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
