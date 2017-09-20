package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import base.BaseDAOImpl;
import base.IBaseDAO;
import base.PageObject1;
import bean.MoneyRecordVo;
import bean.UsersVo;

public class moneyRecordServlet extends HttpServlet {

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
			String userid=request.getParameter("userid");
			MoneyRecordVo money=base.findmoneyById(userid);
			request.setAttribute("money", money);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/moneyList.jsp").forward(request,response);
		}else if(action.equals("list1")){
			String userid=request.getParameter("userid");
			MoneyRecordVo money=base.findmoneyById(userid);
			System.out.println(money.getRecordid());
			if(money.getRecordid()==0){
				base.moneyAdd2(userid);
				request.setAttribute("money", money);
				listPage(request, response);
				request.getRequestDispatcher("/jsp/moneyList.jsp").forward(request,response);
			}
			request.setAttribute("money", money);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/moneyList.jsp").forward(request,response);
		}else if(action.equals("list2")){
			String userid=request.getParameter("userid");
			MoneyRecordVo money=base.findmoneyById(userid);
			request.setAttribute("money", money);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/moneyrecordList.jsp").forward(request,response);
		}else if(action.equals("add")){
			request.getRequestDispatcher("/jsp/moneyrecordAdd.jsp").forward(request,response);
		}else if(action.equals("del")){
			String recordid=request.getParameter("recordid");
			base.moneyRecordDel(Integer.parseInt(recordid));
			listPage(request, response);
			request.getRequestDispatcher("/jsp/moneyrecordList.jsp").forward(request,response);
		}else if(action.equals("chongzhi")){
			String moey=request.getParameter("moey");
			String chonid=request.getParameter("chonid");
			String xmoney=request.getParameter("xmoney");
			String userid=request.getParameter("userid");
			System.out.println("sergfsdg="+userid);
			base.moneyUser(userid,Float.parseFloat(moey), Float.parseFloat(xmoney));
			base.moneyAdd(Float.parseFloat(moey), Float.parseFloat(xmoney), chonid);
			MoneyRecordVo money=base.findmoneyById(userid);
			request.setAttribute("money", money);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/moneyList.jsp").forward(request,response);
		}
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from moneyRecord");
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
		//获取数据库中所有的充值记录
		List<MoneyRecordVo> moneyList = base.findmoneyById(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的充值记录
		request.setAttribute("moneyList", moneyList);
		request.setAttribute("pager", pager);
	}

}
