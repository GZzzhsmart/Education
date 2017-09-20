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
    		<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;上传视频</p>
            <div class="newsContent">
            	<div class="artibody">
    	<h3 align="center"><font color="red">${msg}</font></h3>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    	<thead>
    		<tr>
    			<th width="200">章节名称</th>
    			<th width="300">视频地址</th>
    			<th>是否免费</th>
    			<th>审核状态</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<c:forEach items="${sectionList}" var="d">
		<tr height="40">
			<td width="150px">${d.sectionname }</td>
			<td>${d.sectionurl }</td>
			<td>
				<c:if test="${d.free==0}">免费</c:if>
				<c:if test="${d.free==1}">收费</c:if>
			</td>
			<td>
				<c:if test="${d.status==0}">未审核</c:if>
				<c:if test="${d.status==1}">已审核</c:if>
				<c:if test="${d.status==2}">审核未通过</c:if>
			</td>
			<td>
				<a href="${pageContext.request.contextPath }/sectionServlet?action=update&sectionid=${d.sectionid}">修改</a>|
				<a href="${pageContext.request.contextPath }/sectionServlet?action=video&sectionid=${d.sectionid}" target="_blank">试听</a>|
				<a href="${pageContext.request.contextPath }/sectionServlet?action=del&sectionid=${d.sectionid }">删除</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	    <form name="form1" action="${pageContext.request.contextPath}/sectionServlet?action=add" enctype="multipart/form-data" method="post" onsubmit="return check();">
    	<input type="hidden" name="courseid" value="${courseid}"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
		<tr height="40">
			<td align="right">审核状态：</td>
			<td colspan="2">
				<c:if test="${teacher.status==0}">未审核</c:if>
				<c:if test="${teacher.status==1}">已审核</c:if>
				<c:if test="${teacher.status==2}">审核未通过</c:if>
				<c:if test="${teacher.status==3}">封号</c:if>
			</td>
		</tr>
		<tr height="40">
			<td align="right">未通过原因：</td>
			<td colspan="2"><font color="red"><b>${section.reason}</b></font></td>
		</tr>
		<tr height="40">
			<td align="right">章节名称：</td>
			<td>
				<input type="text" name="sectionname" style="width:400px"/>
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
				<input type="text" name="seq" style="width:400px" value="1"/>
			</td>
			<td><font size="2" color="red">*必填,小号在前</font></td>
		</tr>
		<tr height="40">
			<td align="right">上传视频：</td>
			<td>
				<input type="file" name="video" style="width:400px"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">章节介绍</td>
			<td colspan="2">
				<textarea  name="sectioncontent" style="height:140px;width:600px"></textarea>
			</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
	</div></div></div>
   	<div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
