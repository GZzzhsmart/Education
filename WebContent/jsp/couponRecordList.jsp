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
    	<table align="center" border="0" cellpadding="1" cellspacing="1" width="100%">
    	<tr>
    		<td align="right"><a href="${pageContext.request.contextPath}/jsp/couponRecordAdd.jsp">新增活动</a></td>
    	</tr>
    	</table>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    	<thead>
    		<tr>
    			<th align="center">活动名称</th>
    			<th width="150" align="center">创建日期</th>
    			<th width="300" align="center">活动描述</th>
    			<th width="120" align="center">操作</th>
    		</tr>
    	</thead>
    	<c:forEach items="${couponList}" var="d">
		<tr height="40">
			<td width="150px">${d.activityName }</td>
			<td>${d.createDate }</td>
			<td>${d.activityDesc }</td>
			<td>
				<a href="${pageContext.request.contextPath }/couponRecordServlet?action=update&couponRecordId=${d.couponRecordId}">修改</a>|
				<a href="${pageContext.request.contextPath }/couponRecordServlet?action=del&couponRecordId=${d.couponRecordId}">作废|</a>
				<a href="${pageContext.request.contextPath }/couponRecordServlet?action=produce&couponRecordId=${d.couponRecordId}">优惠券管理</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
        <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="<%=basePath%>couponRecordServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="<%=basePath%>couponRecordServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="<%=basePath%>couponRecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="<%=basePath%>couponRecordServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        </tr>
        </table>
	</div></div></div>
   	<div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
