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
    
    <title>用户资料列表</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
  </head>
  
  <body>
	<c:if test="${msg!=null}">
   		<script type="text/javascript">
   			alert("${msg}");
   		</script>
    </c:if>
    <form method="post" action="" id="listform">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="<%=basePath%>usersServlet?action=init"> 添加内容</a> </li>
        <li>
          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          <a href="javascript:void(0)" class="button border-main icon-search" onclick="changesearch()" > 搜索</a></li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">用户id</th>
        <th>姓名</th>
   		<th>手机号码</th>
   		<th>性别</th>
   		<th>省份</th>
   		<th>城市</th>
   		<th>用户类别</th>
   		<th>邮箱地址</th>
   		<th>注册日期</th>
   		<th>家庭地址</th>
        <th width="10%">余额</th>
        <th width="310">操作</th>
      </tr>
      <c:forEach items="${userList}" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;">${d.userid }</td>
          <td>${d.userName }</td>
          <td width="10%">${d.mobile }</td>
          <td>
          	<c:if test="${d.sex==0}">男</c:if>
			<c:if test="${d.sex==1}">女</c:if>
          </td>
          <td>${d.provinceName }</td>
          <td>${d.cityName }</td>
		<td>
			<c:if test="${d.userType==1}">学生</c:if>
			<c:if test="${d.userType==2}">讲师</c:if>
		</td>
	         <td>${d.email }</td>
			<td>${d.registerDate }</td>
			<td>${d.homeAddress }</td>
			<td>${d.remainMoney }</td>
        
          <td>
          <div class="button-group"> 
          <a class="button border-red" href="<%=basePath%>usersServlet?action=del&userid=${d.userid }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"><span class="icon-trash-o">
          </span> 删除</a> 
          <a class="button border-main" href="<%=basePath%>usersServlet?action=initpwd&userid=${d.userid }"><span class="icon-edit">
          </span> 初始化密码</a>
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>usersServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>usersServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>usersServlet?action=list&currentPage=${pager.currentPage}&opr=next">尾页</a> 
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
