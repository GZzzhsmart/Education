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
   
    <title>优惠券活动表</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
  </head>
  
  <body>
   
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 优惠活动管理</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
      </ul>
    </div>
    <table class="table table-hover text-center">
     <tr>
 		<th align="center">活动名称</th>
 		<th width="150" align="center">创建日期</th>
 		<th width="300" align="center">活动描述</th>
 		<th width="120" align="center">操作</th>
    </tr>
    	
      <c:forEach items="${couponList}" var="d">
        <tr>
        
          <td style="text-align:left; padding-left:20px;">${d.activityName }</td>
		  <td>${d.createDate }</td>
		  <td>${d.activityDesc }</td>
        
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="${pageContext.request.contextPath }/couponRecordServlet?action=produce1&couponRecordId=${d.couponRecordId}"><span class="icon-edit">
          </span> 优惠券管理</a>
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>couponRecordServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>couponRecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>couponRecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
  </div>

<script type="text/javascript">

</script>
       </body>
</html>