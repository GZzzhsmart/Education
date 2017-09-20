<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/news.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/header.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery-1.5.2.min.js"></script>
	<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css"/>
    
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery-1.5.2.min.js"></script>
	<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css"/>
  </head>
  
  <body>
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;课程列表
    	</p>
			<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
			<c:forEach items="${courseList}" var="d">
			<tr height="40">
				<td>
				<table align="center" border="0" width="100%">
					<tr>
						<td rowspan="3" width="220"><img src="${pageContext.request.contextPath }/${d.pictureurl}" height="150"/></td>
						<td align="left" width="300"><font size="2"><b>${d.coursename }</b></font></td>
						<td><font size="3" color="red"><b>¥${d.price }</b></font></td>
					</tr>
					<tr>
						<td align="left" colspan="2"><hr/>${d.introduce}</td>
					</tr>
					<tr>
						<td align="left">共${d.coursecount}课时</td>
						<td align="right"><a href="${pageContext.request.contextPath }/Course?action=buyDetail&courseid=${d.courseid }"><font size="2" color="red"><b>详情&nbsp;&nbsp;&nbsp;&nbsp;</b></font></a></td>
						
					</tr>
				</table>
			</td>
		</tr>
		</c:forEach>
			</table>
		
		

   	    <div style="width: 100% ;height: 50px;"></div>
   	  </div>          
      <div class="clear"></div>
	 <div class="clear" style="height: 30px;"></div>
	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
	
	
  </body>
</html>
