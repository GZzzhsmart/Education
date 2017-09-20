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
    		<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;发布课程</p>
            <div class="newsContent">
            	<div class="artibody">
    	<h3 align="center"><font color="red">${msg}</font></h3>
    	<table align="center" border="0" cellpadding="1" cellspacing="1" width="100%">
    	<tr>
    		<td align="right"><a href="${pageContext.request.contextPath}/jsp/courseAdd.jsp"><b>发布课程</b></a></td>
    	</tr>
    	</table>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    	<thead>
    		<tr>
    			<th>课程图片</th>
    			<th>课时</th>
    			<th>单价</th>
    			<th>折后价</th>
    			<th>发布状态</th>
    			<th>是否收费</th>
    			<th>审核状态</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<c:forEach items="${courseList}" var="d">
		<tr height="40">
			<td width="150px">
				<img src="${pageContext.request.contextPath }/${d.pictureurl}" height="100"/>
			</td>
			<td>${d.coursecount }</td>
			<td>${d.price }</td>
			<td>${d.discount }</td>
			<td>
				<c:if test="${d.effective==0}">未发布</c:if>
				<c:if test="${d.effective==1}">已发布</c:if>
				<c:if test="${d.effective==2}">停售</c:if>
			</td>
			<td>
				<c:if test="${d.chargetype==0}">免费</c:if>
				<c:if test="${d.chargetype==1}">收费</c:if>
			</td>
			<td>
				<c:if test="${d.status==0}">未审核</c:if>
				<c:if test="${d.status==1}">已审核</c:if>
				<c:if test="${d.status==2}">审核未通过</c:if>
			</td>
			<td>
			<a href="${pageContext.request.contextPath }/courseServlet?action=update&courseid=${d.courseid}">修改</a>
			<c:if test="${d.status==1}">
				<a href="${pageContext.request.contextPath }/sectionServlet?action=list&courseid=${d.courseid}">添加章节</a>
				<c:if test="${d.effective==0}">
					<a href="${pageContext.request.contextPath }/courseServlet?action=fabu&courseid=${d.courseid}">发布</a>
				</c:if>
				<c:if test="${d.effective==1}">
					<a href="${pageContext.request.contextPath }/courseServlet?action=ting&courseid=${d.courseid}">停售</a>
				</c:if>
			</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
	 <table align="center" border="0" cellpadding="1" cellspacing="1" width="500">
        <tr>
        	<td>总记录数:${pager.recordCount}</td>
        	<td>页码:${pager.currentPage}/${pager.pageCount}</td>
        	<td><a href="${pageContext.request.contextPath }/courseServlet?action=list&currentPage=1&opr=first">首页</a></td>
        	<td><a href="${pageContext.request.contextPath }/courseServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a></td>
        	<td><a href="${pageContext.request.contextPath }/courseServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a></td>
        	<td><a href="${pageContext.request.contextPath }/courseServlet?action=list&currentPage=${pager.pageCount}&opr=last">末页</a></td>
        </tr>
        </table>
	</div></div></div>
   	<div class="clear"></div>
    <div class="mt12"></div>
  	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>
