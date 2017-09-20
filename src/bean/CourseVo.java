package bean;

import java.util.Date;

public class CourseVo {
	
	private int courseid;  //课程id
	private String coursename;  //课程名称
	private String pictureurl;  //课程图片网址
	private String oneword;     //一句话
	private String introduce;   //课程介绍
	private int coursecount;    //课时数
	private float price;        ///价格
	private float discount;      //折扣
	private int effective;       //有效否(0：无效；1：有效)
	private Date replaydate;     //发布时间
	private String  username;   //发布人
	private int seq;                 //排序(大号排前序号*10)  
	private int chargetype;        //收费类型0免费，1会员
	private int status;           //0:未审核，1：已审核；2.审核未通过
	private String reason;        //未通过原因
	private int userid;
	private String accountname;
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
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
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	public String getOneword() {
		return oneword;
	}
	public void setOneword(String oneword) {
		this.oneword = oneword;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getCoursecount() {
		return coursecount;
	}
	public void setCoursecount(int coursecount) {
		this.coursecount = coursecount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getEffective() {
		return effective;
	}
	public void setEffective(int effective) {
		this.effective = effective;
	}
	public Date getReplaydate() {
		return replaydate;
	}
	public void setReplaydate(Date replaydate) {
		this.replaydate = replaydate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getChargetype() {
		return chargetype;
	}
	public void setChargetype(int chargetype) {
		this.chargetype = chargetype;
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
	
	
	
}
