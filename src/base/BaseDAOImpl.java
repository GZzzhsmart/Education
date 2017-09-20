package base;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

public class BaseDAOImpl implements IBaseDAO{

	//新增城市
	public void cityAdd(CityVo city) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into city values('" + city.getCityName() +"',"+city.getProvinceId()+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除城市
	public void cityDel(int cityId) {
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql ="delete city where cityId="+cityId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//查询城市列表
	public List<CityVo> cityList() {
		Connection conn = DBConn.openDB();
		List<CityVo> list = new ArrayList<CityVo>();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from city";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityVo city = new CityVo();
				city.setCityId(rs.getInt("CityId"));
				city.setCityName(rs.getString("CityName").trim());
				city.setProvinceId(rs.getInt("ProvinceId"));
				list.add(city);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}

	//分页
	public List<CityVo> cityList(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<CityVo> list = new ArrayList<CityVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" c.*,p.provinceName from city c inner join Province p on c.provinceId=p.provinceId ";
			sql += " where cityid not in(select top "+startPos+" cityid from city order by provinceId,cityId)  order by c.provinceId,c.cityId";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityVo city = new CityVo();
				city.setCityId(rs.getInt("cityId"));
				city.setCityName(rs.getString("cityName").trim());
				city.setProvinceId(rs.getInt("provinceId"));
				city.setProvinceName(rs.getString("provinceName"));
				list.add(city);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改城市资料
	public void cityUpdate(CityVo city) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update city set cityName='" + city.getCityName() +"',provinceId="+city.getProvinceId()+" where cityId="+city.getCityId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//通过id来查找城市
	public CityVo findCityById(String cityId) {
		Connection conn = DBConn.openDB();
		CityVo city = null;
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from city where cityId="+cityId;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				city = new CityVo();
				city.setCityId(rs.getInt("cityId"));
				city.setCityName(rs.getString("cityName").trim());
				city.setProvinceId(rs.getInt("provinceId"));
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return city;
	}
	//分页
	public int getCount(String sql) {
		Connection conn = DBConn.openDB();
		int cnt = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//查询省份数据
	public List<ProvinceVo> provinceList() {
		Connection conn = DBConn.openDB();
		List<ProvinceVo> list = new ArrayList<ProvinceVo>();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from province order by provinceId";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ProvinceVo prov = new ProvinceVo();
				prov.setProvinceId(rs.getInt("provinceId"));
				prov.setProvinceName(rs.getString("provinceName").trim());
				list.add(prov);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	//通过id来查找省份
	public ProvinceVo findprovinceById(String provinceId) {
		Connection conn = DBConn.openDB();
		ProvinceVo province= new ProvinceVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from province where provinceId="+provinceId+"order by provinceId";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				province.setProvinceId(rs.getInt("provinceId"));
				province.setProvinceName(rs.getString("provinceName").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return province;
	}
	//新增省份
	public void provinceAdd(ProvinceVo province) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into province values('"+province.getProvinceName()+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除省份
	public void provinceDel(int provinceId) {
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql ="delete province where provinceId="+provinceId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//分页
	public List<ProvinceVo> provinceList(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<ProvinceVo> list = new ArrayList<ProvinceVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from province where provinceId not in(select top "+startPos+" provinceId from province)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ProvinceVo province = new ProvinceVo();
				province.setProvinceId(rs.getInt("provinceId"));
				province.setProvinceName(rs.getString("provinceName").trim());
				list.add(province);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改省份
	public void provinceUpdate(ProvinceVo province) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update province set provinceName='" + province.getProvinceName() +"' where provinceId="+province.getProvinceId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询讲师
	public TeacherGradeVo findgradeById(String gradeId) {
		Connection conn = DBConn.openDB();
		TeacherGradeVo grade= new TeacherGradeVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from teachergrade where grade_id="+gradeId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				grade.setGradeId(rs.getInt("grade_id"));
				grade.setGradeName(rs.getString("grade_name").trim());
				grade.setGradePercent(rs.getFloat("grade_percent"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grade;
	}
	//新增讲师
	public void gradeAdd(TeacherGradeVo grade) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into teacherGrade values('" + grade.getGradeName() +"',"+grade.getGradePercent()+")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除讲师
	public void gradeDel(int gradeId) {
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql ="delete teachergrade where grade_id="+gradeId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//查询讲师列表
	public List<TeacherGradeVo> gradeList() {
		Connection conn = DBConn.openDB();
		List<TeacherGradeVo> list = new ArrayList<TeacherGradeVo>();
		try{
			Statement stmt = conn.createStatement();
			String sql = "select * from teacherGrade ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeacherGradeVo grade = new TeacherGradeVo();
				grade.setGradeId(rs.getInt("grade_id"));
				grade.setGradeName(rs.getString("grade_name").trim());
				grade.setGradePercent(rs.getFloat("grade_percent"));
				list.add(grade);
			}
			rs.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return list;
	}
	//分页
	public List<TeacherGradeVo> gradeList(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<TeacherGradeVo> list = new ArrayList<TeacherGradeVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from teachergrade where grade_id not in(select top "+startPos+" grade_id from teachergrade)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeacherGradeVo grade = new TeacherGradeVo();
				grade.setGradeId(rs.getInt("grade_id"));
				grade.setGradeName(rs.getString("grade_name").trim());
				grade.setGradePercent(rs.getFloat("grade_percent"));
				list.add(grade);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改讲师
	public void gradeUpdate(TeacherGradeVo grade) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update teacherGrade set grade_name='"+grade.getGradeName()+"',grade_percent="+grade.getGradePercent()+" where grade_id=" + grade.getGradeId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//新增银行
	public void bankAdd(BankVo bank) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into bank values('" + bank.getBankname() +"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除银行
	public void bankDel(int bankid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete bank where bank_id=" + bankid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询银行列表
	public List<BankVo> bankList() {
		Connection conn = DBConn.openDB();
		List<BankVo> list = new ArrayList<BankVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from bank";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				BankVo bank = new BankVo();
				bank.setBankid(rs.getInt("bank_id"));
				bank.setBankname(rs.getString("bank_name").trim());
				list.add(bank);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改银行
	public void bankUpdate(BankVo bank) {
		Connection conn = DBConn.openDB();
		try{
			Statement stmt = conn.createStatement();
			String sql = "update bank set bank_name='"+bank.getBankname()+"'where bank_id=" + bank.getBankid();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
	//通过id查找银行
	public BankVo findbankById(String bankid) {
		Connection conn = DBConn.openDB();
		BankVo bank= new BankVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from bank where bank_id="+bankid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				bank.setBankid(rs.getInt("bank_id"));
				bank.setBankname(rs.getString("bank_name").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bank;
	}
	//分页
	public List<BankVo> findbankByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<BankVo> list = new ArrayList<BankVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from bank where bank_id not in(select top "+startPos+" bank_id from bank)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				BankVo bank = new BankVo();
				bank.setBankid(rs.getInt("bank_id"));
				bank.setBankname(rs.getString("bank_name").trim());
				list.add(bank);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//检查旧密码
	public boolean checkPwd(String managerId, String oldpassword) {
		boolean isok = false;
		Connection conn = DBConn.openDB();
		ManagerVo manager = new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where manager_id="+managerId+" and  manager_password='"+oldpassword+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isok;
	}
	//分页
	public List<ManagerVo> findManagerByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<ManagerVo> list = new ArrayList<ManagerVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from manager where manager_id not in(select top "+startPos+" manager_id from manager)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ManagerVo manager = new ManagerVo();
				manager.setManagerId(rs.getInt("manager_Id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_Password"));
				manager.setManagerName(rs.getString("manager_Name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//通过id来查找管理员资料
	public ManagerVo findmanagerById(String managerId) {
		Connection conn = DBConn.openDB();
		ManagerVo manager= new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where manager_id="+managerId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				manager.setManagerId(rs.getInt("manager_Id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_Password"));
				manager.setManagerName(rs.getString("manager_Name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}
	//新增管理员
	public void managerAdd(ManagerVo manager) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into manager values(";
			sql += "'"+manager.getManagerAccount() +"',";
			sql += "'"+manager.getManagerPassword()+"',";
			sql += "'"+manager.getManagerName()+"',";
			sql += "'"+manager.getSex()+"',";
			sql += "'"+manager.getContact()+"',";
			sql += "'"+manager.getStatus()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除管理员
	public void managerDel(int managerId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete manager where manager_id="+managerId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询管理员
	public List<ManagerVo> managerList() {
		Connection conn = DBConn.openDB();
		List<ManagerVo> list = new ArrayList<ManagerVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				ManagerVo manager = new ManagerVo();
				manager.setManagerId(rs.getInt("manager_id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_password"));
				manager.setManagerName(rs.getString("manager_name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
			}
			rs.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<ManagerVo> managerList(String name) {
		Connection conn = DBConn.openDB();
		List<ManagerVo> list=new ArrayList<ManagerVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from manager where manager_Account	like '%"+name+"%'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				ManagerVo manager=new ManagerVo();
				manager.setManagerId(rs.getInt("manager_id"));
				manager.setManagerAccount(rs.getString("manager_Account").trim());
				manager.setManagerPassword(rs.getString("manager_password"));
				manager.setManagerName(rs.getString("manager_name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//修改管理员资料
	public void managerUpdate(ManagerVo manager) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update manager set manager_account='";
			sql += manager.getManagerAccount() +"',manager_name='";
			sql += manager.getManagerName()+"',sex='";
			sql += manager.getSex()+"',contact='";
			sql += manager.getContact()+"' ";
			sql += " where manager_id="+manager.getManagerId();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//修改密码
	public void modifyPwd(String managerId, String newpassword) {
		Connection conn = DBConn.openDB();
		ManagerVo manager = new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update manager set manager_password='"+newpassword+"' where manager_id="+managerId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//更改状态(禁用，启用)
	public void updateStatus(String managerId, int status) {
		Connection conn = DBConn.openDB();
		ManagerVo manager = new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update manager set status='"+status+"'where manager_id="+managerId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ManagerVo login(String name, String pwd) {
		Connection conn = DBConn.openDB();
		ManagerVo manager= new ManagerVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from manager where manager_Account='"+name +"' and manager_Password='"+pwd +"' and status=1";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				manager.setManagerId(rs.getInt("manager_id"));
				manager.setManagerAccount(rs.getString("manager_account").trim());
				manager.setManagerPassword(rs.getString("manager_password"));
				manager.setManagerName(rs.getString("manager_name").trim());
				manager.setSex(rs.getInt("sex"));
				manager.setContact(rs.getString("contact").trim());
				manager.setStatus(rs.getInt("status"));
			}else{
				manager=null;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}
	
	
	//查询城市列表
	public List<CityVo> CityList(int provinceId) {
		Connection conn = DBConn.openDB();
		List<CityVo> list = new ArrayList<CityVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from city where provinceId="+provinceId;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CityVo city= new CityVo();
				city.setCityId(rs.getInt("cityId"));
				city.setCityName(rs.getString("cityName").trim());
				city.setProvinceId(rs.getInt("provinceId"));
				list.add(city);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//检查旧密码
	public boolean checkPwd1(String userid, String oldpassword) {
		boolean isok = false;
		Connection conn = DBConn.openDB();
		UsersVo user = new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from users where userid="+userid+"and password='"+oldpassword+"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				isok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isok;
	}
	//通过id查找用户
	public UsersVo finduserById(String userid) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select u.*,p.provincename,c.cityname from users u,province p,city c where userid="+userid+" and c.cityid=u.cityid and p.provinceid=u.provinceid";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				user.setProvinceName(rs.getString("provincename").trim());
				user.setCityName(rs.getString("cityname").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	//分页
	public List<UsersVo> finduserByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<UsersVo> list = new ArrayList<UsersVo>();
		try {
			//select userid,mobile,user_name,sex,home_address,email,register_date,user_type,isnull(p.provinceName,'未知') provinceName,isnull(c.cityName,'未知') cityName from users u left join province p on u.provinceid=p.provinceid left join city c on u.cityid=c.cityid;
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" userid,mobile,user_name,sex,home_address,email,register_date,user_type,remainMoney,isnull(p.provinceName,'未知') provinceName,isnull(c.cityName,'未知') cityName from users u left join province p on u.provinceid=p.provinceid left join city c on u.cityid=c.cityid ";
			sql += " where userid not in(select top "+startPos +" userid from users) order by userid";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				UsersVo user= new UsersVo();
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setUserName(rs.getString("user_name"));
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email"));
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceName(rs.getString("provinceName").trim());
				user.setCityName(rs.getString("cityName").trim());
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				list.add(user);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改密码
	public void modifyPwd1(String userid, String newpassword) {
		Connection conn = DBConn.openDB();
		UsersVo user = new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update users set password='"+newpassword+"' where userid="+userid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//新增用户
	public void userAdd(UsersVo user) throws Exception {
		Connection conn = DBConn.openDB();
		Statement stmt = conn.createStatement();
		String sql = "insert into users values(";
		sql += "'"+user.getMobile() +"',";
		sql += "'"+user.getPassword()+"',";
		sql += "'"+user.getUserName()+"',";
		sql += "'"+user.getSex()+"',";
		sql += "'"+user.getHomeAddress()+"',";
		sql += "'"+user.getEmail()+"',";
		sql += "'"+new Date().toLocaleString()+"',";
		sql += "'"+user.getProvinceId()+"',";
		sql += "'"+user.getCityId()+"',";
		sql += "'"+user.getUserType()+"',";
		sql += "'"+user.getRemainMoney()+"'";
		sql += ")";
		System.out.println(sql);
		stmt.executeUpdate(sql);
		stmt.close();
		
	}
	//删除用户
	public void userDel(int userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete users where userid="+userid;
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询用户
	public List<UsersVo> userList() {
		Connection conn=DBConn.openDB();
		List<UsersVo> list=new ArrayList<UsersVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from users";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				UsersVo user=new UsersVo();
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				list.add(user);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改用户
	public void userUpdate(UsersVo user) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update users set  mobile='"+user.getMobile()+
			"',user_name='"+user.getUserName()+
			"',sex='"+user.getSex()+
			"',home_address='"+user.getHomeAddress()+
			"',email='"+user.getEmail()+
			"',provinceId='"+user.getProvinceId()+
			"',cityId='"+user.getCityId()+"' where userid="+user.getUserid();
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//登录验证
	public UsersVo login1(String name, String pwd) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from users where user_name='"+name +"' and password='"+pwd +"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				user.setProvinceName(rs.getString("provinceName"));
				user.setCityName(rs.getString("cityName"));
			}else{
				user=null;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public UsersVo login2(String mobile, String pwd) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from users where mobile='"+mobile +"' and password='"+pwd +"'";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
			}else{
				user=null;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//查询省份
	public UsersVo finduserById() {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select c.*,s.provinceName from users c inner join province s on c.provinceId=s.provinceId";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				user.setProvinceName(rs.getString("provinceName").trim());
				user.setCityName(rs.getString("cityName").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//查询城市
	public UsersVo finduserById1(String userid) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select c.*,s.cityName from users c inner join city s on c.cityId=s.cityId where userid="+userid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				user.setProvinceName(rs.getString("provinceName"));
				user.setCityName(rs.getString("cityName").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	//查找教师资料
	public TeacherVo findteacherById(int userid) {
		Connection conn = DBConn.openDB();
		TeacherVo teacher= new TeacherVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select t.*,b.bank_name from teacher t inner join bank b on t.bank_id=b.bank_id where userid="+userid;
//			String sql = "select * from teacher where userid="+userid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				teacher.setUserid(rs.getInt("userid"));
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special").trim());
				teacher.setTeacherLength(rs.getString("teacher_length"));
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url"));
				teacher.setBankId(rs.getInt("bank_id"));
				teacher.setAccountNo(rs.getString("accountNo").trim());
				teacher.setAccountName(rs.getString("accountName").trim());
				teacher.setGradeId(rs.getInt("grade_id"));
				teacher.setStatus(rs.getInt("status"));
				teacher.setReason(rs.getString("reason").trim());
				teacher.setBankName(rs.getString("bank_name").trim());
			}else{
				teacher=null;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}
	public boolean teacherIsExist(int teacherId){
		Connection conn = DBConn.openDB();
		boolean bok=false;
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from teacher t where userid="+teacherId;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				bok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bok;
	}
	//分页
	public List<TeacherVo> findteacherByPage(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<TeacherVo> list = new ArrayList<TeacherVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" userid,teacher_introduce,teacher_special,teacher_length,education,head_picture_url,accountNo,accountName,status,reason,b.bank_name,g.grade_name,t.grade_id from teacher t ";
			sql += " inner join bank b on t.bank_id=b.bank_id inner join teacherGrade g on t.grade_id=g.grade_id ";
			sql += " where userid not in(select top "+startPos +" userid from teacher order by status) order by status";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeacherVo teacher = new TeacherVo();
				teacher.setUserid(rs.getInt("userid"));
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special"));
				teacher.setTeacherLength(rs.getString("teacher_length"));
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url"));
				teacher.setAccountNo(rs.getString("accountNo"));
				teacher.setAccountName(rs.getString("accountName"));
				teacher.setStatus(rs.getInt("status"));
				teacher.setReason(rs.getString("reason"));
				teacher.setBankName(rs.getString("bank_name"));
				teacher.setGradeName(rs.getString("grade_name"));
				teacher.setGradeId(rs.getInt("grade_id"));
				list.add(teacher);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void teacherAudit(TeacherVo teacher){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update Teacher set";
			sql += " grade_id='"+teacher.getGradeId()+"',";
			sql += "status='"+teacher.getStatus()+"',";
			sql += "reason='"+teacher.getReason()+"'";
			sql += " where userid="+teacher.getUserid();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			if(teacher.getStatus()==1){
				sql = "update users set user_type=2 where userid="+teacher.getUserid();
				stmt.executeUpdate(sql);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//新增教师
	public void teacherAdd(TeacherVo teacher) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into Teacher values(";
			sql += "'"+teacher.getUserid() +"',";
			sql += "'"+teacher.getTeacherIntroduce()+"',";
			sql += "'"+teacher.getTeacherSpecial()+"',";
			sql += "'"+teacher.getTeacherLength()+"',";
			sql += "'"+teacher.getEducation()+"',";
			sql += "'"+teacher.getHeadpictureUrl()+"',";
			sql += "'"+teacher.getBankId()+"',";
			sql += "'"+teacher.getAccountNo()+"',";
			sql += "'"+teacher.getAccountName()+"',";
			sql += "'"+teacher.getGradeId()+"',";
			sql += "'"+teacher.getStatus()+"',";
			sql += "'"+teacher.getReason()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除教师
	public void teacherDel(int userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete teacher where userid="+userid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询讲师
	public List<TeacherVo> teacherList() {
		Connection conn=DBConn.openDB();
		List<TeacherVo> list=new ArrayList<TeacherVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from teacher";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				TeacherVo teacher=new TeacherVo();
				teacher.setUserid(rs.getInt("userid"));
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special").trim());
				teacher.setTeacherLength(rs.getString("teacher_length").trim());
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url").trim());
				teacher.setBankId(rs.getInt("bank_id"));
				teacher.setAccountNo(rs.getString("accountNo").trim());
				teacher.setAccountName(rs.getString("accountName").trim());
				teacher.setGradeId(rs.getInt("grade_id"));
				teacher.setStatus(rs.getInt("status"));
				teacher.setReason(rs.getString("reason").trim());
				list.add(teacher);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改教师
	public void teacherUpdate(TeacherVo teacher) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update Teacher set";
			sql += " teacher_introduce='"+teacher.getTeacherIntroduce()+"',";
			sql += "teacher_special='"+teacher.getTeacherSpecial()+"',";
			sql += "teacher_length='"+teacher.getTeacherLength()+"',";
			sql += "education='"+teacher.getEducation()+"',";
			if(teacher.getHeadpictureUrl()!=null && !teacher.getHeadpictureUrl().equals("")){
				sql += "head_picture_url='"+teacher.getHeadpictureUrl()+"',";
			}
			sql += "bank_id='"+teacher.getBankId()+"',";
			sql += "accountNo='"+teacher.getAccountNo()+"',";
			sql += "accountName='"+teacher.getAccountName()+"'";
			sql += " where userid="+teacher.getUserid();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//更改状态(未审核，已审核，审核未通过，封号)
	public void updatestatus(String userid,int status) {
		Connection conn = DBConn.openDB();
		TeacherVo teacher = new TeacherVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update Teacher set status='"+status+"'where userid="+userid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//用户修改
	public void userUpdate(String userid) {
		Connection conn = DBConn.openDB();
		
		try {
			Statement stm=conn.createStatement();
			String sql="update users set user_type='2' where userid="+userid;
			System.out.println("多个="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//教师修改
	public void teacherStatus(String userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update Teacher set status=1 where userid="+userid;
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//通过id查找
	public NewMsgVo findNewMsgById(String newMsgId) {
		Connection conn = DBConn.openDB();
		NewMsgVo msg= new NewMsgVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from NewMsg where new_msg_id="+newMsgId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				msg.setNewMsgId(rs.getInt("new_msg_id"));
				msg.setMsgName(rs.getString("msg_name").trim());
				msg.setOneWord(rs.getString("one_word"));
				msg.setMsgContent(rs.getString("msg_content"));
				msg.setMsgContentUrl(rs.getString("msg_content_url").trim());
				msg.setPublishDate(rs.getString("publish_date"));
				msg.setPublishUsername(rs.getString("publish_username"));
				msg.setEffective(rs.getInt("effective"));
				msg.setSeq(rs.getInt("seq"));
				msg.setNewsType(rs.getInt("newsType"));
				msg.setImageUrl(rs.getString("image_Url"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return msg;
	}
	//删除
	public void newMsgDel(String newMsgId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete NewMsg where new_msg_id="+newMsgId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//修改
	public void newMsgUpdate(NewMsgVo msg) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update NewMsg set  msg_name='"+msg.getMsgName()+
			"',one_word='"+msg.getOneWord()+
			"',msg_content='"+msg.getMsgContent()+
			"',msg_content_url='"+msg.getMsgContentUrl()+
			"',publish_date='"+new Date().toLocaleString()+
			"',effective='"+msg.getEffective()+
			"',seq='"+msg.getSeq()+
			"',newsType='"+msg.getNewsType()+
			"',Image_Url='"+msg.getImageUrl()+"' where new_msg_id="+msg.getNewMsgId();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查询
	public List<NewMsgVo> newmsgList() {
		Connection conn=DBConn.openDB();
		List<NewMsgVo> list=new ArrayList<NewMsgVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from NewMsg";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				NewMsgVo msg=new NewMsgVo();
				msg.setNewMsgId(rs.getInt("new_msg_id"));
				msg.setMsgName(rs.getString("msg_name").trim());
				msg.setOneWord(rs.getString("one_word"));
				msg.setMsgContent(rs.getString("msg_content"));
				msg.setMsgContentUrl(rs.getString("msg_content_url").trim());
				msg.setPublishDate(rs.getString("publish_date"));
				msg.setPublishUsername(rs.getString("publish_username"));
				msg.setEffective(rs.getInt("effective"));
				msg.setSeq(rs.getInt("seq"));
				msg.setNewsType(rs.getInt("newsType"));
				msg.setImageUrl(rs.getString("image_Url"));
				list.add(msg);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<NewMsgVo> newmsgList(String name) {
		Connection conn = DBConn.openDB();
		List<NewMsgVo> list=new ArrayList<NewMsgVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from NewMsg where  msg_name  like '%"+name+"%'";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				NewMsgVo msg=new NewMsgVo();
				msg.setNewMsgId(rs.getInt("new_msg_id"));
				msg.setMsgName(rs.getString("msg_name").trim());
				msg.setOneWord(rs.getString("one_word"));
				msg.setMsgContent(rs.getString("msg_content"));
				msg.setMsgContentUrl(rs.getString("msg_content_url").trim());
				msg.setPublishDate(rs.getString("publish_date"));
				msg.setPublishUsername(rs.getString("publish_username"));
				msg.setEffective(rs.getInt("effective"));
				msg.setSeq(rs.getInt("seq"));
				msg.setNewsType(rs.getInt("newsType"));
				msg.setImageUrl(rs.getString("image_Url"));
				list.add(msg);
			}
			stm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	//新增
	public void newsMsgAdd(NewMsgVo msg) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into NewMsg values(";
			sql += "'"+msg.getMsgName() +"',";
			sql += "'"+msg.getOneWord()+"',";
			sql += "'"+msg.getMsgContent()+"',";
			sql += "'"+msg.getMsgContentUrl()+"',";
			sql += "'"+msg.getPublishDate()+"',";
			sql += "'"+msg.getPublishUsername()+"',";
			sql += "'"+msg.getEffective()+"',";
			sql += "'"+msg.getSeq()+"',";
			sql += "'"+msg.getNewsType()+"',";
			sql += "'"+msg.getImageUrl()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//分页
	public List<NewMsgVo> findNewMsgById(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<NewMsgVo> list = new ArrayList<NewMsgVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" new_msg_id,msg_name,one_word,msg_content,msg_content_url,publish_date,publish_username,effective,seq,newsType,image_Url from NewMsg ";
			sql += " where new_msg_id not in(select top "+startPos +" new_msg_id from NewMsg order by seq desc) order by seq desc";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				NewMsgVo msg= new NewMsgVo();
				msg.setNewMsgId(rs.getInt("new_msg_id"));
				msg.setMsgName(rs.getString("msg_name").trim());
				msg.setOneWord(rs.getString("one_word"));
				msg.setMsgContent(rs.getString("msg_content"));
				msg.setMsgContentUrl(rs.getString("msg_content_url").trim());
				msg.setPublishDate(rs.getString("publish_date"));
				msg.setPublishUsername(rs.getString("publish_username"));
				msg.setEffective(rs.getInt("effective"));
				msg.setSeq(rs.getInt("seq"));
				msg.setNewsType(rs.getInt("newsType"));
				msg.setImageUrl(rs.getString("image_Url"));
				list.add(msg);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//新增
	public void courseAdd(CourseVo course) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into Course(course_name,picture_url,one_word,introduce,course_count,price,discount,effective,replay_date,user_name,seq,charge_type,status,reason) values('"+course.getCoursename()
			+"','"+course.getPictureurl()
			+"','"+course.getOneword()+
			"','"+course.getIntroduce()+"','"+course.getCoursecount()
			+"','"+course.getPrice()+
			"','"+course.getDiscount()+"','"+course.getEffective()+
			"','"+new Date().toLocaleString()+
			"','"+course.getUsername()+"','"+course.getSeq()+"','"+course.getChargetype()+
			"','"+course.getStatus()+"','"+0+"')";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除
	public void courseDel(int Courseid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete Course where course_id="+Courseid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询
	public List<CourseVo> courseList() {
		Connection conn=DBConn.openDB();
		List<CourseVo> list=new ArrayList<CourseVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from Course";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				CourseVo course=new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name"));
				course.setPictureurl(rs.getString("picture_url"));
				course.setOneword(rs.getString("one_word"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setUsername(rs.getString("user_name"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				course.setUserid(rs.getInt("userid"));
				list.add(course);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改
	public void courseUpdate(CourseVo course) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update Course set";
			sql+="',course_name='"+course.getCoursename()+
			"',one_word='"+course.getOneword()+
			"',introduce='"+course.getIntroduce()+
			"',course_count='"+course.getCoursecount()+
			"',price='"+course.getPrice()+
			"',discount='"+course.getDiscount()+
			"',effective='"+course.getEffective()+
			"',replay_date='"+new Date().toLocaleString()+
			"',user_name='"+course.getUsername()+
			"',seq='"+course.getSeq()+
			"',charge_type='"+course.getChargetype()+
			"',status='"+course.getStatus()+
			"',reason='"+course.getReason()+
			"',userid='"+course.getUserid()+"' where course_id="+course.getCourseid();
			if(course.getPictureurl()!=null && !course.getPictureurl().equals("")){
				sql += "picture_url='"+course.getPictureurl()+"',";
			}
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//查找
	public CourseVo findcourseById(String courseid){
		Connection conn = DBConn.openDB();
		CourseVo course= new CourseVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from course where course_id="+courseid;
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println(sql);
			if(rs.next()){
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name").trim());
				course.setPictureurl(rs.getString("picture_url"));
				course.setOneword(rs.getString("one_word"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setUsername(rs.getString("user_name"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				course.setUserid(rs.getInt("userid"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return course;
	}
	
	//分页
	public List<CourseVo> findcourseById(int userid,int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<CourseVo> list = new ArrayList<CourseVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from course  ";
			sql += " where userid="+userid+" and  course_id not in(select top "+startPos +" course_id from course where userid="+userid+" order by course_id) order by course_id";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CourseVo course= new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name").trim());
				course.setPictureurl(rs.getString("picture_url"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				list.add(course);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<CourseVo> findcourseById(int pageSize, int startPos){
		Connection conn = DBConn.openDB();
		List<CourseVo> list = new ArrayList<CourseVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" course_id,course_name,picture_url,one_word,introduce,course_count,price,discount,effective,replay_date,user_name,seq,charge_type,status,reason,userid from Course ";
			sql += " where course_id not in(select top "+startPos +" course_id from Course order by seq desc) order by seq desc";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CourseVo course= new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name").trim());
				course.setUsername(rs.getString("user_name"));
				course.setPictureurl(rs.getString("picture_url"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				list.add(course);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//更改状态
	public void courseEffective(String couseid) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm =conn.createStatement();
			String sql="update Course set effective=0 where course_id="+couseid;
			System.out.println("sdfgfdsf="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void courseEffective2(String couseid) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm =conn.createStatement();
			String sql="update Course set effective=1 where course_id="+couseid;
			System.out.println("sdfgfdsf="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public void courseAudit(CourseVo course) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update Course set";
			sql += " status='"+course.getStatus()+"',";
			sql += "effective='"+course.getEffective()+"',";
			sql += "reason='"+course.getReason()+"'";
			sql += " where course_id="+course.getCourseid();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean courseIsExist(int courseid) {
		Connection conn = DBConn.openDB();
		boolean bok=false;
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from Course c where course_id="+courseid;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				bok=true;
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bok;
	}
	
	public List<CourseVo> courseList(String coursename,int status,String username) {
		Connection conn=DBConn.openDB();
		List<CourseVo> list=new ArrayList<CourseVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select c.*,s.accountName from  Course c inner join Teacher s on c.userid=s.userid where s.accountName like '%"+username+"%' or c.course_name like '%"+coursename+"%' or c.status like '%"+status+"%'";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				CourseVo course=new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name"));
				course.setPictureurl(rs.getString("picture_url"));
				course.setOneword(rs.getString("one_word"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setUsername(rs.getString("user_name"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				course.setUserid(rs.getInt("userid"));
				course.setAccountname(rs.getString("accountName"));
				list.add(course);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	//按id查询数据
	public SectionVo findsectionById(String sectionid) {
		Connection conn = DBConn.openDB();
		List<SectionVo> list = new ArrayList<SectionVo>();
		SectionVo section= new SectionVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from section where section_id="+sectionid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				section.setSectionid(rs.getInt("section_id"));
				section.setCourseid(rs.getInt("course_id"));
				section.setSectionname(rs.getString("section_name").trim());
				section.setSectionurl(rs.getString("section_url"));
				section.setSectioncontent(rs.getString("section_content"));
				section.setFree(rs.getInt("free"));
				section.setSeq(rs.getInt("seq"));
				section.setStatus(rs.getInt("status"));
				section.setReason(rs.getString("reason"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return section;
	}
	
	public void sectionAudit(SectionVo section) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update section set status='"+section.getStatus()+"', reason='"+section.getReason()+"' where section_id="+section.getSectionid();
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//分页
	public List<SectionVo> findsectionById(int courseid,int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<SectionVo> list = new ArrayList<SectionVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from section  ";
			sql += " where course_id="+courseid+" and  section_id not in(select top "+startPos +" section_id from section where course_id="+courseid+" order by section_id) order by section_id";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				SectionVo section= new SectionVo();
				section.setSectionid(rs.getInt("section_id"));
				section.setCourseid(rs.getInt("course_id"));
				section.setSectionname(rs.getString("section_name").trim());
				section.setSectionurl(rs.getString("section_url"));
				section.setSectioncontent(rs.getString("section_content"));
				section.setFree(rs.getInt("free"));
				section.setSeq(rs.getInt("seq"));
				section.setStatus(rs.getInt("status"));
				section.setReason(rs.getString("reason"));
				list.add(section);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//分页
	public List<SectionVo> findsectionById(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<SectionVo> list = new ArrayList<SectionVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" section_id,course_id,section_name,section_url,section_content,free,seq,status,reason from section ";
			sql += " where section_id not in(select top "+startPos +" section_id from section order by seq desc) order by seq desc";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				SectionVo section= new SectionVo();
				section.setSectionid(rs.getInt("section_id"));
				section.setCourseid(rs.getInt("course_id"));
				section.setSectionname(rs.getString("section_name").trim());
				section.setSectionurl(rs.getString("section_url"));
				section.setSectioncontent(rs.getString("section_content"));
				section.setFree(rs.getInt("free"));
				section.setSeq(rs.getInt("seq"));
				section.setStatus(rs.getInt("status"));
				section.setReason(rs.getString("reason"));
				list.add(section);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//新增
	public void sectionAdd(SectionVo section) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into section values(";
			sql += "'"+section.getCourseid() +"',";
			sql += "'"+section.getSectionname()+"',";
			sql += "'"+section.getSectionurl()+"',";
			sql += "'"+section.getSectioncontent()+"',";
			sql += "'"+section.getFree()+"',";
			sql += "'"+section.getSeq()+"',";
			sql += "'"+section.getStatus()+"',";
			sql += "'"+section.getReason()+"',";
			sql += "'"+section.getRemark()+"',";
			sql += "'"+section.getTimelength()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除
	public void sectionDel(int sectionid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete Section where section_id="+sectionid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//查询
	public List<SectionVo> sectionList() {
		Connection conn=DBConn.openDB();
		List<SectionVo> list=new ArrayList<SectionVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from Section";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				SectionVo section=new SectionVo();
				section.setSectionid(rs.getInt("section_id"));
				section.setCourseid(rs.getInt("course_id"));
				section.setSectionname(rs.getString("section_name").trim());
				section.setSectionurl(rs.getString("section_url").trim());
				section.setSectioncontent(rs.getString("section_content").trim());
				section.setRemark(rs.getString("remark").trim());
				section.setFree(Integer.parseInt("free"));
				section.setSeq(Integer.parseInt("seq"));
				section.setStatus(rs.getInt("status"));
				section.setReason(rs.getString("reason").trim());
				list.add(section);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改
	public void sectionUpdate(SectionVo section) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update Section set section_name='"+section.getSectionname();
			sql+="',section_content='"+section.getSectioncontent();
			sql+="',free='"+section.getFree();
			sql+="',seq='"+section.getSeq()+"' where section_id="+section.getSectionid();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//更改状态
	public void updateStatus1(String sectionid, int status) {
		Connection conn = DBConn.openDB();
		SectionVo section = new SectionVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "update Section set status='"+status+"'where section_id="+sectionid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void moneyAdd(float ymoney, float xmoney, String recordid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update moneyRecord set  pay_date=getdate(),  pay_money="+ymoney+"+"+xmoney+" where record_id="+recordid;
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void moneyAdd2(String userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="insert into moneyRecord values("+userid+",getdate(),0)";
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void moneyUser(String userid,float ymoney,float xmoney) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update users set remainMoney="+ymoney+"+"+xmoney+" where userid="+userid;
			System.out.println("sdfsdfds="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//通过id查找数据
	public MoneyRecordVo findmoneyById(String recordId) {
		Connection conn = DBConn.openDB();
		MoneyRecordVo money= new MoneyRecordVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select m.*,u.user_name from moneyRecord m inner join users u on m.userid=u.userid where m.userid="+recordId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				money.setRecordid(rs.getInt("record_id"));
				money.setUserid(rs.getInt("userid"));
				money.setPaydate(rs.getDate("pay_date"));
				money.setPaymoney(rs.getFloat("pay_money"));
				money.setUsername(rs.getString("user_name"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return money;
	}
	//分页
	public List<MoneyRecordVo> findmoneyById(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<MoneyRecordVo> list = new ArrayList<MoneyRecordVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select  top "+pageSize+" c.*,s.user_name from   moneyRecord c inner join users s  on c.userid=s.userid where record_id not in(select top "+startPos+" record_id from moneyRecord)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				MoneyRecordVo money = new MoneyRecordVo();
				money.setRecordid(rs.getInt("record_id"));
				money.setUserid(rs.getInt("userid"));
				money.setPaydate(rs.getDate("pay_date"));
				money.setPaymoney(rs.getFloat("pay_money"));
				money.setUsername(rs.getString("user_name"));
				list.add(money);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//查询列表
	public List<MoneyRecordVo> moneyList() {
		Connection conn=DBConn.openDB();
		List<MoneyRecordVo> list=new ArrayList<MoneyRecordVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from moneyRecord";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				MoneyRecordVo money=new MoneyRecordVo();
				money.setRecordid(rs.getInt("record_id"));
				money.setUserid(rs.getInt("userid"));
				money.setPaydate(rs.getDate("pay_date"));
				money.setPaymoney(rs.getFloat("pay_money"));
				list.add(money);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//新增
	public void moneyRecordAdd(MoneyRecordVo money) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into moneyRecord values(";
			sql += "'"+money.getUserid()+"',";
			sql += "'"+new Date().toLocaleString()+"',";
			sql += "'"+money.getPaymoney()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//删除
	public void moneyRecordDel(int recordId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete moneyRecord where record_id="+recordId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//修改
	public void moneyRecordUpdate(MoneyRecordVo money) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update moneyrecord set  userid='"+money.getUserid()+
			"',pay_date='"+money.getPaydate()+
			"',pay_money='"+money.getPaymoney()+"' where record_id="+money.getRecordid();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//新增
	public void couponRecordAdd(CouponRecord coupon){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into CouponRecord values(";
			sql += "'"+coupon.getActivityName() +"',";
			sql += "'"+coupon.getActivityDesc()+"',";
			sql += "'"+coupon.getUserid()+"',getdate()";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//分页
	public List<CouponRecord> couponRecordList(int teacherId,int pageSize,int startPos){
		Connection conn = DBConn.openDB();
		List<CouponRecord> list = new ArrayList<CouponRecord>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from CouponRecord  ";
			sql += " where userid="+teacherId+" and  couponRecordId not in(select top "+startPos +" couponRecordId from CouponRecord where userid="+teacherId+" order by couponRecordId desc) order by couponRecordId desc";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CouponRecord coupon= new CouponRecord();
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setActivityName(rs.getString("activityName").trim());
				coupon.setActivityDesc(rs.getString("activityDesc"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCreateDate(rs.getString("createDate"));
				list.add(coupon);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public  List<CouponCode> couponCodeList(int pageSize,int startPos){
		Connection conn = DBConn.openDB();
		List<CouponCode> list = new ArrayList<CouponCode>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from CouponCode where couponCodeId not in(select top "+startPos+" couponCodeId from CouponCode)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CouponCode coupon= new CouponCode();
				coupon.setCouponCodeId(rs.getInt("couponCodeId"));
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCode(rs.getString("code"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCouponMoney(rs.getInt("couponMoney"));
				coupon.setStatus(rs.getInt("status"));
				coupon.setValidDay(rs.getInt("validDay"));
				coupon.setUseDate(rs.getString("useDate"));
				list.add(coupon);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//删除
	public void couponRecordDel(int couponRecordId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete CouponRecord where couponRecordId="+couponRecordId;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询
	public List<CouponRecord> couponRecordList() {
		Connection conn=DBConn.openDB();
		List<CouponRecord> list=new ArrayList<CouponRecord>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select * from CouponRecord";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				CouponRecord coupon= new CouponRecord();
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setActivityName(rs.getString("activityName").trim());
				coupon.setActivityDesc(rs.getString("activityDesc"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCreateDate(rs.getString("createDate"));
				list.add(coupon);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//修改
	public void couponRecordUpdate(CouponRecord coupon) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update CouponRecord set activityName='"+coupon.getActivityName()+"',createDate=getdate(), activityDesc='"+coupon.getActivityDesc()+"' where couponRecordId="+coupon.getCouponRecordId();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//通过id查询
	public CouponRecord findCouponRecord(String couponRecordId) {
		Connection conn = DBConn.openDB();
		CouponRecord coupon= new CouponRecord();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from CouponRecord where couponRecordId="+couponRecordId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setActivityName(rs.getString("activityName").trim());
				coupon.setActivityDesc(rs.getString("activityDesc"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCreateDate(rs.getString("createDate"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}
	//产生随机兑换码
	private String procudeCode() throws SQLException{
		Random rand = new Random();
		String sql = "";
		long cnt = 0;
		int suffix=0;
		String prefix="";
		Connection conn = DBConn.openDB();
		Statement stmt = conn.createStatement();
		do{
			suffix=rand.nextInt(899999)+100000;
			prefix = ContextUtils.produceExchangeCode()+suffix;
			sql = "select count(code) cnt from CouponCode where code='"+prefix+"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				cnt = rs.getInt("cnt");
			}
		}while(cnt>0);
		stmt.close();
		return prefix;
	}
	//新增
	public void couponCodeAdd(int recordid,int money,int day,int count){
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "";
			for(int i=0;i<count;i++){
				sql = "insert into CouponCode(couponRecordId,code,couponMoney,status,validDay) values(";
				sql += "'"+recordid +"',";
				sql += "'"+procudeCode()+"',";
				sql += "'"+money+"',";
				sql += "'0',";
				sql += "'"+day+"'";
				sql += ")";
				stmt.executeUpdate(sql);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//查询
	public List<CouponCode> couponCodeList(int couponRecordId){
		Connection conn = DBConn.openDB();
		List<CouponCode> list = new ArrayList<CouponCode>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from CouponCode where couponRecordId="+couponRecordId +" order by couponRecordId desc";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CouponCode code= new CouponCode();
				code.setCouponCodeId(rs.getInt("couponCodeId"));
				code.setCouponRecordId(rs.getInt("couponRecordId"));
				code.setUserid(rs.getInt("userid"));
				code.setCode(rs.getString("code"));
				code.setCouponMoney(rs.getInt("couponMoney"));
				code.setStatus(rs.getInt("status"));
				code.setValidDay(rs.getInt("validDay"));
				if(code.getStatus()==1){
					code.setUseDate(new Date().toLocaleString());
				}
				list.add(code);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<CourseVo> courseList2(int userId, int pageSize,int startPos) {
		
		Connection conn = DBConn.openDB();
		List<CourseVo> list = new ArrayList<CourseVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from course  ";
			sql += " where status=1 and userid="+userId+" and  course_id not in(select top "+startPos +" course_id from course where userid="+userId+" order by course_id desc) order by  course_id desc ";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				CourseVo course= new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name").trim());
				course.setPictureurl(rs.getString("picture_url"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				list.add(course);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<CourseVo> courseList(String name) {
		Connection conn = DBConn.openDB();
		List<CourseVo> list=new ArrayList<CourseVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select c.*,u.user_name from Course c inner join users u on c.userid=u.userid where u.user_name like '%"+name+"%' or c.course_name like '%"+name+"%'";
			System.out.println("sdfg==="+sql);
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				CourseVo course=new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name"));
				course.setPictureurl(rs.getString("picture_url"));
				course.setOneword(rs.getString("one_word"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setUsername(rs.getString("user_name"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				course.setUserid(rs.getInt("userid"));
				course.setUsername(rs.getString("user_name"));
				list.add(course);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public List<UserCourseEvalVo> UserCourseEvalList(String courseId){
		Connection conn = DBConn.openDB();
		List<UserCourseEvalVo> list = new ArrayList<UserCourseEvalVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select c.*,u.user_name from usercourseeval c inner join users u on c.userid=u.userid where c.course_Id="+courseId;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				UserCourseEvalVo uce= new UserCourseEvalVo();
				uce.setUsercourseevalid(rs.getInt("user_course_eval_id"));
				uce.setUserid(rs.getInt("userid"));
				uce.setCourseid(rs.getInt("course_id"));
				uce.setEvallevel(rs.getInt("eval_level"));
				uce.setEvalcontent(rs.getString("eval_content"));
				uce.setEvaldate(rs.getDate("eval_date"));
				uce.setUserName(rs.getString("user_name"));
				list.add(uce);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public CouponCode couponCodeList(String courseId){
		Connection conn = DBConn.openDB();
		CouponCode code= null;
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top 1 * from couponCode where status=0 and couponRecordId in (select couponRecordId from couponRecord where userid=(select userid from course where course_id="+courseId+"));";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				code= new CouponCode();
				code.setCouponCodeId(rs.getInt("couponCodeId"));
				code.setCouponRecordId(rs.getInt("couponRecordId"));
				code.setUserid(rs.getInt("userid"));
				code.setCode(rs.getString("code"));
				code.setCouponMoney(rs.getInt("couponMoney"));
				code.setStatus(rs.getInt("status"));
				code.setValidDay(rs.getInt("validDay"));
				if(code.getStatus()==1){
					code.setUseDate(new Date().toLocaleString());
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return code;
	}
	
	public void CouponCodeLin(int userid, String couponCodeId) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update CouponCode set status=1,userid="+userid+" where couponCodeId="+couponCodeId;
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public  void CouponCodeLin1(String useDate,String couponCodeId){
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update CouponCode set  useDate=getdate()  where couponCodeId="+couponCodeId;
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public CouponCode couponFint(String codeid) {
		Connection conn = DBConn.openDB();
		CouponCode coupon=null;
		try {
			Statement stm=conn.createStatement();
			String sql="select * from CouponCode  where couponCodeId="+codeid;
			System.out.println(sql);
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()){
				coupon=new CouponCode();
				coupon.setCouponCodeId(rs.getInt("couponCodeId"));
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCode(rs.getString("code"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCouponMoney(rs.getInt("couponMoney"));
				coupon.setStatus(rs.getInt("status"));
				coupon.setValidDay(rs.getInt("validDay"));
				if(coupon.getStatus()==1){
					coupon.setUseDate(new Date().toLocaleString());
				}
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}

	public CouponCode couponFint1(int userid) {
		Connection conn = DBConn.openDB();
		CouponCode coupon=null;
		try {
			Statement stm=conn.createStatement();
			String sql="select * from CouponCode  where userid="+userid;
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()){
				coupon=new CouponCode();
				coupon.setCouponCodeId(rs.getInt("couponCodeId"));
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCode(rs.getString("code"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCouponMoney(rs.getInt("couponMoney"));
				coupon.setStatus(rs.getInt("status"));
				coupon.setValidDay(rs.getInt("validDay"));
				if(coupon.getStatus()==1){
					coupon.setUseDate(new Date().toLocaleString());
				}
			}else{
				coupon=null;
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}
	
	public List<CouponCode> couponFint(int codeid) {
		Connection conn = DBConn.openDB();
		List<CouponCode> list=new ArrayList<CouponCode>();
		try {
			Statement stm=conn.createStatement();
			String sql="select * from CouponCode  where userid="+codeid;
			System.out.println(sql);
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				CouponCode coupon=new CouponCode();
				coupon.setCouponCodeId(rs.getInt("couponCodeId"));
				coupon.setCouponRecordId(rs.getInt("couponRecordId"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCode(rs.getString("code"));
				coupon.setUserid(rs.getInt("userid"));
				coupon.setCouponMoney(rs.getInt("couponMoney"));
				coupon.setStatus(rs.getInt("status"));
				coupon.setValidDay(rs.getInt("validDay"));
				if(coupon.getStatus()==1){
					coupon.setUseDate(new Date().toLocaleString());
				}
				list.add(coupon);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//分页
	public List<UserCourseEvalVo> findusercourse(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<UserCourseEvalVo> list = new ArrayList<UserCourseEvalVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from UserCourseEval where user_course_eval_id not in(select top "+startPos+" user_course_eval_id from UserCourseEval)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				UserCourseEvalVo usercourse = new UserCourseEvalVo();
				usercourse.setUsercourseevalid(rs.getInt("user_course_eval_id"));
				usercourse.setUserid(rs.getInt("userid"));
				usercourse.setCourseid(rs.getInt("course_id"));
				usercourse.setEvallevel(rs.getInt("eval_level"));
				usercourse.setEvalcontent(rs.getString("eval_content").trim());
				usercourse.setEvaldate(rs.getDate("eval_date"));
				usercourse.setUserName(rs.getString("user_name").trim());
				list.add(usercourse);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//通过id查找数据
	public UserCourseEvalVo findusercourseById(String usercourseevalid) {
		Connection conn = DBConn.openDB();
		UserCourseEvalVo usercourse= new UserCourseEvalVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from UserCourseEval where user_course_eval_id="+usercourseevalid;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				usercourse.setUsercourseevalid(rs.getInt("user_course_eval_id"));
				usercourse.setUserid(rs.getInt("userid"));
				usercourse.setUserName(rs.getString("user_name").trim());
				usercourse.setCourseid(rs.getInt("course_id"));
				usercourse.setEvallevel(rs.getInt("eval_level"));
				usercourse.setEvalcontent(rs.getString("eval_content").trim());
				usercourse.setEvaldate(rs.getDate("eval_date"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usercourse;
	}
	//新增
	public void usercourseAdd(UserCourseEvalVo usercourse) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into UserCourseEval values(";
			sql += "'"+usercourse.getUserid() +"',";
			sql += "'"+usercourse.getCourseid()+"',";
			sql += "'"+usercourse.getEvallevel()+"',";
			sql += "'"+usercourse.getEvalcontent()+"',getdate(),";
			sql += "'"+usercourse.getUserName()+"'";
			sql += ")";
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<PayRecordVo> PayRecordList(int userid,int pageSize,int startPos) {
		Connection conn = DBConn.openDB();
		List<PayRecordVo> list=new ArrayList<PayRecordVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select top "+pageSize+" p.*,c.* from PayRecord  p inner join   Course c  on p.courseid=c.course_id  where      p.userid="+userid+" and  p.userid not in(select   top "+startPos+" p.userid    from PayRecord)";
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()){
				PayRecordVo	payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
				payrecord.setCourseid(rs.getInt("course_id"));
				payrecord.setCoursename(rs.getString("course_name"));
				payrecord.setPictureurl(rs.getString("picture_url"));
				payrecord.setOneword(rs.getString("one_word"));
				payrecord.setIntroduce(rs.getString("introduce"));
				payrecord.setCoursecount(rs.getInt("course_count"));
				payrecord.setPrice(rs.getFloat("price"));
				payrecord.setDiscount(rs.getFloat("discount"));
				payrecord.setEffective(rs.getInt("effective"));
				payrecord.setReplaydate(rs.getDate("replay_date"));
				payrecord.setUsername(rs.getString("user_name"));
				payrecord.setSeq(rs.getInt("seq"));
				payrecord.setChargetype(rs.getInt("charge_type"));
				payrecord.setStatus(rs.getInt("status"));
				payrecord.setReason(rs.getString("reason"));
				payrecord.setUserid(rs.getInt("userid"));
				list.add(payrecord);
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public UserCourseEvalVo userCourseEvalFint(String courseid) {
		Connection conn = DBConn.openDB();
		UserCourseEvalVo usercourse=null;
		try {
			Statement stm=conn.createStatement();
			String sql="select userid  from UserCourseEval where course_id="+courseid;
			System.out.println(sql);
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()){
				usercourse=new UserCourseEvalVo();
				usercourse.setUserid(rs.getInt("userid"));
				usercourse.setCourseid(rs.getInt("course_id"));
			}else{
				usercourse=null;
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usercourse;
	}
	//修改
	public void usercourseUpdate(UserCourseEvalVo usercourse) {
		Connection conn=DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update usercourseeval set userid='"+usercourse.getUserid()+
			"',eval_level='"+usercourse.getEvallevel()+
			"',eval_content='"+usercourse.getEvalcontent()+
			"',eval_date=getdate  where user_course_eval_id="+usercourse.getUsercourseevalid();
			System.out.println(sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//删除
	public void usercourseDel(int usercourseevalid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete UserCourseEval where user_course_eval_id="+usercourseevalid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//查询
	public List<UserCourseEvalVo> usercourseList(int usercourseevalid) {
		Connection conn=DBConn.openDB();
		List<UserCourseEvalVo> list=new ArrayList<UserCourseEvalVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select u.*,c.course_name from UserCourseEval u inner join course c on u.course_id=c.course_id where user_course_eval_id="+usercourseevalid;
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				UserCourseEvalVo usercourse = new UserCourseEvalVo();
				usercourse.setUsercourseevalid(rs.getInt("user_course_eval_id"));
				usercourse.setUserid(rs.getInt("userid"));
				usercourse.setCourseid(rs.getInt("course_id"));
				usercourse.setCoursename(rs.getString("course_name"));
				usercourse.setEvallevel(rs.getInt("eval_level"));
				usercourse.setEvalcontent(rs.getString("eval_content").trim());
				usercourse.setEvaldate(rs.getDate("eval_date"));
				usercourse.setUserName(rs.getString("user_name").trim());
				list.add(usercourse);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//新增
	public void PayRecordAdd(PayRecordVo pay) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="insert into PayRecord values("+
			pay.getUserid()+","+pay.getCourseid()+
			",0,getdate(),"+pay.getPaymoney()
			+","+pay.getDiscountmoney()+",0,'支付宝','"+
			pay.getPayer()+"','007"+new Random().nextInt(9999)+"',1,0)";
			System.out.println("sadfsdfasdf="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//买课
	public void moneyRecordMoney(float moery, int userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update moneyRecord set  pay_money="+moery+"  where userid="+userid;
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void userMoney(float moery, int userid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update users set  remainMoney="+moery+"  where userid="+userid;
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public UsersVo finduserById(int userid) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select u.*,p.provincename,c.cityname from users u,province p,city c where userid="+userid+" and c.cityid=u.cityid and p.provinceid=u.provinceid";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				user.setProvinceName(rs.getString("provincename").trim());
				user.setCityName(rs.getString("cityname").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void CouponCodeDel(int couid) {
		Connection conn = DBConn.openDB();
		String sql="delete CouponCode where userid="+couid;
		try {
			Statement stm=conn.createStatement();
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public PayRecordVo PayRecordFint(int userid){
		Connection conn = DBConn.openDB();
		PayRecordVo payrecord=new PayRecordVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from PayRecord  where userid="+userid;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
//				payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payrecord;
	}
	//买课记录分页
	public List<PayRecordVo> findpayrecord(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<PayRecordVo> list=new ArrayList<PayRecordVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+" * from PayRecord where pay_record_id not in(select top "+startPos+" pay_record_id from PayRecord)";

			System.out.println("曾经课="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				PayRecordVo payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
				list.add(payrecord);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//查询
	public List<PayRecordVo> findpayrecord(int payrecordid) {
		Connection conn=DBConn.openDB();
		List<PayRecordVo> list=new ArrayList<PayRecordVo>();
		try {
			Statement stmt=conn.createStatement();
			String sql="select pay_record_id,courseid,pay_date,pay_money,payer,p.userid,c.course_name from PayRecord p inner join course c on p.courseid=c.course_id where pay_record_id="+payrecordid;
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				PayRecordVo payrecord=new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
				list.add(payrecord);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//删除
	public void payrecordDel(int payrecordid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete PayRecord where pay_record_id="+payrecordid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void teacherMOney(int userid,float yuer,float yuan) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update users set    remainMoney="+yuer+"+"+yuan+"   where userid="+userid;
			System.out.println("老师="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void teacherMOney(String userid,float yuer,float yuan) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update users set    remainMoney="+yuer+"+"+yuan+"   where userid="+userid;
			System.out.println("老师="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ForumAdd(ForumVo liu) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="insert into Forum values("+liu.getUserid()
			+","+liu.getReplayUserId()+",1,'"+liu.getContent()
			+"',getdate())";
			System.out.println("阿斯顿发大水="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ForumVo> fotuList(int userid) {
		Connection conn = DBConn.openDB();
		List<ForumVo> list=new ArrayList<ForumVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select    f.*,u.user_name from Forum  f inner join users u on f.userid=u.userid where f.ReplayUserId="+userid+"   order by f.forum_id desc";
			System.out.println("撒地方的="+sql);
			ResultSet rt=stm.executeQuery(sql);
			while(rt.next()){
				ForumVo ff=new ForumVo();
				ff.setForumid(rt.getInt("forum_id"));
				ff.setUserid(rt.getInt("userid"));
				ff.setReplayUserId(rt.getInt("ReplayUserId"));
				ff.setFourmtype(rt.getInt("fourm_type"));
				ff.setContent(rt.getString("Content"));
				ff.setForumdate(rt.getDate("forum_date"));
				ff.setUsername(rt.getString("user_name"));
				list.add(ff);
			}
			rt.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ForumVo> teacherLiuyan(String userid) {
		Connection conn = DBConn.openDB();
		List<ForumVo> list=new ArrayList<ForumVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select    f.*,u.user_name from Forum  f inner join users u on f.userid=u.userid where f.userid="+userid+"   order by f.forum_id desc";
			System.out.println("撒地方的="+sql);
			ResultSet rt=stm.executeQuery(sql);
			while(rt.next()){
				ForumVo ff=new ForumVo();
				ff.setForumid(rt.getInt("forum_id"));
				ff.setUserid(rt.getInt("userid"));
				ff.setReplayUserId(rt.getInt("ReplayUserId"));
				ff.setFourmtype(rt.getInt("fourm_type"));
				ff.setContent(rt.getString("Content"));
				ff.setForumdate(rt.getDate("forum_date"));
				ff.setUsername(rt.getString("user_name"));
				list.add(ff);
			}
			rt.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void ForumAdd2(ForumVo liu) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="insert into Forum values("+liu.getUserid()
			+","+liu.getReplayUserId()+",2,'"+liu.getContent()
			+"',getdate())";
			System.out.println("阿斯顿发大水="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ForumVo fintLiuyan(int userid) {
		Connection conn = DBConn.openDB();
		ForumVo ff=null;
		try {
			Statement stm=conn.createStatement();
			String sql="select * from Forum  where userid="+userid;
			System.out.println("sdfgsfd="+sql); 
			ResultSet rt=stm.executeQuery(sql);
				if(rt.next()){
					ff=new ForumVo();
					ff.setForumid(rt.getInt("forum_id"));
					ff.setUserid(rt.getInt("userid"));
					ff.setReplayUserId(rt.getInt("ReplayUserId"));
					ff.setFourmtype(rt.getInt("fourm_type"));
					ff.setContent(rt.getString("Content"));
					ff.setForumdate(rt.getDate("forum_date"));
				}else{
					ff=null;
				}
				rt.close();
				stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ff;
	}
	public List<ForumVo> teacherLiuyan2(int userid) {
		Connection conn = DBConn.openDB();
		List<ForumVo> list=new ArrayList<ForumVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select    f.*,u.user_name from Forum  f inner join users u on f.userid=u.userid where f.userid="+userid+"   order by f.forum_id desc";
			System.out.println("撒地方的="+sql);
			ResultSet rt=stm.executeQuery(sql);
			while(rt.next()){
				ForumVo ff=new ForumVo();
				ff.setForumid(rt.getInt("forum_id"));
				ff.setUserid(rt.getInt("userid"));
				ff.setReplayUserId(rt.getInt("ReplayUserId"));
				ff.setFourmtype(rt.getInt("fourm_type"));
				ff.setContent(rt.getString("Content"));
				ff.setForumdate(rt.getDate("forum_date"));
				ff.setUsername(rt.getString("user_name"));
				list.add(ff);
			}
			rt.close();
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<PayRecordVo> MaikeJilv() {
		Connection conn = DBConn.openDB();
		List<PayRecordVo> list=new ArrayList<PayRecordVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from PayRecord where courseid=2 or  courseid=5 or courseid=6 or courseid=7 or courseid=8";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				PayRecordVo payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
				list.add(payrecord);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



	public List<PayRecordVo> Maishenhe(int pageSize,int startPos) {
		Connection conn = DBConn.openDB();
		List<PayRecordVo> list=new ArrayList<PayRecordVo>();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select top "+pageSize+"  * from   PayRecord where  pay_record_id  not in (select  top "+startPos+" pay_record_id from PayRecord)";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				PayRecordVo payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
				list.add(payrecord);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}



	public PayRecordVo PayRecordFint2(String maiid) {
		Connection conn = DBConn.openDB();
		
		PayRecordVo payrecord=null;
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from PayRecord  where pay_record_id="+maiid;
			System.out.println("曾经课="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payrecord;
	}



	public TeacherVo teacherVo(int userid) {
		Connection conn = DBConn.openDB();
		TeacherVo teacher= new TeacherVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select t.*,d.Grade_Percent from teacher t inner join teacherGrade d on t.grade_id=d.grade_id where t.userid="+userid;

//			String sql = "select * from teacher where teacher_id="+teacherId;
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				teacher.setUserid(rs.getInt("userid"));
				teacher.setTeacherIntroduce(rs.getString("teacher_introduce").trim());
				teacher.setTeacherSpecial(rs.getString("teacher_special").trim());
				teacher.setTeacherLength(rs.getString("teacher_length"));
				teacher.setEducation(rs.getString("education").trim());
				teacher.setHeadpictureUrl(rs.getString("head_picture_url").trim());
				teacher.setBankId(rs.getInt("bank_id"));
				teacher.setAccountNo(rs.getString("accountNo").trim());
				teacher.setAccountName(rs.getString("accountName").trim());
				teacher.setGradeId(rs.getInt("grade_id"));
				teacher.setStatus(rs.getInt("status"));
				teacher.setReason(rs.getString("reason").trim());
				teacher.setGradepercent(rs.getFloat("Grade_Percent"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}


	//通过id查找用户
	public UsersVo finduserById3(int userid) {
		Connection conn = DBConn.openDB();
		UsersVo user= new UsersVo();
		try {
			Statement stmt = conn.createStatement();
			String sql = "select u.*,p.provincename,c.cityname from users u,province p,city c where userid="+userid+" and c.cityid=u.cityid and p.provinceid=u.provinceid";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				user.setUserid(rs.getInt("userid"));
				user.setMobile(rs.getString("mobile").trim());
				user.setPassword(rs.getString("password").trim());
				user.setUserName(rs.getString("user_name").trim());
				user.setSex(rs.getInt("sex"));
				user.setHomeAddress(rs.getString("home_address").trim());
				user.setEmail(rs.getString("email").trim());
				user.setRegisterDate(rs.getDate("register_date"));
				user.setProvinceId(rs.getInt("provinceId"));
				user.setCityId(rs.getInt("cityId"));
				user.setUserType(rs.getInt("user_type"));
				user.setRemainMoney(rs.getInt("remainMoney"));
				user.setProvinceName(rs.getString("provincename").trim());
				user.setCityName(rs.getString("cityname").trim());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}



	public void CashRecordMoneyAdd(CashRecordVo ahd) {
		Connection conn = DBConn.openDB();
		
		try {
			Statement stm=conn.createStatement();
			
			String sql="insert into CashRecord values("+ahd.getUserid()
			+","+ahd.getCourseid()+",getdate(),"+ahd.getPaymoney()+","+ahd.getIncommoney()+",1,'"+ahd.getReason()+"')";
			
			System.out.println("的非官方="+sql);
			
			stm.executeUpdate(sql);
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}



	public float chen(float yi, float er) {
		
		float jieguo=(1-yi)*er;
		
		return jieguo;
	}



	public CourseVo courseVo(String counid) {
		Connection conn = DBConn.openDB();
		CourseVo course=null;
		try {
			Statement stm=conn.createStatement();
			String sql="select * from Course where course_id="+counid;
			
			System.out.println("sdfg==="+sql);
			
			ResultSet rs=stm.executeQuery(sql);
			
			while(rs.next()){
				course=new CourseVo();
				course.setCourseid(rs.getInt("course_id"));
				course.setCoursename(rs.getString("course_name"));
				course.setPictureurl(rs.getString("picture_url"));
				course.setOneword(rs.getString("one_word"));
				course.setIntroduce(rs.getString("introduce"));
				course.setCoursecount(rs.getInt("course_count"));
				course.setPrice(rs.getFloat("price"));
				course.setDiscount(rs.getFloat("discount"));
				course.setEffective(rs.getInt("effective"));
				course.setReplaydate(rs.getDate("replay_date"));
				course.setUsername(rs.getString("user_name"));
				course.setSeq(rs.getInt("seq"));
				course.setChargetype(rs.getInt("charge_type"));
				course.setStatus(rs.getInt("status"));
				course.setReason(rs.getString("reason"));
				course.setUserid(rs.getInt("userid"));
				
				
			}
			
			rs.close();
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return course;
	}



	public void Pay(String status, String userid) {
		Connection conn = DBConn.openDB();
		
		try {
			Statement stm=conn.createStatement();
			
			String sql="update PayRecord set isCash="+status+" where courseid="+userid;
			
			System.out.println("sdfgsdfg="+sql);
			
			stm.executeUpdate(sql);
			stm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}



	public PayRecordVo payRecordVo(String id) {
		Connection conn = DBConn.openDB();
		
		PayRecordVo payrecord=null;
		
		try {
			Statement stmt = conn.createStatement();
			String sql = "select * from PayRecord  where pay_record_id="+id;
			System.out.println("曾经课="+sql);
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				payrecord= new PayRecordVo();
				payrecord.setPayrecordid(rs.getInt("pay_record_id"));
				payrecord.setUserid(rs.getInt("userid"));
				payrecord.setCourseid(rs.getInt("courseid"));
				payrecord.setPayorreturn(rs.getInt("pay_or_return"));
				payrecord.setPaydate(rs.getDate("pay_date"));
				payrecord.setPaymoney(rs.getInt("pay_money"));
				payrecord.setDiscountmoney(rs.getFloat("discount_money"));
				payrecord.setPaytype(rs.getInt("pay_type"));
				payrecord.setCardnum(rs.getString("card_num").trim());
				payrecord.setPayer(rs.getString("payer").trim());
				payrecord.setOrdernumber(rs.getString("order_number"));
				payrecord.setPaystatus(rs.getInt("pay_status"));
				payrecord.setIsCash(rs.getInt("isCash"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return payrecord;
	}
	
	public void teacherChongzhi(int userid,float yuer,float yuan) {
		Connection conn = DBConn.openDB();
		try {
			Statement stm=conn.createStatement();
			String sql="update moneyRecord set pay_money="+yuer+"+"+yuan+" where userid="+userid;
			System.out.println("老师="+sql);
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void forumDel(int forumid) {
		Connection conn = DBConn.openDB();
		try {
			Statement stmt = conn.createStatement();
			String sql = "delete forum where forum_id="+forumid;
			System.out.println(sql);
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public List<CashRecordVo> cList(int pageSize, int startPos) {
		Connection conn = DBConn.openDB();
		List<CashRecordVo> list=new ArrayList<CashRecordVo>();
		try {
			Statement stm=conn.createStatement();
			String sql="select top "+pageSize+" * from CashRecord where pay_record_id not in(select top "+startPos+" pay_record_id from CashRecord)";
			ResultSet tr=stm.executeQuery(sql);
			while(tr.next()){
				CashRecordVo dd=new CashRecordVo();
				dd.setPayrecordid(tr.getInt("pay_record_id"));
				dd.setUserid(tr.getInt("userid"));
				dd.setCourseid(tr.getInt("courseid"));
				dd.setCashdate(tr.getDate("cash_date"));
				dd.setPaymoney(tr.getFloat("pay_money"));
				dd.setIncommoney(tr.getFloat("Incom_money"));
				dd.setStatus(tr.getInt("status"));
				dd.setReason(tr.getString("reason"));
				list.add(dd);
			}
			stm.close();
			tr.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
	


