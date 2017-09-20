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
   
    <title>银行列表</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
  </head>
  
   <body>
   <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="<%=basePath%>jsp/bankAdd.jsp"> 添加内容</a> </li>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search"  > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th style="text-align:left; padding-left:20px;">银行账号</th>
    	<th>银行名称</th>
        <th width="310">操作</th>
      </tr>
    
      <c:forEach items="${bankList}" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;">${d.bankid }</td>
          <td>${d.bankname }</td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="<%=basePath%>bankServlet?action=update&bankid=${d.bankid }"><span class="icon-edit">
          </span> 修改</a> 
          <a class="button border-red" href="<%=basePath%>bankServlet?action=del&bankid=${d.bankid }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"><span class="icon-trash-o">
          </span> 删除</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>bankServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>bankServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>bankServlet?action=list&currentPage=${pager.currentPage}&opr=next">尾页</a> 
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