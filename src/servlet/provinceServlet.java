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
import bean.CityVo;
import bean.ProvinceVo;

public class provinceServlet extends HttpServlet {

	IBaseDAO base = new BaseDAOImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("list")){
			listPage(request, response);
			request.getRequestDispatcher("/jsp/provinceList.jsp").forward(request, response);
		}else if(action.equals("add")){
			String provinceId = request.getParameter("provinceId");
			String provinceName = request.getParameter("provinceName").trim();
			ProvinceVo province = new ProvinceVo();
			province.setProvinceId(Integer.parseInt(provinceId));
			province.setProvinceName(provinceName);
			base.provinceAdd(province);
			//查询所有的数据，转向到列表页面
			listPage(request, response);
			//转向到provinceList.jsp页面
			request.getRequestDispatcher("/jsp/provinceList.jsp").forward(request, response);
		}else if(action.equals("update")){
			//获取省份数据
			List<ProvinceVo> provinceList = base.provinceList();
			request.setAttribute("provinceList",provinceList);
			//查找需要修改的省份数据
			String provinceId = request.getParameter("provinceId");
			ProvinceVo province = base.findprovinceById(provinceId);
			request.setAttribute("province", province);
			//转向到provinceList.jsp页面
			request.getRequestDispatcher("jsp/provinceUpdate.jsp").forward(request, response);
		}else if(action.equals("updateSave")){
			String provinceId = request.getParameter("provinceId");
			String provinceName = request.getParameter("provinceName");
			ProvinceVo province = new ProvinceVo();
			province.setProvinceId(Integer.parseInt(provinceId));
			province.setProvinceName(provinceName);
			base.provinceUpdate(province);
			//查询所有的省份数据，并转向到列表页面
			listPage(request, response);
			//转向到provinceList.jsp页面
			request.getRequestDispatcher("/jsp/provinceList.jsp").forward(request, response);
		}else if(action.equals("del")){
			String provinceId = request.getParameter("provinceId");
			base.provinceDel(Integer.parseInt(provinceId));
			listPage(request, response);
			//转向到provinceList.jsp页面
			request.getRequestDispatcher("/jsp/provinceList.jsp").forward(request, response);
		}
	}
	//查询省份资料
	public void list(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取数据库中所有的省份数据
		List<ProvinceVo> provinceList =base.provinceList();
		//定义request变量，保存的是所以的省份数据
		request.setAttribute("provinceList", provinceList);
	}
	//分页
	public void listPage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取页面的参数
		String currentPage = request.getParameter("currentPage");
		String opr = request.getParameter("opr");
		//获取总记录数
		int cnt = base.getCount("select count(*) cnt from province");
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
		//获取数据库中所有的省份数据
		List<ProvinceVo> provinceList =base.provinceList(pager.getPageSize(),pager.getStartPos());
		//定义request变量，保存的是所有的省份数据
		request.setAttribute("provinceList", provinceList);
		request.setAttribute("pager", pager);
	}

}
