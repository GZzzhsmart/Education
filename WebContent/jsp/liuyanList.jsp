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
    
    <title>留言显示</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>

  </head>
  
  <body>
   <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <td>用户名称</td>
    	<td>留言内容</td>
    	<td>留言时间</td>
    	<td>操作</td>
      </tr>
    
      <c:forEach items="${forum}" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;">${d.username }</td>
          <td>${d.content }</td>
    	  <td width="10%">${d.forumdate }</td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="${pageContext.request.contextPath }/jsp/liuyanHuifu.jsp?student=${d.userid }"><span class="icon-edit">
          </span> 回复</a> 
          <a class="button border-red" href="${pageContext.request.contextPath }/forumServlet?action=chahuifu&student=${d.userid }"><span class="icon-trash-o">
          </span> 我的回复</a> 
          <a class="button border-main" href="${pageContext.request.contextPath }/forumServlet?action=del&forumid=${d.forumid }"><span class="icon-edit">
          </span> 删除</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
    </table>
  </div>
</form>
<script type="text/javascript">

</script>
  </body>
</html>
