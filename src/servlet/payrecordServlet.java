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
import base.PageObject;
import bean.CashRecordVo;
import bean.CourseVo;
import bean.PayRecordVo;
import bean.TeacherVo;
import bean.UsersVo;

public class payrecordServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("list")){
			listPage1(request,response);
	    	request.getRequestDispatcher("/jsp/payrecordList.jsp").forward(request, response);
		}else if(action.equals("del")){
			String payrecordid = request.getParameter("payrecordid");
			base.payrecordDel(Integer.parseInt(payrecordid));
			listPage(request, response);
			request.getRequestDispatcher("/jsp/payrecordList.jsp").forward(request, response);
		}else if(action.equals("list1")){
			listPage2(request, response);
			request.getRequestDispatcher("/jsp/payrecordList1.jsp").forward(request, response);
		}else if(action.equals("jilu")){
			List<PayRecordVo> jilu=base.MaikeJilv();
			request.setAttribute("jilu", jilu);
			getServletContext().getRequestDispatcher("/jsp/MaikejiluList.jsp").forward(request, response);
		}else if(action.equals("houtaishenhe")){
			listPage2(request, response);
			getServletContext().getRequestDispatcher("/jsp/TixianShenheList.jsp").forward(request, response);
		}else if(action.equals("shenhe")){
			String maiid=request.getParameter("maiid");
			PayRecordVo pay=base.PayRecordFint2(maiid);
			request.setAttribute("course", pay);
			getServletContext().getRequestDispatcher("/jsp/MaikeShenhe.jsp").forward(request, response);
		}else if(action.equals("tixian")){
			String fumoney=request.getParameter("fumoney");
			String youmoney=request.getParameter("youmoney");
			String userid=request.getParameter("userid");
			String courseid=request.getParameter("courseid");
			String status=request.getParameter("status");
			String reason=request.getParameter("reason");
			if(reason==null || reason.equals("")){
				reason="0";
			}
			if(youmoney==null || youmoney.equals("")){
				youmoney="0";
			}
			CourseVo ff=base.courseVo(courseid);
			UsersVo hh=base.finduserById3(ff.getUserid());
			float yu=Float.parseFloat(fumoney)-Float.parseFloat(youmoney);
			TeacherVo tichen=base.teacherVo(ff.getUserid());
			System.out.println("ˮ���GV="+tichen.getGradepercent());
			float sheng=yu*tichen.getGradepercent();
			float pintai=yu-sheng;
			base.Pay(status, courseid);
			base.teacherMOney(ff.getUserid(),sheng,hh.getRemainMoney());
			base.teacherChongzhi(ff.getUserid(), sheng, hh.getRemainMoney());
			CashRecordVo gg=new CashRecordVo();
			gg.setUserid(Integer.parseInt(userid));
			gg.setCourseid(Integer.parseInt(courseid));
			gg.setPaymoney(yu);
			gg.setIncommoney(pintai);
			gg.setStatus(Integer.parseInt(status));
			gg.setReason(reason);
			base.CashRecordMoneyAdd(gg);
			listPage2(request, response);
			getServletContext().getRequestDispatcher("/jsp/TixianShenheList.jsp").forward(request, response);
		}else if(action.equals("shenqin")){
			String payid=request.getParameter("payid");
			PayRecordVo gg=base.payRecordVo(payid);
			if(gg.getIsCash()==0){
				response.sendRedirect("jsp/Shenghe.jsp");
			}else{
				response.sendRedirect("jsp/ShenheChengong.jsp");
			}
		}

	}
	
	//��ҳ��ʾ
	public void listPage1(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from PayRecord");
		PageObject pager = new PageObject();
		//���õ�һ�����
		pager.setRecordCount(cnt);
		//���õڶ������
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//���õ�������
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//��ȡ��ǰҳ
		int currPage = pager.getCurrentPage();
		//��ȡ��ݿ������еĿγ����
		List<PayRecordVo> payrecordList = base.findpayrecord(pager.getPageSize(),pager.getStartPos());
		//����request��������������еĿγ����
		request.setAttribute("payrecordList", payrecordList);
		request.setAttribute("pager", pager);
	}

	
	//��ҳ
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UsersVo user =(UsersVo)session.getAttribute("user");
		
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from PayRecord");
		PageObject pager = new PageObject();
		//���õ�һ�����
		pager.setRecordCount(cnt);
		//���õڶ������
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//���õ�������
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//��ȡ��ǰҳ
		int currPage = pager.getCurrentPage();
		//��ȡ��ݿ������еĳ������
		List<PayRecordVo> payrecordList = base.PayRecordList(user.getUserid(),pager.getPageSize(),pager.getStartPos());
		//����request��������������еĳ������
		request.setAttribute("payrecordList", payrecordList);
		request.setAttribute("pager", pager);
	}
	
	//��ҳ
	public void listPage2(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UsersVo user =(UsersVo)session.getAttribute("user");
		
		//��ȡҳ��Ĳ���
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//��ȡ�ܼ�¼��
		int cnt = base.getCount("select count(*) cnt from PayRecord");
		PageObject pager = new PageObject();
		//���õ�һ�����
		pager.setRecordCount(cnt);
		//���õڶ������
		if(currentPage==null || currentPage.equals("")){
			pager.setCurrentPage(1);
		}else{
			pager.setCurrentPage(Integer.parseInt(currentPage));
		}
		//���õ�������
		if(opr==null || opr.equals("")){
			pager.setOpr("first");
		}else{
			pager.setOpr(opr);
		}
		//��ȡ��ǰҳ
		int currPage = pager.getCurrentPage();
		//��ȡ��ݿ������еĳ������
		List<PayRecordVo> payrecordList = base.Maishenhe(pager.getPageSize(), pager.getStartPos());
		//����request��������������еĳ������
		request.setAttribute("payrecordList", payrecordList);
		request.setAttribute("pager", pager);
	}
	
}
