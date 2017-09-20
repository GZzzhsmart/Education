package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.CouponCode;
import bean.CourseVo;
import base.PageObject1;
import bean.PayRecordVo;
import bean.SectionVo;
import bean.TeacherVo;
import bean.UserCourseEvalVo;
import bean.UsersVo;

public class Course extends HttpServlet {
	
	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UsersVo user =(UsersVo)session.getAttribute("user");
		if(action.equals("list")){
			listPage(request,response,user.getUserid());
        	getServletContext().getRequestDispatcher("/web/courseList.jsp").forward(request, response);
		}else if(action.equals("buylist")){
			listPage3(request,response,3);
        	getServletContext().getRequestDispatcher("/jsp/courseBuyList.jsp").forward(request, response);
		}else if(action.equals("buylist1")){
			listPage3(request,response,1);
        	getServletContext().getRequestDispatcher("/jsp/courseBuyList.jsp").forward(request, response);
		}else if(action.equals("buylist2")){
			listPage3(request,response,2);
        	getServletContext().getRequestDispatcher("/jsp/courseBuyList.jsp").forward(request, response);
		}else if(action.equals("buyDetail")){
			String courseid = request.getParameter("courseid");
			CourseVo course = base.findcourseById(courseid);
			List<SectionVo> sectionList = base.findsectionById(course.getCourseid(), 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList(courseid);
			CouponCode coupon = base.couponCodeList(courseid);
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	request.getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("buyDetail2")){
			CourseVo course = base.findcourseById("2");
			List<SectionVo> sectionList = base.findsectionById(2, 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList("2");
			CouponCode coupon = base.couponCodeList("2");
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	request.getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("buyDetail3")){
			CourseVo course = base.findcourseById("5");
			List<SectionVo> sectionList = base.findsectionById(2, 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList("5");
			CouponCode coupon = base.couponCodeList("5");
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("buyDetail4")){
			CourseVo course = base.findcourseById("6");
			List<SectionVo> sectionList = base.findsectionById(2, 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList("6");
			CouponCode coupon = base.couponCodeList("6");
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("buyDetail5")){
			CourseVo course = base.findcourseById("7");
			List<SectionVo> sectionList = base.findsectionById(2, 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList("7");
			CouponCode coupon = base.couponCodeList("7");
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("buyDetail6")){
			CourseVo course = base.findcourseById("4");
			List<SectionVo> sectionList = base.findsectionById(2, 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList("4");
			CouponCode coupon = base.couponCodeList("4");
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("buyDetail7")){
			CourseVo course = base.findcourseById("1");
			List<SectionVo> sectionList = base.findsectionById(2, 100, 0);
			List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList("1");
			CouponCode coupon = base.couponCodeList("1");
			request.setAttribute("course",course);
			request.setAttribute("sectionList",sectionList);
			request.setAttribute("usercourseList",usercourseList);
			request.setAttribute("coupon",coupon);
        	getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
		}else if(action.equals("sousuo2")){
			String name=request.getParameter("sw");
			String userid = request.getParameter("userid");
			List<CourseVo> course=base.courseList(name);
			request.setAttribute("courseList",course);
			request.setAttribute("userid",userid);
			request.getRequestDispatcher("/jsp/KechengSuosuo.jsp").forward(request, response);
		}else if(action.equals("linqu")){
			String crd=request.getParameter("crd");
			String cpid=request.getParameter("cpid");
			String useDate = request.getParameter("useDate");
			String courseId = request.getParameter("courseid");
			CouponCode cou=base.couponFint(cpid);
			CouponCode cou1=base.couponFint1(user.getUserid());
			if(cou1==null){
				base.CouponCodeLin(user.getUserid(), cpid);
				base.CouponCodeLin1(useDate,cpid);
				CourseVo course = base.findcourseById(courseId);
				List<SectionVo> sectionList = base.findsectionById(course.getCourseid(), 100, 0);
				List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList(courseId);
				CouponCode coupon = base.couponCodeList(courseId);
				request.setAttribute("course",course);
				request.setAttribute("sectionList",sectionList);
				request.setAttribute("usercourseList",usercourseList);
				request.setAttribute("coupon",coupon);
				getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "优惠券每个人只能领取一次，您已经领取过了！");
				CourseVo course = base.findcourseById(courseId);
				List<SectionVo> sectionList = base.findsectionById(course.getCourseid(), 100, 0);
				List<UserCourseEvalVo> usercourseList = base.UserCourseEvalList(courseId);
				CouponCode coupon = base.couponCodeList(courseId);
				request.setAttribute("course",course);
				request.setAttribute("sectionList",sectionList);
				request.setAttribute("usercourseList",usercourseList);
				request.setAttribute("coupon",coupon);
				getServletContext().getRequestDispatcher("/jsp/buyCourse.jsp").forward(request, response);
			}
		}else if(action.equals("chayhj")){
			System.out.println("dfghdhdhgfgfhdgh");
			List<CouponCode> couponCodeList=base.couponFint(user.getUserid());
			request.setAttribute("couponCodeList",couponCodeList);
			request.getRequestDispatcher("/jsp/couponChaxun.jsp").forward(request, response);
		}else if(action.equals("goumai")){
			String courseid=request.getParameter("courseid");
			String couponCodeId = request.getParameter("couponCodeId");
			CouponCode coupon=base.couponFint1(user.getUserid());
			CourseVo course=base.findcourseById(courseid);
			request.setAttribute("coupon", coupon);
			request.setAttribute("course", course);
			getServletContext().getRequestDispatcher("/jsp/GoumaiList.jsp").forward(request, response);
		}else if(action.equals("mai")){
			String you=request.getParameter("you");
			String courseid=request.getParameter("courseid");
			PayRecordVo ut=base.PayRecordFint(user.getUserid());
			if(ut.getCourseid()==Integer.parseInt(courseid)){
				CouponCode coupon=base.couponFint1(user.getUserid());
				CourseVo course=base.findcourseById(courseid);
				request.setAttribute("msg", "您曾经购买过这个课程！");
				request.setAttribute("coupon", coupon);
				request.setAttribute("course", course);
				getServletContext().getRequestDispatcher("/jsp/GoumaiList.jsp").forward(request, response);
				return;
			}
			if(you==null || you.equals("")){
				you="0";
			}
			String money=request.getParameter("money");
			System.out.println("0000="+money);
			String userid = request.getParameter("userid");
			float mey=Float.parseFloat(money)-Float.parseFloat(you);
			System.out.println(user.getRemainMoney());
			UsersVo use=base.finduserById(user.getUserid());
			float yu=use.getRemainMoney()-mey;
			if(yu<0){
				CouponCode coupon=base.couponFint1(user.getUserid());
				CourseVo course=base.findcourseById(courseid);
				request.setAttribute("msg", "不好意思，您余额不足请充值！");
				request.setAttribute("coupon", coupon);
				request.setAttribute("course", course);
				getServletContext().getRequestDispatcher("/jsp/GoumaiList.jsp").forward(request, response);
			}else{
				UsersVo hh=base.finduserById(userid);
				System.out.println("sdfgsfd="+hh.getRemainMoney());
				base.teacherMOney(userid,mey,hh.getRemainMoney());
				base.CouponCodeDel(user.getUserid());
				base.userMoney(yu, user.getUserid());
				base.moneyRecordMoney(yu, user.getUserid());
				PayRecordVo mo=new PayRecordVo();
				mo.setUserid(user.getUserid());
				mo.setCourseid(Integer.parseInt(courseid));
				mo.setPaymoney(mey);
				mo.setDiscountmoney(Float.parseFloat(you));
				mo.setPayer(user.getUserName());
				CouponCode coupon=base.couponFint1(user.getUserid());
				CourseVo course=base.findcourseById(courseid);
				request.setAttribute("coupon", coupon);
				request.setAttribute("course", course);
				base.PayRecordAdd(mo);
				request.setAttribute("msg", "恭喜您，支付成功！");
				getServletContext().getRequestDispatcher("/jsp/GoumaiList.jsp").forward(request, response);
			}
		}else if(action.equals("pinjiachu")){
			String courseid=request.getParameter("courseid");
			CourseVo ff=base.findcourseById(courseid);
			request.setAttribute("coursename", ff.getCoursename());
			request.setAttribute("courseid", courseid);
			request.setAttribute("userid", user.getUserid());
			request.setAttribute("yonname", user.getUserName());
			getServletContext().getRequestDispatcher("/jsp/pinjiasList.jsp").forward(request, response);
		}else if(action.equals("pinadd")){
			String userid=request.getParameter("userid");
			UserCourseEvalVo dd=base.userCourseEvalFint(userid);
			if(dd!=null){
				request.setAttribute("msg", "您已经评价过了，不能再评价了！");
				getServletContext().getRequestDispatcher("/payrecordServlet?action=list1").forward(request, response);
			}else{
				String courseid=request.getParameter("courseid");
				String username=request.getParameter("username");
				String evallevel=request.getParameter("evallevel");
				String evalcontent=request.getParameter("evalcontent");
				UserCourseEvalVo ff=new UserCourseEvalVo();
				ff.setUserid(Integer.parseInt(userid));
				ff.setCourseid(Integer.parseInt(courseid));
				ff.setEvallevel(Integer.parseInt(evallevel));
				ff.setEvalcontent(evalcontent);
				ff.setUserName(username);
				base.usercourseAdd(ff);
				getServletContext().getRequestDispatcher("/payrecordServlet?action=list1").forward(request, response);
			}
		}
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response,int userid)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from Course");
		PageObject1 pager = new PageObject1();
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
		//获取数据库中所有的课程数据
		List<CourseVo> courseList = base.findcourseById(userid,pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所有的课程数据
		request.setAttribute("courseList", courseList);
		request.setAttribute("pager", pager);
	}
	
	//分页显示
	public void listPage3(HttpServletRequest request, HttpServletResponse response,int teacherId)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from course");
		PageObject1 pager = new PageObject1();
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
		//获取数据库中所有的管理员数据
		List<CourseVo> courseList = base.courseList2(teacherId,pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的管理员数据
		request.setAttribute("courseList", courseList);
		request.setAttribute("pager", pager);
		
	}
	
}
