package bean;

import java.io.Serializable;

public class TeacherVo implements Serializable{
	private int userid;//教师id
	private String teacherIntroduce;//教师简介
	private String teacherSpecial;//教师特长
	private String teacherLength;//教龄
	private String education;//学历
	private String headpictureUrl;//头像上传地址
	private int bankId;//银行id
	private String accountNo;//银行账户
	private String accountName;//开户人
	private int gradeId;//教师分类
	private int status;
	private String reason;
	private String bankName;
	private String gradeName;
	private float gradepercent;
	
	public float getGradepercent() {
		return gradepercent;
	}
	public void setGradepercent(float gradepercent) {
		this.gradepercent = gradepercent;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getTeacherIntroduce() {
		return teacherIntroduce;
	}
	public void setTeacherIntroduce(String teacherIntroduce) {
		this.teacherIntroduce = teacherIntroduce;
	}
	public String getTeacherSpecial() {
		return teacherSpecial;
	}
	public void setTeacherSpecial(String teacherSpecial) {
		this.teacherSpecial = teacherSpecial;
	}
	public String getTeacherLength() {
		return teacherLength;
	}
	public void setTeacherLength(String teacherLength) {
		this.teacherLength = teacherLength;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getHeadpictureUrl() {
		return headpictureUrl;
	}
	public void setHeadpictureUrl(String headpictureUrl) {
		this.headpictureUrl = headpictureUrl;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	
}
