package bean;

import java.io.Serializable;
import java.util.Date;

public class UserCourseEvalVo implements Serializable{
	private int usercourseevalid;  //评价id
	private int userid;   //用户id
	private int courseid;   //课程id
	private String coursename;//课程名称
	private int evallevel;   //评级(1/2/3/4/5)
	private String evalcontent;   //评价内容
	private Date evaldate;   //评价时间
	private String userName;//用户名称
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
