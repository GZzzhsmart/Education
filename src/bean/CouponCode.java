package bean;
import java.io.Serializable;

public class CouponCode implements Serializable{
	private int couponCodeId;
	private int couponRecordId;
	private int userid;
	private String code;
	private int couponMoney;
	private int status;
	private int validDay;
	private String useDate;
	public int getCouponCodeId() {
		return couponCodeId;
	}
	public void setCouponCodeId(int couponCodeId) {
		this.couponCodeId = couponCodeId;
	}
	public int getCouponRecordId() {
		return couponRecordId;
	}
	public void setCouponRecordId(int couponRecordId) {
		this.couponRecordId = couponRecordId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getCouponMoney() {
		return couponMoney;
	}
	public void setCouponMoney(int couponMoney) {
		this.couponMoney = couponMoney;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getValidDay() {
		return validDay;
	}
	public void setValidDay(int validDay) {
		this.validDay = validDay;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
}
