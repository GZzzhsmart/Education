<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.UsersVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>">
    <title>我的优惠券</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/base.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/about.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/header.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/web/css/ifter.css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery-1.5.2.min.js"></script>
	<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript">
    </script>
  </head>
  
  <body>
  	
  	<%   
  		UsersVo user=(UsersVo)session.getAttribute("user");
  	 %>
  
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<div class="leftBox">
            <jsp:include page="/web/left.jsp" flush="true"></jsp:include>
      	</div>
      	<div class="rightBox">
    		<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;优惠活动管理</p>
            <div class="newsContent">
            	<div class="artibody">
    	<h3 align="center"><font color="red">${msg}</font></h3>
	    <form name="form1" action="${pageContext.request.contextPath}/couponrecordServlet?action=produce" method="post" onsubmit="return check();">
    	<input type="hidden" name="couponRecordId" />
    	<table align="center" border="0" cellpadding="1" cellspacing="1" width="100%">
		
	</table>
	<hr color="red"/>
    </form>
     <table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    	<thead>
    		<tr>
    			<th width="180" align="center">优惠券兑换码</th>
    			<th width="80" align="center">优惠金额</th>
    			<th width="80" align="center">有效天数</th>
    			<th width="80" align="center">状态</th>
    			<th width="200" align="center">使用时间</th>
    		</tr>
    	</thead>
    	<c:forEach items="${couponCodeList}" var="d">
		<tr height="40">
			<td width="150px">${d.code }</td>
			<td>${d.couponMoney }</td>
			<td>${d.validDay }</td>
			<td>
				<c:if test="${d.status==0}">未领用</c:if>
				<c:if test="${d.status==1}">已领用</c:if>
				<c:if test="${d.status==2}">已过期</c:if>
			</td>
			<td>${d.useDate }</td>
		</tr>
		</c:forEach>    	
	</table>
	</div></div></div>
   	<div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
