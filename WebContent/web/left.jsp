<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.UsersVo"%>
<%@page import="bean.PayRecordVo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
		UsersVo user = (UsersVo)session.getAttribute("user");
%>
<div class="lc">
	<p>管理中心</p>
   	<div class="lc_Menu" id="lc_Menu">
        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/usersServlet?action=update&userid=${user.userid }" target="rightFrame"">修改资料</a></div>
        <div aid="1" class="on"><a href="jsp/Kecheng.jsp?userid=${user.userid }">去买课程</a></div>
         <c:if test="${user.userType==2}">
        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/courseServlet?action=list">我的课程</a></div>
        </c:if>
          <c:if test="${user.userType==1}">
        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/payrecordServlet?action=list1">我的课程</a></div>
      	<div aid="1" class="on"><a href="${pageContext.request.contextPath }/forumServlet?action=add&userid=${user.userid }">在线留言板</a></div>
        </c:if>
        	<div aid="1" class="on"><a href="${pageContext.request.contextPath }/moneyRecordServlet?action=list1&userid=${user.userid }">我的余额</a></div>
        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/payrecordServlet?action=list1">购买明细</a></div>
        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/Course?action=chayhj">我的优惠券</a></div>
       	<c:if test="${user.userType==1}">
        	<div aid="1" class="on"><a href="${pageContext.request.contextPath }/jsp/courseCookie.jsp">预览过课程</a></div>
        	<div aid="1" class="on"><a href="${pageContext.request.contextPath }/teacherServlet?action=init&userid=<%=user.getUserid() %>">申请讲师</a></div>
        </c:if>
        <c:if test="${user.userType==2}">
	        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/couponRecordServlet?action=list">优惠券管理</a></div>
	        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/forumServlet?action=teacher&userid=<%=user.getUserid()%>">在线留言板</a></div>
	       <div aid="1" class="on"><a href="${pageContext.request.contextPath }/payrecordServlet?action=jilu">申请提现</a></div>
        </c:if>
        <div aid="1" class="on"><a href="${pageContext.request.contextPath }/usersServlet?action=exit">安全退出</a></div>
   	</div>
</div>