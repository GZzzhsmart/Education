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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/news.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/header.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/web/js/jquery-1.5.2.min.js"></script>
	<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css"/>
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
    			alert("登录密码与确认密码不一致。");
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
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;申请讲师
    	</p>
     	  <div style="font-size: 14px; margin-top: 0px; background: #f5f5f5 url('${pageContext.request.contextPath }/web/image/baoming_bg.png') no-repeat left top; ">
     	  <div style="width: 100% ;height: 100px;"></div>
    <h3 align="center"><font color="red">${msg}</font></h3>
    <form name="form1" action="${pageContext.request.contextPath}/teacherServlet?action=add" enctype="multipart/form-data" method="post" onsubmit="return check();">
    	<input type="hidden" name="teacherId" value="${teacher.userid }"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">审核状态：</td>
			<td colspan="2">
				<c:if test="${teacher.status==0}">未审核</c:if>
				<c:if test="${teacher.status==1}">已审核</c:if>
				<c:if test="${teacher.status==2}">审核未通过</c:if>
				<c:if test="${teacher.status==3}">封号</c:if>
			</td>
		</tr>
		<c:if test="${teacher.status !=0 && teacher.status !=1}">
			<tr height="40">
				<td align="right">未通过原因：</td>
				<td colspan="2"><font color="red"><b>${teacher.reason}</b></font></td>
			</tr>
		</c:if>
		<tr height="40">
			<td align="right">讲师学历：</td>
			<td>
				<input type="text" name="education" style="width:155px" value="${teacher.education}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">教学年限：</td>
			<td>
				<input type="text" name="teacherLength" style="width:155px" value="${teacher.teacherLength}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">讲师头像：</td>
			<td>
				<input type="file" name="headpicture" style="width:155px"/>
				<img src="${pageContext.request.contextPath }/${teacher.headpictureUrl}" height="100"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">银行名称：</td>
			<td>
				<select name="bankId" style="width:155px">
					<c:forEach items="${bankList}" var="d">
						<c:if test="${d.bankid==teacher.bankId}">
							<option value="${d.bankid}" selected="selected">${d.bankname}</option>
						</c:if>
						<c:if test="${d.bankid != teacher.bankId}">
							<option value="${d.bankid}">${d.bankname}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td align="right">开  户  人：</td>
			<td>
				<input type="text" name="accountName" style="width:155px" value="${teacher.accountName}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">银行账号</td>
			<td><input type="text" name="accountNo"  style="width:155px" value="${teacher.accountNo}"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">教学特长</td>
			<td>
				<textarea name="teacherSpecial" style="height:70px;width:580px">${teacher.teacherSpecial}</textarea>
			</td>
			<td>教学特长(擅长科目)</td>
		</tr>
		<tr>
			<td align="right">教师简介</td>
			<td>
				<textarea  name="teacherIntroduce" style="height:140px;width:580px"> ${teacher.teacherIntroduce}</textarea>
			</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 保 存 "></td>
		</tr>
	</table>
    </form>
   	    <div style="width: 100% ;height: 50px;"></div>
   	  </div>          
      <div class="clear"></div>
    </div>
	 <div class="clear" style="height: 30px;"></div>
	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
