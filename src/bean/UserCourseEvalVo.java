package bean;

import java.io.Serializable;
import java.util.Date;

public class UserCourseEvalVo implements Serializable{
	private int usercourseevalid;  //����id
	private int userid;   //�û�id
	private int courseid;   //�γ�id
	private String coursename;//�γ�����
	private int evallevel;   //����(1/2/3/4/5)
	private String evalcontent;   //��������
	private Date evaldate;   //����ʱ��
	private String userName;//�û�����
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUsercourseevalid() {
		return usercourseevalid;
	}
	public void setUsercourseevalid(int usercourseevalid) {
		this.usercourseevalid = usercourseevalid;
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
	public int getEvallevel() {
		return evallevel;
	}
	public void setEvallevel(int evallevel) {
		this.evallevel = evallevel;
	}
	public String getEvalcontent() {
		return evalcontent;
	}
	public void setEvalcontent(String evalcontent) {
		this.evalcontent = evalcontent;
	}
	public Date getEvaldate() {
		return evaldate;
	}
	public void setEvaldate(Date evaldate) {
		this.evaldate = evaldate;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	
	
}
