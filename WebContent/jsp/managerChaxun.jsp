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
   
    <title>管理员列表</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
		<script type="text/javascript">
			function chh(){
				var  sou=listform.keywords.value;
			}
		</script>
  </head>
  <body>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="<%=basePath%>jsp/managerAdd.jsp"> 添加内容</a> </li>
        <li>
          
          <form name="hf" action="<%=basePath %>managerServlet?action=shousuo" method="post">
          	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          	<input type="submit" class="button border-main icon-search" value=" 搜 索 ">
         	<a href="<%=basePath %>managerServlet?action=list" class="button border-main icon-search"> 首 页 </a>
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="10%">管理员编号</th>
        <th>登录账号</th>
        <th>管理员姓名</th>
        <th>性别</th>
        <th>联系电话</th>
        <th width="10%">状态</th>
        <th width="310">操作</th>
      </tr>
      <c:forEach items="${managerList}" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;">${d.managerId }</td>
          <td>${d.managerAccount }</td>
          <td width="10%">${d.managerName }</td>
          <td>
          	<c:if test="${d.sex==0}">男</c:if>
			<c:if test="${d.sex==1}">女</c:if>
          </td>
          <td>${d.contact }</td>
          <td>
          	<c:if test="${d.status==1}">启用</c:if>
			<c:if test="${d.status==0}">禁用</c:if>
          </td>
        
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="<%=basePath%>managerServlet?action=chakan&managerId=${d.managerId }"><span class="icon-edit">
          </span> 查看资料</a> 
          <a class="button border-red" href="<%=basePath%>managerServlet?action=del&managerId=${d.managerId }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"><span class="icon-trash-o">
          </span> 删除</a> 
          <a class="button border-main" href="<%=basePath%>managerServlet?action=initpwd&managerId=${d.managerId }"><span class="icon-edit">
          </span> 初始化密码</a>
          <c:if test="${d.status==1}">
          <a class="button border-red" href="<%=basePath%>managerServlet?action=status&status=0&managerId=${d.managerId }"><span class="icon-trash-o"></span>禁用</a>
          </c:if>
           <c:if test="${d.status==0}">
          	<a class="button border-red" href="<%=basePath%>managerServlet?action=status&status=1&managerId=${d.managerId }"><span class="icon-trash-o"></span>禁用</a>
          	</c:if>
          </div>
          </td>
        </tr>
   	</c:forEach>
    </table>
  </div>
<script type="text/javascript">
</script>
       </body>
</html>