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
	<script type="text/javascript">
    	function check(){
    		if(form1.mobile.value==""){
    			alert("请输入手机号码。");
    			form1.mobile.focus();
    			return false;
    		}
    		if(form1.password.value==""){
    			alert("请输入登录密码。");
    			form1.password.focus();
    			return false;
    		}
    		if(form1.password.value!=form1.cfgpwd.value){
    			alert("登录密码余确认密码不一致。");
    			form1.cfgpwd.focus();
    			return false;
    		}
    		return true;
    	}
    	function changeProv(provinceId){
    		location.href="<%=basePath%>usersServlet?action=init&provinceId="+provinceId;
    	}
    </script>
  </head>
  
  <body>
    <h3 align="center"><font color="red">讲师审核</font></h3>
    <form name="form1" action="${pageContext.request.contextPath}/teacherServlet?action=auditSave" method="post" onsubmit="return check();">
    	<input type="hidden" name="teacherId" value="${teacher.userid}"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">讲师学历：</td>
			<td>${teacher.education}</td>
		</tr>
		<tr height="40">
			<td align="right">教学年限：</td>
			<td>${teacher.teacherLength}</td>
		</tr>
		<tr height="40">
			<td align="right">讲师头像：</td>
			<td>
				<img src="${pageContext.request.contextPath }/${teacher.headpictureUrl}" height="100"/>
			</td>
		</tr>
		<tr height="40">
			<td align="right">银行名称：</td>
			<td>${teacher.bankName }</td>
		</tr>
		<tr height="40" colspan="2">
			<td align="right">开  户  人：</td>
			<td>${teacher.accountName}</td>
		</tr>
		<tr>
			<td align="right">银行账号</td>
			<td>${teacher.accountNo}</td>
		</tr>
		<tr>
			<td align="right">教学特长</td>
			<td>${teacher.teacherSpecial}</td>
		</tr>
		<tr>
			<td align="right">教师简介</td>
			<td>${teacher.teacherIntroduce}</td>
		</tr>
		<tr height="40">
			<td align="right">审核状态：</td>
			<td>
			<select name="status" style="width:200px">
				<c:if test="${teacher.status==0}">
					<option value="0" selected="selected">未审核</option>
					<option value="1">已审核</option>
					<option value="2">审核未通过</option>
					<option value="3">封号</option>
				</c:if>
				<c:if test="${teacher.status==1}">
					<option value="0">未审核</option>
					<option value="1" selected="selected">已审核</option>
					<option value="2">审核未通过</option>
					<option value="3">封号</option>
				</c:if>
				<c:if test="${teacher.status==2}">
					<option value="0">未审核</option>
					<option value="1">已审核</option>
					<option value="2" selected="selected">审核未通过</option>
					<option value="3">封号</option>
				</c:if>
				<c:if test="${teacher.status==3}">
					<option value="0">未审核</option>
					<option value="1">已审核</option>
					<option value="2">审核未通过</option>
					<option value="3" selected="selected">封号</option>
				</c:if>
			</select>
			</td>
		</tr>
		<tr height="40">
			<td align="right">讲师等级：</td>
			<td>
				<select name="gradeId" style="width:155px">
					<c:forEach items="${gradeList}" var="d">
						<c:if test="${d.gradeId==teacher.gradeId}">
							<option value="${d.gradeId}" selected="selected">${d.gradeName}</option>
						</c:if>
						<c:if test="${d.gradeId != teacher.gradeId}">
							<option value="${d.gradeId}">${d.gradeName}</option>
						</c:if>
					</c:forEach>
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
