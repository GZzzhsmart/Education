package bean;

import java.io.Serializable;

public class SectionVo implements Serializable{
	
		private int sectionid; //��id
		private int courseid;   //�γ�id
		private String sectionname;   //������
		private int timelength;//ʱ��
		private String sectionurl;    //�μ�������ַ
		private String sectioncontent;   //��������(html)
		private String remark;       //��ע
		private int free;      //�Ƿ����(0���/1��Ա)
		private int seq;       //����(С����ǰ���*10)
		private int status;    ///0:δ��ˣ�1������ˣ�2.���δͨ��
		private String reason;   //δͨ��ԭ��
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
