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
    
    <title>${section.sectionname}</title>   
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1 align="center">${section.sectionname}</h1>
  	 <object id="mediaPlayer" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" width="1000" height="600"' codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701"
         standby="Loading Microsoft Windows Media Player components..." type="application/x-oleobject">
  		 <param name="autoStart" value="true"/>
  		  <param name="url"       value="${pageContext.request.contextPath}/${section.sectionurl}" />
  	  	<param name="movie"  value="" />
        <param name="quality" value="high" />
        <param name="wmode" value="transparent" />
         <param name="uiMode"    value="full" />
         <param name="loop"      value="false" />  
		<embed src="${pageContext.request.contextPath}/${section.sectionurl}" quality="high" type="application/x-shockwave-flash" width="1000" height="600"></embed>
	</object>
  </body>
</html>
