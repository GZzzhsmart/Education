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
   
    <title>买课记录表</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
  </head>
  
  <body>
   <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 买课记录</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
         <th >买课编号</th>
         <th >用户id</th>
         <th >课程id</th>
         <th >课程名称</th>
         <th >付款时间</th>
         <th >付款金额</th>
         <th >买课人</th>
      </tr>
    
      <c:forEach items="${payrecordList}" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;">${d.payrecordid }</td>
          <td>${d.userid }</td>
    	  <td width="10%">${d.courseid }</td>
    	   <td>${d.coursename }</td>
    	   <td>${d.paydate }</td>
    	   <td>${d.paymoney }</td>
    	   <td>${d.payer }</td>
          <td>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="${pageContext.request.contextPath}/payrecordServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="${pageContext.request.contextPath}/payrecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="${pageContext.request.contextPath}/payrecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
  </div>
</form>
<script type="text/javascript">

</script>
  </body>
</html>
