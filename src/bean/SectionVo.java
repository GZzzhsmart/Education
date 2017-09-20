package bean;

import java.io.Serializable;

public class SectionVo implements Serializable{
	
		private int sectionid; //节id
		private int courseid;   //课程id
		private String sectionname;   //节名称
		private int timelength;//时间
		private String sectionurl;    //课件内容网址
		private String sectioncontent;   //资料内容(html)
		private String remark;       //备注
		private int free;      //是否免费(0免费/1会员)
		private int seq;       //排序(小号排前序号*10)
		private int status;    ///0:未审核，1：已审核；2.审核未通过
		private String reason;   //未通过原因
		public int getSectionid() {
			return sectionid;
		}
		public void setSectionid(int sectionid) {
			this.sectionid = sectionid;
		}
		public int getCourseid() {
			return courseid;
		}
		public void setCourseid(int courseid) {
			this.courseid = courseid;
		}
		public String getSectionname() {
			return sectionname;
		}
		public void setSectionname(String sectionname) {
			this.sectionname = sectionname;
		}
		public String getSectionurl() {
			return sectionurl;
		}
		public void setSectionurl(String sectionurl) {
			this.sectionurl = sectionurl;
		}
		public String getSectioncontent() {
			return sectioncontent;
		}
		public void setSectioncontent(String sectioncontent) {
			this.sectioncontent = sectioncontent;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		public int getFree() {
			return free;
		}
		public void setFree(int free) {
			this.free = free;
		}
		public int getSeq() {
			return seq;
		}
		public void setSeq(int seq) {
			this.seq = seq;
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
		public int getTimelength() {
			return timelength;
		}
		public void setTimelength(int timelength) {
			this.timelength = timelength;
		}
		
		
}
