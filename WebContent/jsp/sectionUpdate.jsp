<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
    <jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<div class="leftBox">
            <jsp:include page="/web/left.jsp" flush="true"></jsp:include>
      	</div>
      	<div class="rightBox">
    		<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;修改章节信息</p>
            <div class="newsContent">
            	<div class="artibody">
    	<h3 align="center"><font color="red">${msg}</font></h3>
	    <form name="form1" action="${pageContext.request.contextPath}/sectionServlet?action=updateSave" enctype="multipart/form-data" method="post" onsubmit="return check();">
    	<input type="hidden" name="sectionid" value="${section.sectionid}"/>
    	
    	
    	<input type="hidden" name="courseid" value="${ section.courseid}">
    	
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
		<tr height="40">
			<td align="right">审核状态：</td>
			<td colspan="2">
				<c:if test="${section.status == 0}">未审核</c:if>
				<c:if test="${section.status == 1}">已审核</c:if>
				<c:if test="${section.status == 2}">审核未通过</c:if>
			</td>
		</tr>
		<c:if test="${section.status !=0 && section.status !=1}">
			<tr height="40">
				<td align="right">未通过原因：</td>
				<td colspan="2"><font color="red"><b>${section.reason}</b></font></td>
			</tr>
		</c:if>
		<tr height="40">
			<td align="right">章节名称：</td>
			<td>
				<input type="text" name="sectionname" style="width:155px" value="${section.sectionname}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">是否收费：</td>
			<td>
				<select name="free" style="width:400px;">
					<option value="0">免费</option>
					<option value="1">收费</option>
				</select>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">排序：</td>
			<td>
				<input type="text" name="seq" style="width:400px" value="${section.seq}"/>
			</td>
			<td><font size="2" color="red">*必填,小号在前</font></td>
		</tr>
		<tr height="40">
			<td align="right">课程地址：</td>
			<td>
				<input type="text" name="sectionurl" style="width:255px" value="${section.sectionurl }"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">章节介绍</td>
			<td colspan="2">
				<input type="text"  name="sectioncontent" style="height:140px;width:600px" value="${section.sectioncontent }"/>
			</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 修 改 "></td>
		</tr>
	</table>
    </form>
	</div></div></div>
   	<div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>

