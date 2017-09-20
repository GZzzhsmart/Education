<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>课程安排</title>
	 <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
</head>
<body>
	 <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="${pageContext.request.contextPath }/jsp/courseAdd.jsp"> 添加内容</a> </li>
        <li>
          <form name="hf" action="${pageContext.request.contextPath }/courseServlet?action=shousuo1" method="post">
          	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          	<input type="submit" class="button border-main icon-search" value=" 搜 索 ">
          	<a href="${pageContext.request.contextPath }/courseServlet?action=list" class="button border-main icon-search"> 首 页 </a>
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th align="center">图片</th>
		<th align="center">课程名称</th>
		<th align="center">课时数</th>
		<th align="center">发布人</th>
		<th align="center">发布时间</th>
		<th align="center">有效与否</th>
		<th align="center">状态</th>
		<th align="center">未通过原因</th>
		<th align="center">操作</th>
      </tr>
    
      <c:forEach items="${courseList1}" var="d">
        <tr>
          <td><img src="http://localhost:8080/education/${d.pictureurl}" height="50"/></td>
          <td>${d.coursename}</td>
          <td>${d.coursecount }</td>
		  <td>${d.username}</td>
		  <td>${d.replaydate}</td>
		  <td>
		  <c:if test="${d.effective==0}">无效</c:if>
		  <c:if test="${d.effective==1}">有效</c:if>
		  </td>
		  <td>
		  <c:if test="${d.status==0}">未审核</c:if>
		  <c:if test="${d.status==1}">已审核</c:if>
		  <c:if test="${d.status==2}">审核未通过</c:if>
		  </td>
		  <td>${d.reason}</td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="<%=basePath%>courseServlet?action=audit&courseid=${d.courseid }"><span class="icon-edit">
          </span> 审核</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
	</body>
</html>