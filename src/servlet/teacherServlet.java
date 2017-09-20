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

import base.AesUtils;
import base.BaseDAOImpl;
import base.IBaseDAO;
import bean.BankVo;
import bean.CourseVo;
import bean.ManagerVo;
import bean.TeacherGradeVo;
import bean.UsersVo;
import base.PageObject1;
import bean.TeacherVo;

public class teacherServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		UsersVo users =(UsersVo)session.getAttribute("users");
		if(action.equals("list")){
			listPage(request,response);
			List<TeacherGradeVo> gradeList = base.gradeList();
			request.setAttribute("gradeList",gradeList);
			request.getRequestDispatcher("/jsp/teacherList.jsp").forward(request, response);
		}else if(action.equals("init")){
			//查询所有银行数据
			List<BankVo> bankList = base.bankList();
			TeacherVo teacher = base.findteacherById(Integer.parseInt(request.getParameter("userid")));
			request.setAttribute("bankList",bankList);
			request.setAttribute("teacher",teacher);
			getServletContext().getRequestDispatcher("/web/teacherAdd.jsp").forward(request, response);
		}else if(action.equals("add")){
			// 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/teacher");  
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
	        	getServletContext().getRequestDispatcher("/web/teacherAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        
	        String teacherId = mulit.getParameter("teacherId");  
	        String teacherIntroduce = mulit.getParameter("teacherIntroduce");  
	        String teacherSpecial = mulit.getParameter("teacherSpecial");  
	        String teacherLength = mulit.getParameter("teacherLength");  
	        String education = mulit.getParameter("education");  
	        String bankId = mulit.getParameter("bankId");  
	        String accountNo = mulit.getParameter("accountNo");  
	        String accountName = mulit.getParameter("accountName");  
	        String headpictureUrl = "attached/teacher/"; 
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        String val = null;
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	        	String name = (String) filesname.nextElement();//标识  
	        	val =  mulit.getFilesystemName(name); //取得文件名  
	            headpictureUrl +=val;
	        }  
			TeacherVo teacher = new TeacherVo();
			teacher.setUserid(Integer.parseInt(teacherId));
			teacher.setTeacherIntroduce(teacherIntroduce);
			teacher.setTeacherSpecial(teacherSpecial);
			teacher.setAccountName(accountName);
			teacher.setAccountNo(accountNo);
			teacher.setBankId(Integer.parseInt(bankId));
			teacher.setEducation(education);
			teacher.setGradeId(1);
			if(val!=null && !val.equals("")){
				teacher.setHeadpictureUrl(headpictureUrl);
			}
			teacher.setReason("");
			teacher.setStatus(0);
			teacher.setTeacherLength(teacherLength);
			if(base.teacherIsExist(teacher.getUserid())){
				base.teacherUpdate(teacher); //修改
			}else{
				base.teacherAdd(teacher);//新增
			}
			request.getRequestDispatcher("/web/webCenter.jsp").forward(request, response);
		}else if(action.equals("del")){
			String userid = request.getParameter("userid");
			base.teacherDel(Integer.parseInt("userid"));
			listPage(request, response);
			request.getRequestDispatcher("/jsp/teacherList.jsp").forward(request,response);
		}else if(action.equals("update")){
//			String userid = request.getParameter("userid");
//			TeacherVo teacher = base.findteacherById(users.getUserid());
//			request.setAttribute("teacher", teacher);
//			listPage(request, response);
//			request.getRequestDispatcher("/jsp/teacherUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
//			  // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
//	        String filePath = getServletContext().getRealPath("/attached/teacher");  
//	        // 文件最大容量 3M  
//	        int fileMaxSize = 3 * 1024 * 1024;  
//	        // 存放文件描述  
//	        @SuppressWarnings("unused")  
//	        String[] fileDiscription = { null, null };  
//	        // 文件名  
//	        String fileName = null;  
//	        // 上传文件数  
//	        int fileCount = 0;  
//	        // 重命名策略  
//	        FileRenameUtil rfrp = new FileRenameUtil();  
//	        // 上传文件  
//	        MultipartRequest mulit =null;
//	        try{
//	        	mulit = new MultipartRequest(request, filePath,fileMaxSize, "UTF-8", rfrp);//取得上传文件  
//	        }catch(Exception e){
//	        	request.setAttribute("msg", "上传文件的大小不能超过3M");
//	        	getServletContext().getRequestDispatcher("/web/teacherAdd.jsp").forward(request, response);
//	        	return;
//	        }
//	        //获取普通控件的值，不能使用request对象
//	        
//	        String userid = mulit.getParameter("userid");  
//	        String teacherIntroduce = mulit.getParameter("teacherIntroduce");  
//	        String teacherSpecial = mulit.getParameter("teacherSpecial");  
//	        String teacherLength = mulit.getParameter("teacherLength");  
//	        String education = mulit.getParameter("education");  
//	        String bankId = mulit.getParameter("bankId");  
//	        String accountNo = mulit.getParameter("accountNo");  
//	        String accountName = mulit.getParameter("accountName");  
//	        String headpictureUrl = "attached/teacher/"; 
//	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
//	        String val = null;
//	        while (filesname.hasMoreElements()) {  
//	        	//控件名称
//	        	String name = (String) filesname.nextElement();//标识  
//	        	val =  mulit.getFilesystemName(name); //取得文件名  
//	            headpictureUrl +=val;
//	        }  
//			TeacherVo teacher = new TeacherVo();
//			teacher.setUserid(Integer.parseInt(userid));
//			teacher.setTeacherIntroduce(teacherIntroduce);
//			teacher.setTeacherSpecial(teacherSpecial);
//			teacher.setAccountName(accountName);
//			teacher.setAccountNo(accountNo);
//			teacher.setBankId(Integer.parseInt(bankId));
//			teacher.setEducation(education);
//			teacher.setGradeId(1);
//			if(val!=null && !val.equals("")){
//				teacher.setHeadpictureUrl("headpictureUrl");
//			}
//			teacher.setReason("");
//			teacher.setStatus(0);
//			teacher.setTeacherLength(("teacherLength"));
//			if(base.teacherIsExist(teacher.getUserid())){
//				base.teacherUpdate(teacher); //修改
//			}else{
//				base.teacherAdd(teacher);//新增
//			}
//			request.getRequestDispatcher("/web/webCenter.jsp").forward(request, response);
		}else if(action.equals("status")){
			String userid = request.getParameter("userid");
			int status = Integer.parseInt(request.getParameter("status"));
			base.updatestatus(userid, status);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/teacherList.jsp").forward(request,response);
		}else if(action.equals("login2")){
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
				request.getRequestDispatcher("/Login3.jsp").forward(request, response);
			}else{
				UsersVo user = base.login1(username, pwd);
				if(user==null){
					request.setAttribute("msg", "用户名,密码或者账号被禁用，请确认");
					request.getRequestDispatcher("/Login3.jsp").forward(request, response);
				}else{
					//保存登录信息
					session.setAttribute("user", user);
					request.getRequestDispatcher("/htCenter2.jsp").forward(request, response);
				}
			}
		}else if(action.equals("tongguo")){
			String userid=request.getParameter("userid");
			System.out.println("规范地方规定="+request.getParameter("userid"));
			IBaseDAO base=new BaseDAOImpl();
			base.userUpdate(userid);
			base.teacherStatus(userid);
			listPage(request, response);
			//重定向到teacherList.jsp页面
			request.getRequestDispatcher("/jsp/teacherList.jsp").forward(request, response);
		}else if(action.equals("audit")){
			String teacherId = request.getParameter("teacherId");
			TeacherVo teacher = base.findteacherById(Integer.parseInt(teacherId));
			List<TeacherGradeVo> gradeList = base.gradeList();
			request.setAttribute("gradeList",gradeList);
			request.setAttribute("teacher",teacher);
			request.getRequestDispatcher("/jsp/teacherAudit.jsp").forward(request, response);
		}else if(action.equals("auditSave")){
			String teacherId = request.getParameter("teacherId");
			String gradeId = request.getParameter("gradeId");
			String status = request.getParameter("status");
			String reason = request.getParameter("reason");
			TeacherVo teacher = new TeacherVo();
			teacher.setUserid(Integer.parseInt(teacherId));
			teacher.setGradeId(Integer.parseInt(gradeId));
			teacher.setStatus(Integer.parseInt(status));
			teacher.setReason(reason);
			base.teacherAudit(teacher);
			listPage(request,response);
			List<TeacherGradeVo> gradeList = base.gradeList();
			request.setAttribute("gradeList",gradeList);
			request.getRequestDispatcher("/jsp/teacherList.jsp").forward(request, response);
		}else if(action.equals("xin1")){
			TeacherVo teacher = base.findteacherById(3);
			request.setAttribute("teacher", teacher);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/teacherInformation1.jsp").forward(request, response);
		}else if(action.equals("xin2")){
			TeacherVo teacher = base.findteacherById(1);
			request.setAttribute("teacher", teacher);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/teacherInformation1.jsp").forward(request, response);
		}else if(action.equals("xin3")){
			TeacherVo teacher = base.findteacherById(2);
			request.setAttribute("teacher", teacher);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/teacherInformation1.jsp").forward(request, response);
		}

	}

	//查询所有的教师数据
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中的教师数据
		List<TeacherVo> teacherList = base.teacherList();
		//定义request变量，保存的是所有的教师数据
		request.setAttribute("teacherList", teacherList);
	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from teacher");
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
		//获取数据库中所有的教师数据
		List<TeacherVo> teacherList = base.findteacherByPage(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所以的教师数据
		request.setAttribute("teacherList", teacherList);
		request.setAttribute("pager", pager);
	}

}
