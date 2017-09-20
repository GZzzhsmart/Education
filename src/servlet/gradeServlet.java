package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import base.BaseDAOImpl;
import base.IBaseDAO;
import base.PageObject1;
import bean.TeacherGradeVo;

public class gradeServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action!=null){
		 if(action.equals("init")){
				//获取讲师的数据
				List<TeacherGradeVo> teacherList = base.gradeList();
				request.setAttribute("teacherList", teacherList);
				//重定向
				request.getRequestDispatcher("/jsp/gradeAdd.jsp").forward(request, response);
			}else if(action.equals("add")){
				//获取页面参数
				String gradeName = request.getParameter("gradeName");
				String gradePercent = request.getParameter("gradePercent");
				TeacherGradeVo teacher = new TeacherGradeVo();
				teacher.setGradeName(gradeName);
				teacher.setGradePercent(Float.parseFloat(gradePercent));
				base.gradeAdd(teacher);
				listPage(request,response);
				request.getRequestDispatcher("/jsp/gradeList.jsp").forward(request, response);
			}else if(action.equals("update")){
				String gradeId = request.getParameter("gradeId");
				TeacherGradeVo grade = base.findgradeById(gradeId);
				request.setAttribute("grade", grade);
				request.getRequestDispatcher("/jsp/gradeUpdate.jsp").forward(request, response);
			}else if(action.equals("updateSave")){
				//获取页面参数
				String gradeId = request.getParameter("gradeId");
				String gradeName = request.getParameter("gradeName");
				String gradePercent = request.getParameter("gradePercent");
				TeacherGradeVo tg = new TeacherGradeVo();
				tg.setGradeId(Integer.parseInt(gradeId));
				tg.setGradeName(gradeName);
				tg.setGradePercent(Float.parseFloat(gradePercent));
				base.gradeUpdate(tg);
				listPage(request,response);
				request.getRequestDispatcher("/jsp/gradeList.jsp").forward(request, response);
			}else if(action.equals("del")){
				int gradeId = Integer.parseInt(request.getParameter("gradeId"));
				base.gradeDel(gradeId);
				listPage(request,response);
				request.getRequestDispatcher("/jsp/gradeList.jsp").forward(request, response);
			}else if(action.equals("list")){
				//查询所有的数据，并转向到列表页面
				listPage(request, response);
				//转向到gradeList.jsp页面
				request.getRequestDispatcher("/jsp/gradeList.jsp").forward(request, response);
			}
		}
	}
	//查询讲师资料
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中所有的讲师数据
		List<TeacherGradeVo> gradeList = base.gradeList();
		//定义request变量，保存的是所有的讲师数据
		request.setAttribute("gradeList", gradeList);
	}
	//分页
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总的记录数
		int cnt = base.getCount("select count(*) cnt from teacherGrade");
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
		int currpage = pager.getCurrentPage();
		//获取数据库中所有的讲师数据
		List<TeacherGradeVo> gradeList = base.gradeList(pager.getPageSize(), pager.getStartPos());
		//定义request变量，保存的是所有的讲师数据
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("pager", pager);
	}

}
