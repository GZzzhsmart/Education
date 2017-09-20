<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>章节审核</title>
    <jsp:include page="/IncludeJS.jsp"></jsp:include>
  </head>
  
  <body>
    <h3 align="center"><font color="red">章节审核</font></h3>
    <form name="form1" action="${pageContext.request.contextPath}/sectionServlet?action=auditSave" method="post" onsubmit="return check();">
    	<input type="hidden" name="sectionid" value="${section.sectionid}"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">课程id：</td>
			<td>${section.courseid}</td>
		</tr>
		<tr height="40">
			<td align="right">章节名称：</td>
			<td>${section.sectionname}</td>
		</tr>
		<tr height="40">
			<td align="right">视频地址：</td>
			<td>${section.sectionurl }</td>
		</tr>
		<tr height="40">
			<td align="right">课程简介：</td>
			<td>${section.sectioncontent }</td>
		</tr>
		<tr height="40">
			<td align="right">审核状态：</td>
			<td>
			<select name="status" style="width:200px">
				<c:if test="${section.status==0}">
					<option value="0" selected="selected">未审核</option>
					<option value="1">已审核</option>
					<option value="2">审核未通过</option>
				</c:if>
				<c:if test="${section.status==1}">
					<option value="0">未审核</option>
					<option value="1" selected="selected">已审核</option>
					<option value="2">审核未通过</option>
				</c:if>
				<c:if test="${section.status==2}">
					<option value="0">未审核</option>
					<option value="1">已审核</option>
					<option value="2" selected="selected">审核未通过</option>
				</c:if>
			</select>
			</td>
		</tr>
		<tr height="40">
			<td align="right">未通过原因：</td>
			<td>
				<textarea name="reason" style="width:580px;height:50px"></textarea>
			</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
  </body>
</html>
