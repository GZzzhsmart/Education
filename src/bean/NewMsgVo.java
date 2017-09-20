package bean;

import java.io.Serializable;
import java.util.Date;

public class NewMsgVo implements Serializable{
	private int newMsgId;//资讯id
	private String msgName;//资讯名称
	private String oneWord;//一句话
	private String msgContent;//html网页(内容)
	private String msgContentUrl;//内容网址
	private String publishDate;//发布时间
	private String publishUsername;//发布人
	private int effective;//0有效，1无效
	private int seq;//排序号(大号排前序号*10)
	private int newsType;//0是通知，1是公告
	private String imageUrl;//图片网址
	public int getNewMsgId() {
		return newMsgId;
	}
	public void setNewMsgId(int newMsgId) {
		this.newMsgId = newMsgId;
	}
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public String getOneWord() {
		return oneWord;
	}
	public void setOneWord(String oneWord) {
		this.oneWord = oneWord;
	}
	public String getMsgContent() {
		return msgContent;
	}
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	public String getMsgContentUrl() {
		return msgContentUrl;
	}
	public void setMsgContentUrl(String msgContentUrl) {
		this.msgContentUrl = msgContentUrl;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublishUsername() {
		return publishUsername;
	}
	public void setPublishUsername(String publishUsername) {
		this.publishUsername = publishUsername;
	}
	public int getEffective() {
		return effective;
	}
	public void setEffective(int effective) {
		this.effective = effective;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getNewsType() {
		return newsType;
	}
	public void setNewsType(int newsType) {
		this.newsType = newsType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
