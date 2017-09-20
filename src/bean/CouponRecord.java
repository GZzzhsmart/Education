package bean;

import java.io.Serializable;
import java.util.Date;

public class CouponRecord implements Serializable{
	private int couponRecordId;
	private String activityName;
	private String activityDesc;
	private int userid;
	private String createDate;
	public int getCouponRecordId() {
		return couponRecordId;
	}
	public void setCouponRecordId(int couponRecordId) {
		this.couponRecordId = couponRecordId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getActivityDesc() {
		return activityDesc;
	}
	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
}
