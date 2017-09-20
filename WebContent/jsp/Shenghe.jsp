<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>审核</title>
    
	

  </head>
  
  <body background="${pageContext.request.contextPath }/image/915.jpg">
  	<br><br><br><br><br><br><br><br><br>	
   	<center><font size="6" color="#0033ff"><b>正在审核中...</b></font></center>
  </body>
</html>
