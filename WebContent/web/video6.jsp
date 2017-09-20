<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
   <head>
      <!-- saved from url=(0025)http://www.techsmith.com/ -->
      <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
      <meta name="DC.language" content="ENU" />
      <meta name="DC.title" content="T55" />

      <title>${section.sectionname}</title>   
   </head>
   <body>
   		
   		<h1 align="center">${section.sectionname}</h1>
      <object id="mediaPlayer" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" width="1000" height="600"' codebase="http://activex.microsoft.com/activex/controls/mplayer/en/nsmp2inf.cab#Version=5,1,52,701"
         standby="Loading Microsoft Windows Media Player components..." type="application/x-oleobject">
         <param name="autoStart" value="true"/>
         <param name="url"       value="${pageContext.request.contextPath}/${section.sectionurl}" />
         <param name="wmode"     value="transparent" />
         <param name="uiMode"    value="full" />
         <param name="loop"      value="false" />               
         <embed id="EmbedmediaPlayer" type="application/x-mplayer2" src="${pageContext.request.contextPath}/${section.sectionurl}" width="1000" height="600">
         </object>
         </center>
   </body>
</html>
