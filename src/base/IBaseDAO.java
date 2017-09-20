package base;

import java.util.List;
import servlet.usercourseServlet;

import bean.CashRecordVo;
import bean.CityVo;
import bean.CouponCode;
import bean.CouponRecord;
import bean.CourseVo;
import bean.ForumVo;
import bean.ManagerVo;
import bean.MoneyRecordVo;
import bean.NewMsgVo;
import bean.PayRecordVo;
import bean.ProvinceVo;
import bean.SectionVo;
import bean.TeacherGradeVo;
import bean.TeacherVo;
import bean.UserCourseEvalVo;
import bean.UsersVo;
import bean.BankVo;

public interface IBaseDAO {

	//城市列表
	public abstract void cityAdd(CityVo city);
	public abstract void cityDel(int cityId);
	public abstract void cityUpdate(CityVo city);
	public abstract List<CityVo> cityList();
	public abstract CityVo findCityById(String cityId);
	public abstract List<CityVo> cityList(int pageSize,int startPos);
	//分页
	public abstract int getCount(String sql);
	
	
	//省份列表
	public abstract void provinceAdd(ProvinceVo province);
	public abstract void provinceDel(int provinceId);
	public abstract void provinceUpdate(ProvinceVo province);
	public abstract List<ProvinceVo> provinceList();
	public abstract ProvinceVo findprovinceById(String provinceId);
	public abstract List<ProvinceVo> provinceList(int pageSize,int startPos);
	
	//讲师表
	public abstract void gradeAdd(TeacherGradeVo grade);
	public abstract void gradeDel(int gradeId);
	public abstract void gradeUpdate(TeacherGradeVo grade);
	public abstract TeacherGradeVo findgradeById(String gradeId);
	public abstract List<TeacherGradeVo> gradeList();
	public abstract List<TeacherGradeVo> gradeList(int pageSize,int startPos);
	public void teacherStatus(String userid);
	public void userUpdate(String userid);
	
	//银行列表
	public abstract void bankAdd(BankVo bank);
	public abstract void bankDel(int bankid);
	public abstract void bankUpdate(BankVo bank);
	public abstract BankVo findbankById(String bankid);
	public abstract List<BankVo> bankList();
	public abstract List<BankVo> findbankByPage(int pageSize,int startPos);
	
	//管理员列表
	public abstract void managerAdd(ManagerVo manager);
	public abstract void managerUpdate(ManagerVo manager);
	public abstract void managerDel(int managerId);
	public abstract ManagerVo findmanagerById(String managerId);
	public abstract List<ManagerVo> findManagerByPage(int pageSize,int startPos);
	public abstract List<ManagerVo> managerList();
	public abstract List<ManagerVo> managerList(String name);
	public abstract boolean checkPwd(String managerId,String oldpassword);
	public abstract void modifyPwd(String managerId,String newpassword);
	public abstract void updateStatus(String managerId,int status);
	public abstract ManagerVo login(String name,String pwd);
	
	//用户表
	public abstract List<CityVo> CityList(int provinceId);
	public abstract void userAdd(UsersVo user) throws Exception;
	public abstract void userDel(int userid);
	public abstract void userUpdate(UsersVo user);
	public abstract List<UsersVo> userList();
	public abstract UsersVo finduserById(String userid);
	public abstract UsersVo finduserById1(String userid);
	public abstract List<UsersVo> finduserByPage(int pageSize,int startPos);
	public abstract boolean checkPwd1(String userid,String oldpassword);
	public abstract void modifyPwd1(String userid,String newpassword);
	public abstract UsersVo login1(String name,String pwd);
	public abstract UsersVo login2(String mobile,String pwd);
	
	//教师表
	public abstract void teacherAdd(TeacherVo teacher);
	public abstract void teacherUpdate(TeacherVo teacher);
	public abstract void teacherDel(int userid);
	public abstract TeacherVo findteacherById(int userid);
	public abstract List<TeacherVo> teacherList();
	public abstract List<TeacherVo> findteacherByPage(int pageSize,int startPos);
	public abstract void updatestatus(String userid,int status);
	public abstract boolean teacherIsExist(int teacherId);
	public abstract void teacherAudit(TeacherVo teacher);

	
	//充值金额
	public abstract  void moneyAdd(float ymoney,float xmoney,String recordid);
	//充值用户表
	public abstract void moneyUser(String userid,float ymoney,float xmoney);
	
	public abstract void moneyRecordAdd(MoneyRecordVo money);
	public abstract void moneyRecordDel(int recordId);
	public abstract void moneyRecordUpdate(MoneyRecordVo money);
	public abstract MoneyRecordVo findmoneyById(String recordId);
	public abstract List<MoneyRecordVo> moneyList();
	public abstract List<MoneyRecordVo> findmoneyById(int pageSize,int startPos);
	public abstract void moneyAdd2(String userid);

	
	//新闻资讯表
	public abstract void newsMsgAdd(NewMsgVo msg);
	public abstract void newMsgUpdate(NewMsgVo msg);
	public abstract void newMsgDel(String newMsgId);
	public abstract NewMsgVo findNewMsgById(String newMsgId);
	public abstract List<NewMsgVo> newmsgList();
	public abstract List<NewMsgVo> newmsgList(String name);
	public abstract List<NewMsgVo> findNewMsgById(int pageSize, int startPos);
	
