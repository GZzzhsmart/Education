package bean;

import java.util.Date;

public class CourseVo {
	
	private int courseid;  //�γ�id
	private String coursename;  //�γ�����
	private String pictureurl;  //�γ�ͼƬ��ַ
	private String oneword;     //һ�仰
	private String introduce;   //�γ̽���
	private int coursecount;    //��ʱ��
	private float price;        ///�۸�
	private float discount;      //�ۿ�
	private int effective;       //��Ч��(0����Ч��1����Ч)
	private Date replaydate;     //����ʱ��
	private String  username;   //������
	private int seq;                 //����(�����ǰ���*10)  
	private int chargetype;        //�շ�����0��ѣ�1��Ա
	private int status;           //0:δ��ˣ�1������ˣ�2.���δͨ��
	private String reason;        //δͨ��ԭ��
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
