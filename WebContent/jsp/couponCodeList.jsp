<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.UsersVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
    <title>优惠券活动明细表</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
  </head>
  
  <body>
  
  	<%   
  		UsersVo user=(UsersVo)session.getAttribute("user");
  	 %>
  
    <form name="form1" action="${pageContext.request.contextPath}/couponrecordServlet?action=produce" method="post" onsubmit="return check();">
    <input type="hidden" name="couponRecordId" />
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 优惠活动</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
      </ul>
    </div>
    <table class="table table-hover text-center">
     <tr>
  		<th width="180" align="center">优惠券兑换码</th>
  		<th width="80" align="center">优惠金额</th>
  		<th width="80" align="center">有效天数</th>
  		<th width="80" align="center">领用人</th>
  		<th width="80" align="center">状态</th>
  		<th width="200" align="center">使用时间</th>
    </tr>
    	
      <c:forEach items="${couponCodeList}" var="d">
        <tr height="40">
				<td width="150px">${d.code }</td>
				<td>${d.couponMoney }</td>
				<td>${d.validDay }</td>
				<td>${d.userid }</td>
				<td>
					<c:if test="${d.status==0}">未领用</c:if>
					<c:if test="${d.status==1}">已使用</c:if>
					<c:if test="${d.status==2}">已过期</c:if>
				</td>
				<td>${d.useDate }</td>
		</tr>
   	</c:forEach>
	
       </body>
</html>