<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>提现记录表</title>
	 <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
</head>
<body>
	 <div class="panel-head"><strong class="icon-reorder"> 提现列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th align="center">用户名称</th>
		<th align="center">提现银行</th>
		<th align="center">讲师名称</th>
		<th align="center">提现时间</th>
		<th align="center">提现金额</th>
		<th align="center">平台收入金额</th>
		<th align="center">状态</th>
		<th align="center">未通过原因</th>
		<th align="center">操作</th>
      </tr>
      <c:forEach items="${cashrecordList}" var="d">
        <tr>
          <td>${d.userName }</td>
          <td>${d.bankName}</td>
          <td>${d.gradeName }</td>
		  <td>${d.cashdate}</td>
		  <td>${d.paymoney}</td>
		  <td>${d.Incommoney}</td>
		  <td>
			  <c:if test="${d.status==0}">未审核</c:if>
			  <c:if test="${d.status==1}">已审核</c:if>
			  <c:if test="${d.status==2}">审核未通过</c:if>
			  <c:if test="${d.status==2}">已付款</c:if>
		  </td>
		  <td>${d.reason}</td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="<%=basePath%>cashrecordServlet?action=audit&payrecordid=${d.payrecordid }"><span class="icon-edit">
          </span> 审核</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>cashrecordServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>cashrecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>cashrecordServlet?action=list&currentPage=${pager.currentPage}&opr=next">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
	</body>
</html>