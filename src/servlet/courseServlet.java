package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import upload.FileRenameUtil;

import com.oreilly.servlet.MultipartRequest;

import base.BaseDAOImpl;
import base.ContextUtils;
import base.IBaseDAO;
import base.PageObject1;
import bean.CourseVo;
import bean.NewMsgVo;
import bean.TeacherGradeVo;
import bean.TeacherVo;
import bean.UsersVo;

public class courseServlet extends HttpServlet {

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
			listPage(request,response);
			request.getRequestDispatcher("/jsp/courseList.jsp").forward(request, response);
		}else if(action.equals("list1")){
			listPage(request,response);
			request.getRequestDispatcher("/jsp/courseList2.jsp").forward(request, response);
		}else if(action.equals("add")){
			 // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/news");  
	        // 文件最大容量 3M  
	        int fileMaxSize = 3 * 1024 * 1024;  
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
	        	request.setAttribute("msg", "上传文件的大小不能超过3M");
	        	getServletContext().getRequestDispatcher("/jsp/courseAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        String coursename = mulit.getParameter("coursename");
			String oneword = mulit.getParameter("oneword");
			String introduce = mulit.getParameter("introduce");
			String coursecount = mulit.getParameter("coursecount");
			String price = mulit.getParameter("price");
			String discount = mulit.getParameter("discount");
//			String effective = mulit.getParameter("effective");
			String username = mulit.getParameter("username");
			String seq = mulit.getParameter("seq");
			String chargetype = mulit.getParameter("chargetype");
//			String status = mulit.getParameter("status");
			String reason = mulit.getParameter("reason");
	        String pictureurl = "attached/news/";		
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	            String name = (String) filesname.nextElement();//标识  
	            pictureurl += mulit.getFilesystemName(name); //取得文件名  
	        }  
	    	CourseVo course = new CourseVo();
			course.setCoursename(coursename);
			course.setPictureurl(pictureurl);
			course.setOneword(oneword);
			course.setIntroduce(introduce);
			course.setCoursecount(Integer.parseInt(coursecount));
			course.setPrice(Float.parseFloat(price));
			course.setDiscount(Float.parseFloat(discount));
//			course.setEffective(Integer.parseInt(effective));
			course.setUsername(username);
			course.setSeq(Integer.parseInt(seq));
			course.setChargetype(Integer.parseInt(chargetype));
//			course.setStatus(Integer.parseInt(status));
			course.setReason(reason);
			base.courseAdd(course);
			listPage(request,response);
			request.getRequestDispatcher("/jsp/courseList.jsp").forward(request, response);
		}else if(action.equals("del")){
			String courseid = request.getParameter("courseid");
			base.courseDel(Integer.parseInt(courseid));
			listPage(request,response,user.getUserid());
			request.getRequestDispatcher("/jsp/courseList.jsp").forward(request,response);
		}else if(action.equals("update")){
			String courseid = request.getParameter("courseid");
			CourseVo course = base.findcourseById(courseid);
			request.setAttribute("course", course);
			listPage(request,response,user.getUserid());
			request.getRequestDispatcher("/jsp/courseUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			// 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/news");  
	        // 文件最大容量 3M  
	        int fileMaxSize = 3 * 1024 * 1024;  
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
	        	request.setAttribute("msg", "上传文件的大小不能超过3M");
	        	getServletContext().getRequestDispatcher("/jsp/courseAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        String courseid = mulit.getParameter("courseid");
	        String coursename = mulit.getParameter("coursename");
			String oneword = mulit.getParameter("oneword");
			String introduce = mulit.getParameter("introduce");
			String coursecount = mulit.getParameter("coursecount");
			String price = mulit.getParameter("price");
			String discount = mulit.getParameter("discount");
			String effective = mulit.getParameter("effective");
			String username = mulit.getParameter("username");
			String seq = mulit.getParameter("seq");
			String chargetype = mulit.getParameter("chargetype");
			String status = mulit.getParameter("status");
			String reason = mulit.getParameter("reason");
			String userid = mulit.getParameter("userid");
			String pictureurl = "attached/news/";
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	            String name = (String) filesname.nextElement();//标识  
	            pictureurl += mulit.getFilesystemName(name); //取得文件名  
	        }  
	        CourseVo course = new CourseVo();
	        course.setCourseid(Integer.parseInt(courseid));
			course.setCoursename(coursename);
			course.setPictureurl(pictureurl);
			course.setOneword(oneword);
			course.setIntroduce(introduce);
			course.setCoursecount(Integer.parseInt(coursecount));
			course.setPrice(Float.parseFloat(price));
			course.setDiscount(Float.parseFloat(discount));
			course.setEffective(Integer.parseInt(effective));
			course.setUsername(username);
			course.setSeq(Integer.parseInt(seq));
			course.setChargetype(Integer.parseInt(chargetype));
			course.setStatus(Integer.parseInt(status));
			course.setReason(reason);
			course.setUserid(Integer.parseInt(userid));
 			base.courseUpdate(course);
 			listPage(request,response,user.getUserid());
 			request.getRequestDispatcher("/jsp/courseList.jsp").forward(request, response);
		}else if(action.equals("audit")){
			String courseid = request.getParameter("courseid");
			CourseVo course = base.findcourseById(courseid);
			request.setAttribute("course",course);
			request.getRequestDispatcher("/jsp/courseAudit.jsp").forward(request, response);
		}else if(action.equals("auditSave")){
			String courseid = request.getParameter("courseid");
			String effective =request.getParameter("effective");
			String status = request.getParameter("status");
			String reason = request.getParameter("reason");
			CourseVo course = new CourseVo();
			course.setCourseid(Integer.parseInt(courseid));
			course.setEffective(Integer.parseInt(effective));
			course.setStatus(Integer.parseInt(status));
			course.setReason(reason);
			base.courseAudit(course);
			listPage(request,response,user.getUserid());
			request.getRequestDispatcher("/jsp/courseList2.jsp").forward(request, response);
		}else if(action.equals("shousuo")){
			String coursename = request.getParameter("coursename");
			String username=request.getParameter("username");
			String status = request.getParameter("status");
			if(coursename==""|| coursename.equals("")){
				coursename="0";
			}
			if(username==""|| username.equals("")){
				username="0";
			}
			if(status==""|| status.equals("")){
				status="0";
			}
			System.out.println("人生奋斗过="+coursename);
			System.out.println("人生奋斗过="+username);
			System.out.println("人生奋斗过="+status);
			List<CourseVo> courseList = base.courseList(coursename,Integer.parseInt(status),username);
			request.setAttribute("courseList", courseList);
			request.getRequestDispatcher("/jsp/courseList2.jsp").forward(request, response);
		}else if(action.equals("ting")){
			String courseid=request.getParameter("courseid");
			System.out.println("sdfgfdsgf="+request.getParameter("courseid"));
			base.courseEffective(courseid);
			listPage(request, response, user.getUserid());
			getServletContext().getRequestDispatcher("/jsp/courseList.jsp").forward(request, response);
		}else if(action.equals("fabu")){
			String courseid=request.getParameter("courseid");
			base.courseEffective2(courseid);
			listPage(request, response, user.getUserid());
			getServletContext().getRequestDispatcher("/jsp/courseList.jsp").forward(request, response);
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
	public void listPage(HttpServletRequest request, HttpServletResponse response)
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
		List<CourseVo> courseList = base.findcourseById(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所有的课程数据
		request.setAttribute("courseList", courseList);
		request.setAttribute("pager", pager);
	}
}
