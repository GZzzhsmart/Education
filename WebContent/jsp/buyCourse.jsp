<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.UsersVo"%>
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
  </head>
  <body>
  	<%
		UsersVo user=(UsersVo)session.getAttribute("user");
  	 %>
  	<c:if test="${msg!=null}">
  		<script type="text/javascript">
  			alert("${msg}");
  		</script>
  	</c:if>
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;课程列表
    	</p>
    		<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
    			<tr>
    				<td width="400">
    					<img src="${pageContext.request.contextPath }/${course.pictureurl}" height="300"/>
    				</td>
    				<td valign="top">
    					<table width="100%" height="300">
	    					<tr><td colspan="2"><font size="3"><b>${course.coursename }</b></font></td></tr>
	    					<tr><td colspan="2"><font size="3"><b>课时数${course.coursecount }</b></font></td></tr>
	    					<tr><td colspan="2"><font size="3" color="red"><b>价  格:¥${course.price }</b></font></td></tr>
	    					<tr><td colspan="2"><font size="3" color="red"><b>折后价:¥${course.discount}</b></font></td></tr>
	    					<tr>
	    						<td width="320" colspan="2">
	    							<c:if test="${coupon!=null}">
										${coupon.couponMoney}元优惠券，${coupon.validDay }天内有效&nbsp;&nbsp;&nbsp;&nbsp;
									</c:if>
	    						</td>
	    					</tr>
	    					<tr>
								<td width="90">
									<a href="${pageContext.request.contextPath }/Course?action=linqu&cpid=${coupon.couponCodeId}&courseid=${course.courseid}&crd=<%=user.getUserid()%>&useDate=${coupon.useDate }"><input type="button" value="立即领取"/></a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath }/Course?action=goumai&courseid=${course.courseid}&userid=${param.userid}"><input type="button" value="立即购买"/></a>
								</td>
								<td width="90">
									<a href="${pageContext.request.contextPath }/jsp/Liuyanban.jsp?userid=${param.userid}"><font size="4" color="red">在线咨询</font></a>
								</td>
							</tr>
    					</table>
    				</td>
    			</tr>
    		</table>
    		<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%" height="50">
    		<tr><td><h2>课程介绍</h2></td></tr>
    		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;${course.introduce}</td></tr>
    		</table>
    		<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%" height="50">
    		<tr><td><h2>课程目录</h2></td></tr>
    		</table>
			<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
			<c:forEach items="${sectionList}" var="d">
				<tr height="40">
					<td>
					<table align="center" border="0" width="100%">
						<tr>
							<td align="left" colspan="2"><font size="2"><b>${d.sectionname}</b></font></td>
						</tr>
						<tr>
							<td align="left">${d.sectioncontent}</td>
							<td align="right"><a href="${pageContext.request.contextPath }/sectionServlet?action=video&sectionid=${d.sectionid}&course=${ course.courseid}" target="_blank"">立即试学</a></td>
						</tr>
					</table>
					</td>
				</tr>
			</c:forEach>
			</table>
			<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%" height="50">
    		<tr><td><h2>学生评价</h2></td></tr>
    		</table>
    		<table align="center" border="1" cellpadding="1" cellspacing="1" width="100%">
			<c:forEach items="${usercourseList}" var="d">
				<tr>
					<td>
						<c:if test="${d.evallevel==1}"><font color="red">好评</font></c:if>
						<c:if test="${d.evallevel==2}"><font color="red">中评</font></c:if>
						<c:if test="${d.evallevel==3}"><font color="red">差评</font></c:if>
					</td>
					<td>${d.userName }</td>
					<td>${d.evalcontent }</td>
					<td>${d.evaldate }</td>
				</tr>
			</c:forEach>
			</table>
   	    <div style="width: 100% ;height: 50px;"></div>
   	  </div>          
      <div class="clear"></div>
	 <div class="clear" style="height: 30px;"></div>
	<jsp:include page="/web/footer.jsp" flush="true"></jsp:include>
  </body>
</html>