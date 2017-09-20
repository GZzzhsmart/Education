package bean;

import java.io.Serializable;
import java.util.Date;

public class PayRecordVo implements Serializable{
	
		private int payrecordid;  //�ɷ�id
		private int userid;    //�û�id
		private int courseid;  //�γ�Id
		private int sectionid;
		private int payorreturn;  //�ɷѻ��˷ѣ�0�ɷѣ�1�˷ѣ�
		private Date paydate;		//����ʱ��
		private float paymoney;    //������
		private float discountmoney;	//�Ż�ȯ���
		private int paytype;			//���ʽ(0֧����/1΢��
		private String cardnum;     //֧������΢�źţ�
		private String payer;		//������
		private String ordernumber;  //������
		private int paystatus;		//�ɷ�״̬(0δ֧��/1��֧��)
		private int isCash;			//�Ƿ����֣�0��δ���֣�1�������֣�
		
		private String coursename;//�γ�����
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
