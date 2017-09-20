package bean;

import java.io.Serializable;
import java.util.Date;


public class ForumVo implements Serializable{
	
	private int forumid;  //���
	private int userid;    //�����û�id
	private int ReplayUserId;   //�ظ��û�id
	private int fourmtype;     //1�����ʣ�2���ظ�
	private String Content;   //����
	private Date forumdate;   //�ظ�ʱ��
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getForumid() {
		return forumid;
	}
	public void setForumid(int forumid) {
		this.forumid = forumid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getReplayUserId() {
		return ReplayUserId;
	}
	public void setReplayUserId(int replayUserId) {
		ReplayUserId = replayUserId;
	}
	public int getFourmtype() {
		return fourmtype;
	}
	public void setFourmtype(int fourmtype) {
		this.fourmtype = fourmtype;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public Date getForumdate() {
		return forumdate;
	}
	public void setForumdate(Date forumdate) {
		this.forumdate = forumdate;
	}
	
	
}
