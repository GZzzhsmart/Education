<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>教师管理中心</title>
    <link rel="stylesheet" type="text/css" href="css/base.css" />
    <link rel="stylesheet" type="text/css" href="css/admin-all.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap1.min.css" />
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript" src="js/jquery.spritely-0.6.js"></script>
    <script type="text/javascript" src="js/chur.min.js"></script>
    <link rel="stylesheet" type="text/css" href="css/login2.css" />
    <script type="text/javascript">
		function checkLogin(){
			var code = form1.code.value;
			var password = form1.password.value;
			var username = form1.username.value;
			if(code==""||password==""||username=="") {
				alert("请填写完整用户名，密码和验证码");
				return false;
			}
			return true;
		}
		function refresh(){
			document.getElementById("codes").src= '${pageContext.request.contextPath }/enimg.jsp?'+Math.random();
		}
	</script>
</head>
<body >
    <div id="clouds" class="stage"></div>
    <div class="loginmain">
    </div>
		
    <div class="row-fluid">
    <c:if test="${msg!=null}">
	  	<script type="text/javascript">
	  		alert("${msg}");
	  	</script>
    </c:if>
    <form action="${pageContext.request.contextPath }/teacherServlet?action=login2" name="form1" method="post" onsubmit="return checkLogin();">
        <h1>教师管理系统</h1>
        <p>
            <label>帐&nbsp;&nbsp;&nbsp;号：<input type="text" name="username" id="uid" placeholder="输入账号"/></label>
        </p>
        <p>
            <label>密&nbsp;&nbsp;&nbsp;码：<input type="password" name="password"  id="pwd" placeholder="输入密码"/></label>
        </p>
        <p class="pcode">
            <label>验&nbsp;&nbsp;证&nbsp;&nbsp;码：<input type="text" name="code" id="code" placeholder="输入验证码" maxlength="5" class="code" /><img src="${pageContext.request.contextPath }/enimg.jsp"width="65" height="28" id="codes" alt="点击换一张" align="top" onclick="refresh();" class="imgcode" /></label>
        </p>
        <p class="tip">&nbsp;</p>
        <hr />
        <input type="submit" value=" 登 录 " class="btn btn-primary btn-large login" />
        &nbsp;&nbsp;&nbsp;<input type="reset" value=" 重 置 " class="btn btn-large" />
        </form>
    </div>
</body>
</html>
