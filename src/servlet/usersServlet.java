package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.AesUtils;
import base.BaseDAOImpl;
import base.IBaseDAO;
import base.PageObject;
import bean.CityVo;
import bean.ManagerVo;
import bean.ProvinceVo;
import bean.UsersVo;

public class usersServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		if(action.equals("init")){
			String provinceId = request.getParameter("provinceId");
			//查询所有省份数据
			List<ProvinceVo> provList = base.provinceList();
			//有没有省份资料
			List<CityVo> cityList = null;
			if(provinceId!=null){//在新增页面改变了省份时有值
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			getServletContext().getRequestDispatcher("/jsp/userAdd.jsp").forward(request, response);
		}else if(action.equals("add")){
			UsersVo user = new UsersVo();
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId").trim()));
			user.setCityId(Integer.parseInt(request.getParameter("cityId").trim()));
			user.setMobile(request.getParameter("mobile").trim());
			String pwd = request.getParameter("password").trim();
			//对密码进行加密处理
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			user.setPassword(pwd);
			user.setUserName(request.getParameter("userName").trim());
			user.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setUserType(1);//学生
			user.setRemainMoney(0);//余额
			try{
				base.userAdd(user);
			}catch(Exception e){
				request.setAttribute("msg", "该手机号码已经注册过了，请输入其他手机号码");
				String provinceId = request.getParameter("provinceId");
				//查询所有省份数据
				List<ProvinceVo> provList = base.provinceList();
				//有没有省份资料
				List<CityVo> cityList = null;
				if(provinceId!=null){//在新增页面改变了省份时有值
					cityList = base.CityList(Integer.parseInt(provinceId));
				}else if(provList.size()>0){
					ProvinceVo p = provList.get(0);
					cityList = base.CityList(p.getProvinceId());
				}
				request.setAttribute("provList",provList);
				request.setAttribute("cityList",cityList);
				request.setAttribute("provinceId",provinceId);
				getServletContext().getRequestDispatcher("/web/userAdd.jsp").forward(request, response);
			}
			user.setRegisterDate(new Date());
			//保存用户信息
			session.setAttribute("user", user);
			setCookie(request,response,user.getMobile(),user.getPassword());
			request.getRequestDispatcher("/web/webCenter.jsp").forward(request, response);
		}else if(action.equals("list")){
			listPage(request,response);
			request.getRequestDispatcher("/jsp/userList.jsp").forward(request, response);
		}else if(action.equals("updateinit")){
			String users=request.getParameter("users");
			String provinceId = request.getParameter("provinceId");
			String cityId = request.getParameter("cityId");
			String tel = request.getParameter("mobile");
			String name = request.getParameter("username");
			String home = request.getParameter("homeAddress");
			String em = request.getParameter("email");
			String sex = request.getParameter("sex");
			String money = request.getParameter("money");
			//查询所有省份数据
			List<ProvinceVo> provList = base.provinceList();
			//有没有省份资料
			List<CityVo> cityList = null;
			if(provinceId!=null){//在新增页面改变了省份时有值
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("users", users);
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			request.setAttribute("cityId",cityId);
			request.setAttribute("tel",tel);
			request.setAttribute("name",name);
			request.setAttribute("home",home);
			request.setAttribute("em",em);
			request.setAttribute("sex",sex);
			request.setAttribute("money",money);
			request.getRequestDispatcher("/jsp/userUpdate.jsp").forward(request,response);
		}else if(action.equals("updaterr")){
			
			String provinceId = request.getParameter("provinceId");
			//查询所有省份数据
			List<ProvinceVo> provList = base.provinceList();
			//有没有省份资料
			List<CityVo> cityList = null;
			if(provinceId!=null){//在新增页面改变了省份时有值
				cityList = base.CityList(Integer.parseInt(provinceId));
			}else if(provList.size()>0){
				ProvinceVo p = provList.get(0);
				cityList = base.CityList(p.getProvinceId());
			}
			request.setAttribute("provList",provList);
			request.setAttribute("cityList",cityList);
			request.setAttribute("provinceId",provinceId);
			getServletContext().getRequestDispatcher("/jsp/userUpdate2.jsp").forward(request, response);
			
		}else if(action.equals("updaSaveser")){
			UsersVo user = new UsersVo();
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId").trim()));
			user.setCityId(Integer.parseInt(request.getParameter("cityId").trim()));
			user.setMobile(request.getParameter("mobile").trim());
			String pwd = request.getParameter("password").trim();
			//对密码进行加密处理
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			user.setPassword(pwd);
			user.setUserName(request.getParameter("userName").trim());
			user.setSex(Integer.parseInt(request.getParameter("sex").trim()));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setUserType(1);//学生
			user.setRemainMoney(0);//余额
			try{
				base.userAdd(user);
			}catch(Exception e){
				request.setAttribute("msg", "该手机号码已经注册过了，请输入其他手机号码");
				String provinceId = request.getParameter("provinceId");
				//查询所有省份数据
				List<ProvinceVo> provList = base.provinceList();
				//有没有省份资料
				List<CityVo> cityList = null;
				if(provinceId!=null){//在新增页面改变了省份时有值
					cityList = base.CityList(Integer.parseInt(provinceId));
				}else if(provList.size()>0){
					ProvinceVo p = provList.get(0);
					cityList = base.CityList(p.getProvinceId());
				}
				request.setAttribute("provList",provList);
				request.setAttribute("cityList",cityList);
				request.setAttribute("provinceId",provinceId);
				getServletContext().getRequestDispatcher("/jsp/userAdd.jsp").forward(request, response);
			}
			listPage(request,response);
			request.getRequestDispatcher("/jsp/userList.jsp").forward(request, response);
		}else if (action.equals("update")) {
			String userid = request.getParameter("userid");
			List<ProvinceVo> provincelist = base.provinceList();
			request.setAttribute("provincelist",provincelist );
			List<CityVo> citylist = base.cityList();
			request.setAttribute("citylist", citylist);
			UsersVo user = base.finduserById(userid);
 			request.setAttribute("user",user);
			request.getRequestDispatcher("jsp/userUpdate.jsp").forward(request,response);
		}else if(action.equals("updateSave")){
			UsersVo user = new UsersVo();
			user.setUserid(Integer.parseInt(request.getParameter("userid")));
			user.setMobile(request.getParameter("mobile").trim());
			user.setUserName(request.getParameter("userName"));
			user.setSex(Integer.parseInt(request.getParameter("sex")));
			user.setHomeAddress(request.getParameter("homeAddress").trim());
			user.setEmail(request.getParameter("email").trim());
			user.setProvinceId(Integer.parseInt(request.getParameter("provinceId")));
			user.setCityId(Integer.parseInt(request.getParameter("cityId")));
			base.userUpdate(user);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/userList.jsp").forward(request,response);
		}else if(action.equals("del")){
			String userid = request.getParameter("userid");
			base.userDel(Integer.parseInt(userid));
			listPage(request, response);
			request.getRequestDispatcher("/jsp/userList.jsp").forward(request,response);
		}else if(action.equals("modifyPwd1")){
			String userid = request.getParameter("userid");
			String oldpwd = AesUtils.encryptStr(request.getParameter("oldpwd"),AesUtils.SECRETKEY);
			String newPassword = AesUtils.encryptStr(request.getParameter("newPassword"),AesUtils.SECRETKEY);
			if(base.checkPwd(userid, oldpwd)){
				//修改密码
				base.modifyPwd1(userid, newPassword);
				//从modifyPwd.jsp页面取值
				request.setAttribute("msg", "恭喜你，密码修改成功，请妥善保管");
			}else{
				request.setAttribute("msg", "旧密码输入错误，请重新输入");
			}
			//转向
			request.getRequestDispatcher("/jsp/modifyPwd1.jsp").forward(request, response);
		}else if(action.equals("initpwd")){
			//初始化密码
			String userid = request.getParameter("userid");
			base.modifyPwd1(userid, AesUtils.encryptStr("8888",AesUtils.SECRETKEY));
			listPage(request, response);
			request.setAttribute("msg","初始化密码成功，初始密码为：8888");
			request.getRequestDispatcher("/jsp/userList.jsp").forward(request, response);
		}else if(action.equals("login1")){
			String username=request.getParameter("username").trim();
			String pwd = request.getParameter("password").trim();
			//对密码进行加密处理
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			//验证码
			String code = request.getParameter("code").trim();
			String rand = session.getAttribute("rand").toString();
			//判断验证码是否一致
			if(!code.toUpperCase().equals(rand.toUpperCase())){
				request.setAttribute("msg", "验证码错误，请重新输入");
				request.getRequestDispatcher("/Login2.jsp").forward(request, response);
			}else{
				UsersVo user = base.login1(username, pwd);
				if(user==null){
					request.setAttribute("msg", "用户名,密码或者账号被禁用，请确认");
					request.getRequestDispatcher("/Login2.jsp").forward(request, response);
				}else{
					//保存登录信息
					session.setAttribute("user", user);
					request.getRequestDispatcher("/htCenter1.jsp").forward(request, response);
				}
			}
		}else if(action.equals("autologin")){
			String mobile = request.getParameter("mobile").trim();
			String pwd = request.getParameter("password").trim();
			UsersVo user = base.login2(mobile, pwd);
			if(user==null){
				request.setAttribute("msg", "用户名或密码错误，登录失败！");
				request.getRequestDispatcher("/web/login.jsp").forward(request, response);
			}else{
				setCookie(request,response,user.getMobile(),pwd);
				session.setAttribute("user", user);
				request.getRequestDispatcher("/web/webCenter.jsp").forward(request, response);
			}
		}else if(action.equals("exit")){
			session.invalidate();
			Cookie cookie1 = new Cookie("mobile",URLEncoder.encode(""));
	    	Cookie cookie2 = new Cookie("password",URLEncoder.encode(""));
	    	//设置一天的有效期,单位是秒
			cookie1.setMaxAge(0);
			//设置一天的有效期
			cookie2.setMaxAge(0);
	    	//设置保存路径
	    	cookie1.setPath(request.getContextPath());
	    	cookie2.setPath(request.getContextPath());
	    	response.addCookie(cookie1);
	    	response.addCookie(cookie2);
	    	response.sendRedirect("web/index.jsp");
		}else if(action.equals("login2")){
			String mobile = request.getParameter("mobile").trim();
			String pwd = request.getParameter("password").trim();
			//对密码进行加密处理
			pwd=AesUtils.encryptStr(pwd, AesUtils.SECRETKEY);
			UsersVo user = base.login2(mobile, pwd);
			if(user==null){
				request.setAttribute("msg", "用户名或密码错误，登录失败！");
				request.getRequestDispatcher("/web/login.jsp").forward(request, response);
			}else{
				setCookie(request,response,user.getMobile(),pwd);
				session.setAttribute("user", user);
				request.getRequestDispatcher("/web/webCenter.jsp").forward(request, response);
			}
		}
	}
	//查询所有的用户数据
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中的用户数据
		List<UsersVo > userList = base.userList();
		//定义request变量，保存的是所有的用户数据
		request.setAttribute("userList", userList);
	}
	
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from users");
		PageObject pager = new PageObject();
		//设置第一个参数
		pager.setRecordCount(cnt);
		//设置第二个参数
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//设置第三个参数
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//获取当前页
		int currPage = pager.getCurrentPage();
		//获取数据库中所有的用户数据
		List<UsersVo> userList = base.finduserByPage(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的用户数据
		request.setAttribute("userList", userList);
		request.setAttribute("pager", pager);
		
	}
	private void setCookie(HttpServletRequest request, HttpServletResponse response, String mobile,String password){
		Cookie cookie1 = new Cookie("mobile",URLEncoder.encode(mobile));
    	Cookie cookie2 = new Cookie("password",URLEncoder.encode(password));
    	//设置一天的有效期,单位是秒
		cookie1.setMaxAge(24*60*60*30);
		//设置一天的有效期
		cookie2.setMaxAge(24*60*60*30);
    	//设置保存路径
    	cookie1.setPath(request.getContextPath());
    	cookie2.setPath(request.getContextPath());
    	response.addCookie(cookie1);
    	response.addCookie(cookie2);
	}

}
