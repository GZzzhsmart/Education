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
import bean.CouponRecord;
import base.PageObject;
import bean.TeacherGradeVo;
import bean.TeacherVo;
import bean.UsersVo;

public class couponRecordServlet extends HttpServlet {

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
		if(action.equals("add")){
			String activityName = request.getParameter("activityName").trim();
			String activityDesc = request.getParameter("activityDesc").trim();
			CouponRecord coupon = new CouponRecord();
			coupon.setActivityDesc(activityDesc);
			coupon.setActivityName(activityName);
			coupon.setUserid(user.getUserid());
			base.couponRecordAdd(coupon);
			listPage(request,response,user.getUserid());
			request.getRequestDispatcher("/jsp/couponRecordList.jsp").forward(request, response);
		}else if(action.equals("list")){
			listPage(request,response,user.getUserid());
			request.getRequestDispatcher("/jsp/couponRecordList.jsp").forward(request, response);
		}else if(action.equals("list1")){
			listPage1(request,response);
			request.getRequestDispatcher("/jsp/couponCodeAdd.jsp").forward(request, response);
		}else if(action.equals("list2")){
			listPage1(request,response);
			request.getRequestDispatcher("/jsp/couponCodeList.jsp").forward(request, response);
		}else if(action.equals("produce")){
			int couponRecordId = Integer.parseInt(request.getParameter("couponRecordId"));
			if(request.getParameter("couponMoney")!=null){
				int couponMoney = Integer.parseInt(request.getParameter("couponMoney").trim());
				int validDay = Integer.parseInt(request.getParameter("validDay").trim());
				int couponCnt = Integer.parseInt(request.getParameter("couponCnt").trim());
				base.couponCodeAdd(couponRecordId, couponMoney, validDay, couponCnt);
			}
			List<CouponCode> couponCodeList = base.couponCodeList(couponRecordId);
			request.setAttribute("couponRecordId",couponRecordId);
			request.setAttribute("couponCodeList",couponCodeList);
			request.getRequestDispatcher("/jsp/couponCodeAdd.jsp").forward(request, response);
		}else if(action.equals("produce1")){
			int couponCodeId = Integer.parseInt(request.getParameter("couponCodeId"));
			if(request.getParameter("couponMoney")!=null){
				int couponMoney = Integer.parseInt(request.getParameter("couponMoney").trim());
				int validDay = Integer.parseInt(request.getParameter("validDay").trim());
				int couponCnt = Integer.parseInt(request.getParameter("couponCnt").trim());
				base.couponCodeAdd(couponCodeId, couponMoney, validDay, couponCnt);
			}
			List<CouponCode> couponCodeList = base.couponCodeList(couponCodeId);
			request.setAttribute("couponCodeId",couponCodeId);
			request.setAttribute("couponCodeList",couponCodeList);
			listPage1(request, response);
			request.getRequestDispatcher("/jsp/couponCodeList.jsp").forward(request, response);
		}else if(action.equals("del")){
			String couponRecordId = request.getParameter("couponRecordId");
			base.couponRecordDel(Integer.parseInt(couponRecordId));
			listPage(request, response, user.getUserid());
			request.getRequestDispatcher("/jsp/couponRecordList.jsp").forward(request,response);
		}else if(action.equals("update")){
			String couponRecordId = request.getParameter("couponRecordId");
			CouponRecord coupon = base.findCouponRecord(couponRecordId);
			request.setAttribute("coupon",coupon);
			request.getRequestDispatcher("/jsp/couponRecordUpdate.jsp").forward(request,response);
		}else if(action.equals("updateSave")){
			String couponRecordId = request.getParameter("couponRecordId");
			String activityName = request.getParameter("activityName");
			String activityDesc = request.getParameter("activityDesc");
			String createDate = request.getParameter("createDate");
			CouponRecord coupon = new CouponRecord();
			coupon.setCouponRecordId(Integer.parseInt(couponRecordId));
			coupon.setActivityName(activityName);
			coupon.setActivityDesc(activityDesc);
			coupon.setCreateDate(createDate);
			base.couponRecordUpdate(coupon);
			listPage(request, response, user.getUserid());
			request.getRequestDispatcher("/jsp/couponRecordList.jsp").forward(request,response);
		}
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response,int teacherId)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from CouponRecord");
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
		//获取数据库中所有的管理员数据
		List<CouponRecord> couponList = base.couponRecordList(teacherId,pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的管理员数据
		request.setAttribute("couponList", couponList);
		request.setAttribute("pager", pager);
		
	}
	//分页显示
	public void listPage1(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from CouponCode");
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
		//获取数据库中所有的管理员数据
		List<CouponCode> couponCodeList = base.couponCodeList(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的管理员数据
		request.setAttribute("couponCodeList", couponCodeList);
		request.setAttribute("pager", pager);
		
	}
}
