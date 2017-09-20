package servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import base.BaseDAOImpl;
import base.ContextUtils;
import upload.FileRenameUtil;
import base.IBaseDAO;
import base.PageObject1;
import bean.ManagerVo;
import bean.NewMsgVo;

public class NewsMsgServlet extends HttpServlet {
	IBaseDAO base=new BaseDAOImpl();
	public void destroy() {
		super.destroy(); 
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		ManagerVo manager = (ManagerVo)session.getAttribute("manager");
		if(action.equals("add")){
			 // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/news");  
	        // 文件最大容量 3M  
	        int fileMaxSize = 200 * 1024 * 1024;  
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
	        	getServletContext().getRequestDispatcher("/jsp/newsMsgAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        String msgName = mulit.getParameter("msgName");  
	        String oneWord = mulit.getParameter("oneWord");  
	        String msgContent = mulit.getParameter("msgContent");  
	        String publishDate = mulit.getParameter("publishDate");  
	        System.out.println("公告名称="+mulit.getParameter("msgName") );
	        System.out.print("一句话="+mulit.getParameter("oneWord"));
	        System.out.println("时间="+mulit.getParameter("publishDate") );
	        System.out.println("html内容="+mulit.getParameter("msgContent") );
	        System.out.print("发布人="+manager.getManagerAccount());
	        String effective = mulit.getParameter("effective");  
	        String seq = mulit.getParameter("seq");  
	        String newsType = mulit.getParameter("newsType");  
	        String imageUrl = "attached/news/";		
	        System.out.println("类别="+mulit.getParameter("newsType") );
	        System.out.print("排序="+mulit.getParameter("seq"));
	        System.out.println("状态="+mulit.getParameter("effective") );
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	            String name = (String) filesname.nextElement();//标识  
	            imageUrl += mulit.getFilesystemName(name); //取得文件名  
	        }  
	        String msgContentUrl="attached/news/"+ContextUtils.getFilename()+".html";
	        System.out.print("图标="+msgContentUrl);
	        //把新闻公告的内容生成静态的html页面
	        makehtml(msgContent, msgContentUrl, request);
			NewMsgVo newsmsg = new NewMsgVo();
			newsmsg.setEffective(Integer.parseInt(effective));
			newsmsg.setImageUrl(imageUrl);
			newsmsg.setMsgContent(msgContent);
			newsmsg.setMsgContentUrl(msgContentUrl);
			newsmsg.setMsgName(msgName);
			newsmsg.setNewsType(Integer.parseInt(newsType));
			newsmsg.setOneWord(oneWord);
			newsmsg.setPublishDate(publishDate);
			newsmsg.setPublishUsername(manager.getManagerAccount());
			newsmsg.setSeq(Integer.parseInt(seq));
			base.newsMsgAdd(newsmsg);
			listPage(request,response);
			request.getRequestDispatcher("/jsp/newsMsg.jsp").forward(request, response);
		}else if(action.equals("list")){
			listPage(request, response);
			request.getRequestDispatcher("/jsp/newsMsg.jsp").forward(request, response);
		}else if(action.equals("ads")){
			request.getRequestDispatcher("/jsp/newsMsg.jsp").forward(request, response);
		}else if(action.equals("update")){
			String newsid=request.getParameter("newsid");
			NewMsgVo news=base.findNewMsgById(newsid);
			request.setAttribute("news",news);
			getServletContext().getRequestDispatcher("/jsp/newsMsgUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			 // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/news");  
	        // 文件最大容量 3M  
	        int fileMaxSize = 200 * 1024 * 1024;  
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
	        	getServletContext().getRequestDispatcher("/jsp/newsMsgAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        String msgName = mulit.getParameter("msgName");  
	        String oneWord = mulit.getParameter("oneWord");  
	        String msgContent = mulit.getParameter("msgContent");  
	        String publishDate = mulit.getParameter("publishDate");  
	        System.out.println("公告名称="+mulit.getParameter("msgName") );
	        System.out.print("一句话="+mulit.getParameter("oneWord"));
	        System.out.println("时间="+mulit.getParameter("publishDate") );
	        System.out.println("html内容="+mulit.getParameter("msgContent") );
	        System.out.print("发布人="+manager.getManagerAccount());
	        String newMsgId=mulit.getParameter("newMsgId");
	        String effective = mulit.getParameter("effective");  
	        String seq = mulit.getParameter("seq");  
	        String newsType = mulit.getParameter("newsType");  
	        String imageUrl = "attached/news/";		
	        System.out.println("类别="+mulit.getParameter("newsType"));
	        System.out.print("排序="+mulit.getParameter("seq"));
	        System.out.println("状态="+mulit.getParameter("effective"));
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	            String name = (String) filesname.nextElement();//标识  
	            imageUrl += mulit.getFilesystemName(name); //取得文件名  
	        }  
	      String msgContentUrl="attached/news/"+ContextUtils.getFilename()+".html";
	        System.out.print("图片网址="+msgContentUrl);
	        //把新闻公告的内容生成静态的html页面
	        makehtml(msgContent, msgContentUrl, request);
	        //图标 
	        String tubiao=mulit.getParameter("tubiao");
			NewMsgVo newsmsg = new NewMsgVo();
			newsmsg.setNewMsgId(Integer.parseInt(newMsgId));
 			newsmsg.setEffective(Integer.parseInt(effective));
 			newsmsg.setMsgContent(msgContent);
 			newsmsg.setMsgContentUrl(msgContentUrl);
 			newsmsg.setMsgName(msgName);
 			newsmsg.setNewsType(Integer.parseInt(newsType));
 			newsmsg.setOneWord(oneWord);
 			newsmsg.setPublishDate(publishDate);
 			newsmsg.setSeq(Integer.parseInt(seq));
 			newsmsg.setImageUrl(tubiao);
 			base.newMsgUpdate(newsmsg);
 			listPage(request, response);
 			request.getRequestDispatcher("/jsp/newsMsg.jsp").forward(request, response);
		}else if(action.equals("updatetubiao")){
			System.out.print("收到分公司奋斗="+request.getParameter("newsid"));
			String newsid=request.getParameter("newsid");
			NewMsgVo news=base.findNewMsgById(newsid);
			request.setAttribute("news",news);
			getServletContext().getRequestDispatcher("/jsp/newsMsgUpdate2.jsp").forward(request, response);
		}else if(action.equals("updateSave2")){
			 // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
	        String filePath = getServletContext().getRealPath("/attached/news");  
	        // 文件最大容量 3M  
	        int fileMaxSize = 200 * 1024 * 1024;  
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
	        	getServletContext().getRequestDispatcher("/jsp/newsMsgAdd.jsp").forward(request, response);
	        	return;
	        }
	        //获取普通控件的值，不能使用request对象
	        String msgName = mulit.getParameter("msgName");  
	        String oneWord = mulit.getParameter("oneWord");  
	        String msgContent = mulit.getParameter("msgContent");  
	        String publishDate = mulit.getParameter("publishDate");  
	        String publishUsername = request.getParameter("publishUsername");
	        System.out.println("公告名称="+mulit.getParameter("msgName") );
	        System.out.print("一句话="+mulit.getParameter("oneWord"));
	        System.out.println("时间="+mulit.getParameter("publishDate") );
	        System.out.println("html内容="+mulit.getParameter("msgContent") );
	        System.out.println("发布人="+manager.getManagerAccount());
	        String newMsgId=mulit.getParameter("newMsgId");
	        String effective = mulit.getParameter("effective");  
	        String seq = mulit.getParameter("seq");  
	        String newsType = mulit.getParameter("newsType");  
	        String imageUrl = "attached/news/";		
	        System.out.println("类别="+mulit.getParameter("newsType") );
	        System.out.print("排序="+mulit.getParameter("seq"));
	        System.out.println("状态="+mulit.getParameter("effective") );
	        Enumeration filesname = mulit.getFileNames();//取得上传的所有文件(相当于标识)   
	        while (filesname.hasMoreElements()) {  
	        	//控件名称
	            String name = (String) filesname.nextElement();//标识  
	            imageUrl += mulit.getFilesystemName(name); //取得文件名  
	        }  
	      String msgContentUrl="attached/news/"+ContextUtils.getFilename()+".html";
	        System.out.print("图片网址="+msgContentUrl);
	        //把新闻公告的内容生成静态的html页面
	        makehtml(msgContent, msgContentUrl, request);
	        //图标 
			NewMsgVo newsmsg = new NewMsgVo();
			newsmsg.setNewMsgId(Integer.parseInt(newMsgId));
 			newsmsg.setEffective(Integer.parseInt(effective));
 			newsmsg.setMsgContent(msgContent);
 			newsmsg.setMsgContentUrl(msgContentUrl);
 			newsmsg.setMsgName(msgName);
 			newsmsg.setNewsType(Integer.parseInt(newsType));
 			newsmsg.setOneWord(oneWord);
 			newsmsg.setPublishDate(publishDate);
 			newsmsg.setSeq(Integer.parseInt(seq));
 			newsmsg.setImageUrl(imageUrl);
 			newsmsg.setPublishUsername(publishUsername);
 			base.newMsgUpdate(newsmsg);
 			listPage(request, response);
 			request.getRequestDispatcher("/jsp/newsMsg.jsp").forward(request, response);
		}else if(action.equals("del")){
			String newMsgId=request.getParameter("newMsgId");
			base.newMsgDel(newMsgId);
			listPage(request, response);
			request.getRequestDispatcher("/jsp/newsMsg.jsp").forward(request, response);
		}else if(action.equals("shousuo")){
			String sou=request.getParameter("keywords");
			System.out.println("人生奋斗过="+sou);
			IBaseDAO list=new BaseDAOImpl();
			List<NewMsgVo>  newsMsgList=list.newmsgList(sou);
			request.setAttribute("newsMsgList", newsMsgList);
			getServletContext().getRequestDispatcher("/jsp/newsMsgChaXun.jsp").forward(request, response);
			
		}

	}
	//分页显示
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage=request.getParameter("currentPage");
		String opr=request.getParameter("opr");
		//获取总记录数
		int cnt =base.getCount("select count(*) cnt from NewMsg");
		
		PageObject1 pager=new PageObject1();
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
		//获取数据库中所有的新闻资讯数据
		List<NewMsgVo> newMsgList=base.findNewMsgById(pager.getPageSize(), pager.getStartPos());
		//定义request变量，保存的是所以的管理员数据
		request.setAttribute("newMsgList", newMsgList);
		request.setAttribute("pager", pager);
		
	}
	
	private void makehtml(String content,String filename,HttpServletRequest request){
		String PAGE_HEAD="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\"></head><body>";
		String PAGE_TAIL="</body></html>";

		content = PAGE_HEAD + content + PAGE_TAIL;
		String savePath = request.getRealPath("/") + filename;
		File file = new File(savePath);
			FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
