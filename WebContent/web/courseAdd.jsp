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
	
  </head>
  
  <body>
  	<jsp:include page="/web/head.jsp" flush="true"></jsp:include>
    <div id="main">
    	<p class="news_title">当前位置：<a href="${pageContext.request.contextPath}/loginAction!index.action">首页</a>&gt;申请讲师
    	</p>
     	  <div style="font-size: 14px; margin-top: 0px; background: #f5f5f5 url('${pageContext.request.contextPath }/web/image/baoming_bg.png') no-repeat left top; ">
     	  <div style="width: 100% ;height: 100px;"></div>
    <h3 align="center"><font color="red">${msg}</font></h3>
    <form name="form1" action="${pageContext.request.contextPath}/courseServlet?action=add" enctype="multipart/form-data" method="post" onsubmit="return check();">
    	<input type="hidden" name="courseid" value="${course.courseid }"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">课程名称：</td>
			<td>
				<input type="text" name="coursename" style="width:155px" value="${course.coursename}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">课程图片：</td>
			<td>
				<input type="file" name="pictureurl" style="width:155px"/>
				<img src="${pageContext.request.contextPath }/${course.pictureurl}" height="100"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">一句话：</td>
			<td>
				<input type="text" name="oneword" style="width:155px" value="${course.oneword}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">课程介绍：</td>
			<td>
				<input type="text" name="introduce" style="width:155px" value="${course.introduce}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">课时：</td>
			<td>
				<input type="text" name="coursecount" style="width:155px" value="${course.coursecount}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td align="right">价格：</td>
			<td>
				<input type="text" name="price" style="width:155px" value="${course.price}"/>
			</td>
			<td>&nbsp;</td>
		</tr>
		<tr height="40">
			<td align="right">折后价：</td>
			<td>
				<input type="text" name="discount" style="width:155px" value="${teacher.discount}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">有效与否</td>
			<td>
				<c:if test="${course.chargeType==0}">免费</c:if>
				<c:if test="${course.chargeType==1}">收费</c:if>
			</td>
			
		</tr>
		<tr height="40">
			<td align="right">审核状态：</td>
			<td colspan="2">
				<c:if test="${course.status==0}">未审核</c:if>
				<c:if test="${course.status==1}">已审核</c:if>
				<c:if test="${course.status==2}">审核未通过</c:if>
			</td>
		</tr>
		<tr height="40">
			<td align="right">发布状态：</td>
			<td colspan="2">
				<c:if test="${course.effective==0}">未发布</c:if>
				<c:if test="${course.effective==1}">已发布</c:if>
				<c:if test="${course.effective==2}">停售</c:if>
			</td>
		</tr>
		<tr height="40">
			<td align="right">发布人：</td>
			<td>
				<input type="text" name="username" style="width:155px" value="${course.username}"/>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">排序</td>
			<td>
				<input  name="seq" style="height:140px;width:580px" value="${course.seq}"/> 
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr>
			<td align="right">未通过原因</td>
			<td>
				<textarea  name="reason" style="height:140px;width:580px"> ${course.reason}</textarea>
			</td>
			<td><font size="2" color="red">*必填</font></td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 发 布 "></td>
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
