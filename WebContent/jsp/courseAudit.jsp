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
    <title>宏图教育在线学习平台</title>
    <jsp:include page="/IncludeJS.jsp"></jsp:include>
  </head>
  
  <body>
    <h3 align="center"><font color="red">课程审核</font></h3>
    <form name="form1" action="${pageContext.request.contextPath}/courseServlet?action=auditSave" method="post" onsubmit="return check();">
    	<input type="hidden" name="courseid" value="${course.courseid}"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">课程名称：</td>
			<td>${course.coursename}</td>
		</tr>
		<tr height="40">
			<td align="right">课时数：</td>
			<td>${course.coursecount}</td>
		</tr>
		<tr height="40">
			<td align="right">课程图片：</td>
			<td>
				<img src="${pageContext.request.contextPath }/${course.pictureurl}" height="100"/>
			</td>
		</tr>
		<tr height="40">
			<td align="right">发布人：</td>
			<td>${course.username }</td>
		</tr>
		<tr height="40" colspan="2">
			<td align="right">发布时间：</td>
			<td>${course.replaydate}</td>
		</tr>
		<tr>
			<td align="right">有效与否</td>
			<td>
				<select name="effective" style="width:200px">
				<c:if test="${course.effective==0}">
					<option value="0" selected="selected">无效</option>
					<option value="1">有效</option>
				</c:if>
				<c:if test="${course.effective==1}">
					<option value="0">无效</option>
					<option value="1" selected="selected">无效</option>
				</c:if>
			</select>
			</td>
		</tr>
		<tr height="40">
			<td align="right">审核状态：</td>
			<td>
			<select name="status" style="width:200px">
				<c:if test="${course.status==0}">
					<option value="0" selected="selected">未审核</option>
					<option value="1">已审核</option>
					<option value="2">审核未通过</option>
				</c:if>
				<c:if test="${course.status==1}">
					<option value="0">未审核</option>
					<option value="1" selected="selected">已审核</option>
					<option value="2">审核未通过</option>
				</c:if>
				<c:if test="${course.status==2}">
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
