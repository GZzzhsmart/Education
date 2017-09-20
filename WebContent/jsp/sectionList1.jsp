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
   
    <title>课程节表</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
	
  </head>
  
  <body>
   
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 内容列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li>
          <form name="hf" action="" method="post">
          	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          	<input type="submit" class="button border-main icon-search" value=" 搜 索 ">
         
          </form>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="200">章节名称</th>
		<th width="300">视频地址</th>
		<th>是否免费</th>
		<th>审核状态</th>
		<th>操作</th>
      </tr>
    
      <c:forEach items="${sectionList}" var="d">
        <tr>
        
          <td width="150px">${d.sectionname }</td>
          <td>${d.sectionurl }</td>
			<td>
				<c:if test="${d.free==0}">免费</c:if>
				<c:if test="${d.free==1}">收费</c:if>
			</td>
			<td>
				<c:if test="${d.status==0}">未审核</c:if>
				<c:if test="${d.status==1}">已审核</c:if>
				<c:if test="${d.status==2}">审核未通过</c:if>
			</td>
          <td>
          <div class="button-group"> 
          <a class="button border-red" href="${pageContext.request.contextPath }/sectionServlet?action=audit&sectionid=${d.sectionid}" "><span class="icon-trash-o">
          </span> 审核</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="${pageContext.request.contextPath }/sectionServlet?action=list1&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="${pageContext.request.contextPath }/sectionServlet?action=list1&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="${pageContext.request.contextPath }/sectionServlet?action=list1&currentPage=${pager.currentPage}&opr=next">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
  </div>

<script type="text/javascript">

</script>
       </body>
</html>