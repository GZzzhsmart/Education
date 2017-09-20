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
        	<p class="news_title"><a href="${pageContext.request.contextPath}/web/index.jsp">首页</a>&gt;我的余额</p>
            <div class="newsContent">
            	<div class="artibody">
        	        <ul>
        	        	<li>充值id：${money.recordid }</li>
        	        	<li class="bt"><hr/></li>	
        	        	<li>用户名称：${money.username }</li>
        	        	<li class="bt"><hr/></li>	
        	        	<li>充值时间：${money.paydate }<hr/></li>
        	        	<li class="bt"></li>	
        	        	<li>我的余额：${money.paymoney }</li>
        	        	<li class="bt"><hr/></li>	
        	        	<a href="http://localhost:8080/education/jsp/moneyChonzhi.jsp?userid=${ money.userid }&moey=${money.paymoney }&chonid=${money.recordid }">充值金额</a>
                    </ul>
               </div>
          </div>
    	</div>
    </div>
    <div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
