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
    
    <title>购买界面</title>
     <base href="<%=basePath%>">
    <title>宏图教育在线学习平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/news.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/header.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery-1.5.2.min.js"></script>
	<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css"/>
  </head>
  <body>
  	<c:if test="${msg!=null}">
  		<script type="text/javascript">
			  alert("${msg}");
  		</script>
  	</c:if>
    <jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <form action="${pageContext.request.contextPath}/Course?action=mai" method="post">
    	<input type="hidden" name="you" value="${coupon.couponMoney}">
    	<input type="hidden" name="courseid" value="${course.courseid }">
    	<input type="hidden" name="userid" value="${param.userid}">
    	<input type="hidden" name="money" value="${course.price}">
    <div id="main">
    	<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;购买界面
    	</p>
    	
    		<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    			<tr>
    				<td width="400">
    					<img src="${pageContext.request.contextPath }/${course.pictureurl}" height="300"/>
    				</td>
    				<td valign="top">
    					<table width="100%" height="300">
	    					<tr><td colspan="2"><font size="3"><b>${course.coursename }</b></font></td></tr>
	    					<tr><td colspan="2"><font size="3" color="red"><b>价  格:¥${course.price }</b></font></td></tr>
	    					<tr><td colspan="2"><font size="3" color="red"><b>折后价:¥${course.discount}</b></font></td></tr>
	    					<tr><td colspan="2">我的优惠券金额       ${coupon.couponMoney}     元</td></tr>
    					</table>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center" height="50">
	    				<font color="red">支付金额：${course.price }</font>
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2" align="center" height="50">
    					<input type="submit" value="立即支付">
    				</td>
    			</tr>
    			
    		</table>
    	</form>	
    		
  </body>
</html>
