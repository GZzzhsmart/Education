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
   	
    <title>充值记录表</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
  </head>
  
  <body>
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <form name="hf" action="#" method="post">
          	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          	<input type="submit" class="button border-main icon-search" value=" 搜 索 ">
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        	<th>充值id</th>
    		<th>用户名称</th>
    		<th>充值时间</th>
    		<th>账户余额</th>
      </tr>
      <c:forEach items="${moneyList}" var="d">
        <tr>
          <td>${d.recordid }</td>
		  <td>${d.username }</td>
		  <td>${d.paydate }</td>
		  <td>${d.paymoney }</td>
          <td>
         
          </td>
        </tr>
  </c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>moneyRecordServlet?action=list2&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>moneyRecordServlet?action=list2&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>moneyRecordServlet?action=list2&currentPage=${pager.currentPage}&opr=next">尾页</a> 
        </div>
        </td>
      </tr>
    </table>

<script type="text/javascript">

</script>
  </body>
</html>
