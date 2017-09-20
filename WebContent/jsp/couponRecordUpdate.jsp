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
	    <form name="form1" action="${pageContext.request.contextPath}/couponRecordServlet?action=updateSave" method="post">
    	<input type="hidden" name="couponRecordId" value="${coupon.couponRecordId}"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
		<tr height="40">
			<td align="right">活动名称：</td>
			<td>
				<input type="text" name="activityName" style="width:400px" value="${coupon.activityName }"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">活动说明</td>
			<td colspan="2">
				<textarea  name="activityDesc" style="height:140px;width:600px">
				${coupon.activityDesc }
				</textarea>
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
