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
import bean.ForumVo;
import bean.UsersVo;

public class forumServlet extends HttpServlet {

	IBaseDAO base=new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session = request.getSession();
		UsersVo user =(UsersVo)session.getAttribute("user");
		if(action.equals("list")){
			String userid=request.getParameter("userid");
			List<ForumVo> forums=base.teacherLiuyan(userid);
			request.setAttribute("forums", forums);
			List<ForumVo> forum=base.fotuList(user.getUserid());
			request.setAttribute("forum", forum);
			getServletContext().getRequestDispatcher("/jsp/Liuyanban.jsp").forward(request, response);
		}else if(action.equals("add")){
			String neiron=request.getParameter("neiron");
			String userid=request.getParameter("userid");
			System.out.println("adfsasdfgadsfasdf="+user.getUserid());
			ForumVo fint=base.fintLiuyan(user.getUserid());
			if(fint==null || fint.equals("")){
				//学生
				ForumVo ff=new ForumVo();
				ff.setUserid(user.getUserid());
				ff.setReplayUserId(Integer.parseInt(userid));
				ff.setContent(neiron);
				base.ForumAdd(ff);
				//老师
				ForumVo ffs=new ForumVo();
				ffs.setUserid(Integer.parseInt(userid));
				ffs.setReplayUserId(user.getUserid());
				ffs.setContent("您好，请问您有什么问题？");
				base.ForumAdd2(ffs);
				List<ForumVo> forum=base.teacherLiuyan2(user.getUserid());
				List<ForumVo> forums=base.teacherLiuyan(userid);
				request.setAttribute("forums", forums);
				request.setAttribute("forum", forum);
				getServletContext().getRequestDispatcher("/jsp/Liuyanban.jsp").forward(request, response);
			}else if(fint.getFourmtype()==1){
				//学生
				ForumVo ff=new ForumVo();
				ff.setUserid(user.getUserid());
				ff.setReplayUserId(Integer.parseInt(userid));
				ff.setContent(neiron);
				base.ForumAdd(ff);
				List<ForumVo> forum=base.teacherLiuyan2(user.getUserid());
				List<ForumVo> forums=base.teacherLiuyan(userid);
				request.setAttribute("forums", forums);
				request.setAttribute("forum", forum);
				getServletContext().getRequestDispatcher("/jsp/Liuyanban.jsp").forward(request, response);
			}else if(fint.getFourmtype()==2){
				//老师
				ForumVo ffs=new ForumVo();
				ffs.setUserid(Integer.parseInt(userid));
				ffs.setReplayUserId(user.getUserid());
				ffs.setContent(neiron);
				base.ForumAdd2(ffs);
				List<ForumVo> forum=base.fotuList(user.getUserid());
				List<ForumVo> forums=base.teacherLiuyan(userid);
				request.setAttribute("forums", forums);
				request.setAttribute("forum", forum);
				getServletContext().getRequestDispatcher("/jsp/Liuyanban.jsp").forward(request, response);
			}
		}else if(action.equals("teacherinit")){
			String student=request.getParameter("student");
			String neiron=request.getParameter("neiron");
			ForumVo ff=new ForumVo();
			ff.setUserid(user.getUserid());
			ff.setReplayUserId(Integer.parseInt(student));
			ff.setContent(neiron);
			base.ForumAdd2(ff);
			List<ForumVo> forum=base.teacherLiuyan2(user.getUserid());
			request.setAttribute("forum", forum);
			getServletContext().getRequestDispatcher("/jsp/liuyanList.jsp").forward(request, response);
		}else if(action.equals("student")){
			String neiron=request.getParameter("neiron");
			String userid=request.getParameter("userid");
			System.out.println("adfsasdfgadsfasdf="+user.getUserid());
			ForumVo fint=base.fintLiuyan(user.getUserid());
			if(fint==null || fint.equals("")){
				//学生
				ForumVo ff=new ForumVo();
				ff.setUserid(user.getUserid());
				ff.setReplayUserId(Integer.parseInt(userid));
				ff.setContent(neiron);
				base.ForumAdd(ff);
				//老师
				ForumVo ffs=new ForumVo();
				ffs.setUserid(Integer.parseInt(userid));
				ffs.setReplayUserId(user.getUserid());
				ffs.setContent("您好，请问您有什么问题？");
				base.ForumAdd2(ffs);
				List<ForumVo> forum=base.fotuList(user.getUserid());
				List<ForumVo> forums=base.teacherLiuyan(userid);
				request.setAttribute("forums", forums);
				request.setAttribute("forum", forum);
				getServletContext().getRequestDispatcher("/jsp/Liuyanban.jsp").forward(request, response);
			}else if(fint.getFourmtype()==1){
				//学生
				ForumVo ff=new ForumVo();
				ff.setUserid(user.getUserid());
				ff.setReplayUserId(Integer.parseInt(userid));
				ff.setContent(neiron);
				base.ForumAdd(ff);
				List<ForumVo> forum=base.fotuList(user.getUserid());
				List<ForumVo> forums=base.teacherLiuyan(userid);
				request.setAttribute("forums", forums);
				request.setAttribute("forum", forum);
				getServletContext().getRequestDispatcher("/jsp/Liuyanban.jsp").forward(request, response);
			}
		}else if(action.equals("teacher")){
			List<ForumVo> forum=base.fotuList(user.getUserid());
			request.setAttribute("forum", forum);
			getServletContext().getRequestDispatcher("/jsp/liuyanList.jsp").forward(request, response);
		}else if(action.equals("chahuifu")){
			List<ForumVo> forum=base.teacherLiuyan2(user.getUserid());
			request.setAttribute("forum", forum);
			getServletContext().getRequestDispatcher("/jsp/kanTeacherLiuyan.jsp").forward(request, response);
		}else if(action.equals("del")){
			String forumid = request.getParameter("forumid");
		    base.forumDel(Integer.parseInt(forumid));
			request.getRequestDispatcher("/jsp/liuyanList.jsp").forward(request, response);
		}
	}
}