	//课程表
	public abstract void courseAdd(CourseVo course);
	public abstract void courseUpdate(CourseVo course);
	public abstract void courseDel(int Courseid);
	
	public abstract CourseVo findcourseById(String courseid);
	public abstract List<CourseVo> courseList();
	public abstract List<CourseVo> findcourseById(int userid,int pageSize, int startPos);
	public void courseEffective(String couseid);
	public void courseEffective2(String couseid);
	public abstract boolean courseIsExist(int courseid);
	public abstract List<CourseVo> findcourseById(int pageSize, int startPos);
	public abstract void courseAudit(CourseVo course);
	public abstract List<CourseVo> courseList(String coursename,int status,String username);
	
	
	//课件节表(课程表)
	public abstract void sectionAdd(SectionVo section);
	public abstract void sectionUpdate(SectionVo section);
	public abstract void sectionDel(int sectionid);
	public abstract SectionVo findsectionById(String sectionid);
	public abstract List<SectionVo> sectionList();
	public abstract List<SectionVo> findsectionById(int courseid,int pageSize, int startPos);
	public abstract List<SectionVo> findsectionById(int pageSize, int startPos);
	public abstract void updateStatus1(String sectionid,int status);
	public abstract void sectionAudit(SectionVo section);
	
	
	//优惠券活动明细表
	public abstract void couponCodeAdd(int recordid,int money,int day,int count);
	public abstract List<CouponCode> couponCodeList(int couponRecordId);
	public abstract List<CouponCode> couponCodeList(int pageSize,int startPos);
	//优惠券活动表
	public abstract void couponRecordAdd(CouponRecord coupon);
	public abstract void couponRecordUpdate(CouponRecord coupon);
	public abstract void couponRecordDel(int  couponRecordId);
	public abstract CouponRecord findCouponRecord(String couponRecordId);
	public abstract List<CouponRecord> couponRecordList();
	public abstract List<CouponRecord> couponRecordList(int teacherId,int pageSize,int startPos);
	
	public abstract CouponCode couponFint(String codeid);
	public abstract  void CouponCodeLin(int userid,String couponCodeId); 
	public abstract  void CouponCodeLin1(String useDate,String couponCodeId); 
	public abstract CouponCode couponFint1(int userid);
	public abstract List<CouponCode> couponFint(int codeid);
	
	///按课程名称，讲师名字查找
	public abstract List<CourseVo> courseList(String name);
	public List<CourseVo> courseList2(int userId,int pageSize,int startPos);
	
	
	///新增在线留言板1
	public abstract void ForumAdd(ForumVo liu);
	///新增在线留言板教师
	public abstract void ForumAdd2(ForumVo liu);
	///在线咨询
	public abstract List<ForumVo> fotuList(int userid);
	public abstract List<ForumVo> teacherLiuyan(String userid);
	public abstract ForumVo fintLiuyan(int userid);
	public abstract List<ForumVo> teacherLiuyan2(int userid);
	public abstract void forumDel(int forumid);
	
	//用户课程评价表
	public abstract List<UserCourseEvalVo> UserCourseEvalList(String courseId);
	public abstract CouponCode couponCodeList(String courseId);
	public abstract void usercourseAdd(UserCourseEvalVo usercourse);
	public abstract void usercourseUpdate(UserCourseEvalVo usercourse);
	public abstract void usercourseDel(int usercourseevalid);
	public abstract UserCourseEvalVo findusercourseById(String usercourseevalid);
	public List<UserCourseEvalVo> usercourseList(int usercourseevalid);
	public abstract List<UserCourseEvalVo> findusercourse(int pageSize, int startPos);
	//查询买课记录表
	public abstract List<PayRecordVo> PayRecordList(int userid,int pageSize,int startPos);
	//只能评价一次
	public abstract UserCourseEvalVo userCourseEvalFint(String courseid);
	
	//买课记录表
	public abstract void userMoney(float moery,int userid);
	public abstract void moneyRecordMoney(float moery,int userid);
	public abstract void PayRecordAdd(PayRecordVo pay);
	public UsersVo finduserById(int userid);
	//修改老师余额
	public abstract void teacherMOney(int userid,float yuer,float yuan);
	public abstract void teacherMOney(String userid,float yuer,float yuan);
	public abstract  void CouponCodeDel(int couid);
	public abstract PayRecordVo PayRecordFint(int userid);
	public abstract List<PayRecordVo> findpayrecord(int pageSize, int startPos);
	public abstract List<PayRecordVo> findpayrecord(int payrecordid);
	public abstract void payrecordDel(int payrecordid);
	
	//提现记录表
	///申请提现
	public abstract List<PayRecordVo> MaikeJilv();
	
	//后台审核提现
	public abstract List<PayRecordVo> Maishenhe(int pageSize,int startPos);
	
	public PayRecordVo PayRecordFint2(String maiid);
	
	public abstract TeacherVo teacherVo(int userid);
	
	public UsersVo finduserById3(int userid);
	
	public abstract void CashRecordMoneyAdd(CashRecordVo ahd);  
	
	public abstract  float chen(float yi,float er);
	
	public  abstract CourseVo courseVo(String counid);
		
	public abstract void  Pay(String status,String  userid);
	public void teacherChongzhi(int userid,float yuer,float yuan);
	public abstract PayRecordVo payRecordVo(String id);
	
	
	//提现记录表
	public abstract List<CashRecordVo> cList(int pageSize,int startPos);
	
	
 }
