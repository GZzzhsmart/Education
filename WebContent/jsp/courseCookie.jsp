<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="bean.CourseVo"%>
<%@page import="base.IBaseDAO"%>
<%@page import="base.BaseDAOImpl"%>
<%@page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <title>宏图教育在线学习平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/base.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/about.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/header.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/ifter.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery-1.5.2.min.js"></script>
		<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
  	<%
  		//读取cookie变量的值
	  		Cookie cookies[]=request.getCookies();
	  		String courseid = "";
	  		String pass="";
	  		//如果没有cookie则，数组为空
	  		if(cookies!=null){
	  			for(int i=0;i<cookies.length;i++){
	  				Cookie c = cookies[i];
	  				System.out.println(c.getName()+"="+c.getValue());
	  				if(c.getName().equals("courseid")){
	  					//解码操作URLDecoder.decode();
	  					courseid=URLDecoder.decode(c.getValue());//获取cookie的值
	  				}
	  				if(c.getName().equals("password")){
	  					pass=URLDecoder.decode(c.getValue());//获取cookie的值
	  				}
	  			}
	  		}
	  		IBaseDAO base=new BaseDAOImpl();
	  		CourseVo use=base.findcourseById(courseid);
  			
  	 %>
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<div class="leftBox">
            <jsp:include page="/web/left.jsp" flush="true"></jsp:include>
      	</div>
      	<div class="rightBox">
    		<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;
    			<a href="${pageContext.request.contextPath }/jsp/courseAdd.jsp?courseid=${use.courseid}"></a></p>
            <div class="newsContent">
            	<div class="artibody">
    	<h3 align="center"><font color="red">${msg}</font></h3>
    	<table align="center" border="0" cellpadding="1" cellspacing="1" width="100%">
    	<tr>
    		<td align="right"><a href="${pageContext.request.contextPath }/jsp/courseAdd.jsp?courseid=${use.courseid}"><b></b></a></td>
    	</tr>
    	</table>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    	<thead>
    		<tr>
    			<th>课程图片</th>
    			<th>课程名称</th>
    			<th>课时</th>
    			<th>单价</th>
    			<th>折后价</th>
    			<th>发布状态</th>
    			<th>是否收费</th>
    			<th>审核状态</th>
    			<th>操作</th>
    		</tr>
    	</thead>
		<tr height="40">
			<td width="150px">
				<img src="${pageContext.request.contextPath }/<%=use.getPictureurl() %>" height="100"/>
			</td>
			<td width="150px"><%=use.getCoursename() %></td>
			<td><%=use.getCoursecount() %></td>
			<td><%=use.getPrice() %></td>
			<td><%=use.getDiscount() %></td>
			<td>
				<c:if test="<%=use.getEffective()==0 %>">未发布</c:if>
				<c:if test="<%=use.getEffective()==1 %>">已发布</c:if>
				<c:if test="<%=use.getEffective()==2 %>">停售</c:if>
			</td>
			<td>
				<c:if test="<%=use.getChargetype()==0 %>">免费</c:if>
				<c:if test="<%=use.getChargetype()==1 %>">收费</c:if>
			</td>
			<td>
				<c:if test="<%=use.getStatus()==0 %>">未审核</c:if>
				<c:if test="<%=use.getStatus()==1 %>">已审核</c:if>
				<c:if test="<%=use.getStatus()==2 %>">审核未通过</c:if>
			</td>
			<td>
				<a href="${pageContext.request.contextPath}/Course?action=buyDetail&courseid=<%=use.getCourseid() %>">查看</a>
			</td>
		</tr>
	</table>
	</div></div></div>
   	<div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
					