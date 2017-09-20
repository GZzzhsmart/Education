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
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;在线报名
    	</p>
     	  <div style="font-size: 14px; margin-top: 0px; background: #f5f5f5 url('${pageContext.request.contextPath }/web/image/baoming_bg.png') no-repeat left top; ">
     	  <div style="width: 100% ;height: 100px;"></div>
    <h3 align="center"><font color="red">${msg}</font></h3>
    <form name="form1" action="<%=basePath%>usersServlet?action=add" method="post" onsubmit="return check();">
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">省份名称：</td>
			<td>
				<select name="provinceId" style="width:155px" onchange="changeProv(this.value);">
					<c:forEach items="${provList}" var="d">
						<c:if test="${d.provinceId == provinceId}">
							<option value="${d.provinceId}" selected="selected">${d.provinceName}</option>
						</c:if>
						<c:if test="${d.provinceId != provinceId}">
							<option value="${d.provinceId}">${d.provinceName}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td align="right">城市名称：</td>
			<td>
				<select name="cityId" style="width:155px">
					<c:forEach items="${cityList}" var="d">
						<option value="${d.cityId}">${d.cityName}</option>
					</c:forEach>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td align="right">手机号码：</td>
			<td>
				<input type="text" name="mobile" style="width:155px"/>
			</td>
			<td><font size="2" color="red">*必填，登录账号</font></td>
		</tr>
		<tr>
			<td align="right">登录密码</td>
			<td><input type="password" name="password"  style="width:155px"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">确认密码</td>
			<td><input type="password" name="cfgpwd"  style="width:155px"></td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">真实姓名</td>
			<td><input type="text" name="userName"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">性别</td>
			<td>
			<input type="radio" name="sex" value="0" checked="checked"/>男
			<input type="radio" name="sex" value="1"/>女
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">家庭地址</td>
			<td><input type="text" name="homeAddress"  style="width:155px"></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td align="right">电子邮件</td>
			<td><input type="text" name="email"  style="width:155px"></td>
			<td>&nbsp;</td>
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
