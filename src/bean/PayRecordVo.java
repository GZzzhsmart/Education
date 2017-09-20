package bean;

import java.io.Serializable;
import java.util.Date;

public class PayRecordVo implements Serializable{
	
		private int payrecordid;  //缴费id
		private int userid;    //用户id
		private int courseid;  //课程Id
		private int sectionid;
		private int payorreturn;  //缴费或退费（0缴费，1退费）
		private Date paydate;		//付款时间
		private float paymoney;    //付款金额
		private float discountmoney;	//优惠券金额
		private int paytype;			//付款方式(0支付宝/1微信
		private String cardnum;     //支付宝，微信号）
		private String payer;		//付款人
		private String ordernumber;  //订单号
		private int paystatus;		//缴费状态(0未支付/1已支付)
		private int isCash;			//是否提现（0：未提现；1：已提现）
		
		private String coursename;//课程名称
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
		public String getCoursename() {
			return coursename;
		}
		public void setCoursename(String coursename) {
			this.coursename = coursename;
		}
		public int getPayrecordid() {
			return payrecordid;
		}
		public void setPayrecordid(int payrecordid) {
			this.payrecordid = payrecordid;
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
		public int getPayorreturn() {
			return payorreturn;
		}
		public void setPayorreturn(int payorreturn) {
			this.payorreturn = payorreturn;
		}
		public Date getPaydate() {
			return paydate;
		}
		public void setPaydate(Date paydate) {
			this.paydate = paydate;
		}
		public float getPaymoney() {
			return paymoney;
		}
		public void setPaymoney(float paymoney) {
			this.paymoney = paymoney;
		}
		public float getDiscountmoney() {
			return discountmoney;
		}
		public void setDiscountmoney(float discountmoney) {
			this.discountmoney = discountmoney;
		}
		public int getPaytype() {
			return paytype;
		}
		public void setPaytype(int paytype) {
			this.paytype = paytype;
		}
		public String getCardnum() {
			return cardnum;
		}
		public void setCardnum(String cardnum) {
			this.cardnum = cardnum;
		}
		public String getPayer() {
			return payer;
		}
		public void setPayer(String payer) {
			this.payer = payer;
		}
		public String getOrdernumber() {
			return ordernumber;
		}
		public void setOrdernumber(String ordernumber) {
			this.ordernumber = ordernumber;
		}
		public int getPaystatus() {
			return paystatus;
		}
		public void setPaystatus(int paystatus) {
			this.paystatus = paystatus;
		}
		public int getIsCash() {
			return isCash;
		}
		public void setIsCash(int isCash) {
			this.isCash = isCash;
		}
		public int getSectionid() {
			return sectionid;
		}
		public void setSectionid(int sectionid) {
			this.sectionid = sectionid;
		}
		
		
}
