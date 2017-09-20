package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import upload.FileRenameUtil;

import base.BaseDAOImpl;
import base.IBaseDAO;
import base.PageObject;
import bean.CourseVo;
import bean.SectionVo;
import bean.TeacherVo;
import bean.UsersVo;

public class sectionServlet extends HttpServlet {
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
			String courseid=request.getParameter("courseid");
			request.setAttribute("courseid", courseid);
			listPage(request,response,Integer.parseInt(courseid));
        	request.getRequestDispatcher("/jsp/sectionList.jsp").forward(request, response);
		}else if(action.equals("list1")){
			String sectionid=request.getParameter("sectionid");
			request.setAttribute("sectionid", sectionid);
			listPage(request,response);
        	request.getRequestDispatcher("/jsp/sectionList1.jsp").forward(request, response);
		}else if(action.equals("list2")){
			String courseid=request.getParameter("courseid");
			String sectionid=request.getParameter("sectionid");
			request.setAttribute("sectionid", sectionid);
			request.setAttribute("courseid", courseid);
			listPage(request,response,Integer.parseInt(courseid));
        	request.getRequestDispatcher("/jsp/sectionList3.jsp").forward(request, response);
		}else if(action.equals("add")){
			// 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/section");  
	        // 文件最大容量 600M  
	        int fileMaxSize = 600 * 1024 * 1024;  
	        // 存放文件描述  
	        @SuppressWarnings("unused")  
	        String[] fileDiscription = { null, null };  
	        // 文件名  
	        String fileName = null;  
	        // 上传文件数  
	        int fileCount = 0;  
	        // 重命名策略  
	        FileRenameUtil rfrp = new FileRenameUtil();  
	        // 上传文件  
	        MultipartRequest mulit =null;
	        try{
	        	mulit = new MultipartRequest(request, filePath,fileMaxSize, "UTF-8", rfrp);//取得上传文件  
	        }catch(Exception e){
	        	request.setAttribute("msg", "上传文件的大小不能超过600M");
	        	getServletContext().getRequestDispatcher("/jsp/sectionAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
//	        String sectionid = request.getParameter("sectionid");
			String courseid=mulit.getParameter("courseid");
	        String sectionname = mulit.getParameter("sectionname");  
	        String sectioncontent = mulit.getParameter("sectioncontent");  
	        String free = mulit.getParameter("free");  
	        String seq = mulit.getParameter("seq");  
	        String sectionurl = "attached/section/"; 
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        String val = null;
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	        	String name = (String) filesname.nextElement();//标识  
	        	val =  mulit.getFilesystemName(name); //取得文件名  
	        	sectionurl +=val;
	        }  
			SectionVo section = new SectionVo();
//			section.setSectionid(Integer.parseInt(sectionid));
			section.setCourseid(Integer.parseInt(courseid));
			section.setSectionname(sectionname);
			section.setSectioncontent(sectioncontent);
			section.setFree(Integer.parseInt(free));
			section.setSectionurl(sectionurl);
			section.setSeq(Integer.parseInt(seq));
			if(val!=null && !val.equals("")){
				section.setSectionurl(sectionurl);
			}
			section.setRemark(""); 
			section.setReason("");
			section.setStatus(0);
			base.sectionAdd(section);//新增
			request.setAttribute("courseid", courseid);
			listPage(request,response,Integer.parseInt(courseid));
        	getServletContext().getRequestDispatcher("/jsp/sectionList.jsp").forward(request, response);
		}else if(action.equals("update")){
			String sectionid = request.getParameter("sectionid");
			SectionVo section = base.findsectionById(sectionid);
			request.setAttribute("section", section);
			listPage(request,response);
			request.getRequestDispatcher("/jsp/sectionUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			  // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/section");  
	        // 文件最大容量 600M  
	        int fileMaxSize = 600 * 1024 * 1024;  
	        // 存放文件描述  
	        @SuppressWarnings("unused")  
	        String[] fileDiscription = { null, null };  
	        // 文件名  
	        String fileName = null;  
	        // 上传文件数  
	        int fileCount = 0;  
	        // 重命名策略  
	        FileRenameUtil rfrp = new FileRenameUtil();  
	        // 上传文件  
	        MultipartRequest mulit =null;
	        try{
	        	mulit = new MultipartRequest(request, filePath,fileMaxSize, "UTF-8", rfrp);//取得上传文件  
	        }catch(Exception e){
	        	request.setAttribute("msg", "上传文件的大小不能超过600M");
	        	getServletContext().getRequestDispatcher("/xjsp/sectionAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        String sectionid = mulit.getParameter("sectionid");
	        String courseid=mulit.getParameter("courseid");
	        String sectionname = mulit.getParameter("sectionname"); 
	        String sectioncontent = mulit.getParameter("sectioncontent");  
	        String free = mulit.getParameter("free");  
	        String seq = mulit.getParameter("seq");  
	        String sectionUrl = "attached/section/"; 
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        String val = null;
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	        	String name = (String) filesname.nextElement();//标识  
	        	val =  mulit.getFilesystemName(name); //取得文件名  
	        	sectionUrl +=val;
	        }  
			SectionVo section = new SectionVo();
			section.setSectionid(Integer.parseInt(sectionid));
			section.setSectionname(sectionname);
			section.setSectioncontent(sectioncontent);
			section.setFree(Integer.parseInt(free));
			section.setSeq(Integer.parseInt(seq));
//			if(val!=null && !val.equals("")){
//				
//				section.setSectionurl(sectionUrl);
//			}
			section.setReason("");
			section.setStatus(0);
			base.sectionUpdate(section);//修改
			listPage(request,response,Integer.parseInt(courseid));
        	getServletContext().getRequestDispatcher("/jsp/sectionList.jsp").forward(request, response);}else if(action.equals("del")){
			
		}else if(action.equals("status")){
			String sectionid = request.getParameter("sectionid");
			int status = Integer.parseInt(request.getParameter("status"));
			base.updatestatus(sectionid, status);
			listPage(request,response);
			request.getRequestDispatcher("/jsp/sectionList.jsp").forward(request,response);
		}else if(action.equals("video")){
			String sectionid = request.getParameter("sectionid");
			SectionVo section = base.findsectionById(sectionid);
			request.setAttribute("section", section);
        	getServletContext().getRequestDispatcher("/web/video7.jsp").forward(request, response);
		}else if(action.equals("audit")){
			String sectionid = request.getParameter("sectionid");
			SectionVo section = base.findsectionById(sectionid);
			request.setAttribute("section",section);
			request.getRequestDispatcher("/jsp/sectionAudit.jsp").forward(request, response);
		}else if(action.equals("auditSave")){
			String sectionid = request.getParameter("sectionid");
			String status = request.getParameter("status");
			String reason = request.getParameter("reason");
			SectionVo section = new SectionVo();
			section.setSectionid(Integer.parseInt(sectionid));
			section.setStatus(Integer.parseInt(status));
			section.setReason(reason);
			base.sectionAudit(section);
			listPage(request,response);
			request.getRequestDispatcher("/jsp/sectionList1.jsp").forward(request, response);
		}else if(action.equals("del")){
			String sectionid = request.getParameter("sectionid");
			base.sectionDel(Integer.parseInt(sectionid));
			listPage(request,response,user.getUserid());
        	request.getRequestDispatcher("/jsp/sectionList.jsp").forward(request, response);
		}else if(action.equals("video")){
			String coeid=request.getParameter("course");
			System.out.println("课程id="+coeid);
			setCookie(request, response, coeid);
			String sectionid = request.getParameter("sectionid");
			SectionVo section = base.findsectionById(sectionid);
			request.setAttribute("section", section);
	    	getServletContext().getRequestDispatcher("/web/video7.jsp").forward(request, response);
		}

	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from Section");
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
		//获取数据库中所有的课程数据
		List<SectionVo> sectionList = base.findsectionById(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所有的课程数据
		request.setAttribute("sectionList", sectionList);
		request.setAttribute("pager", pager);
		
	}
	
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response,int courseid)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from Section");
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
		//获取数据库中所有的课程数据
		List<SectionVo> sectionList = base.findsectionById(courseid,pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所有的课程数据
		request.setAttribute("sectionList", sectionList);
		request.setAttribute("pager", pager);
		
	}
	
	
	private void setCookie(HttpServletRequest request, HttpServletResponse response, String courseid){
		Cookie cookie1 = new Cookie("courseid",URLEncoder.encode(courseid));
    	//设置一天的有效期,单位是秒
		cookie1.setMaxAge(24*60*60*30);
    	//设置保存路径
    	cookie1.setPath(request.getContextPath());
    	response.addCookie(cookie1);
	}
}
