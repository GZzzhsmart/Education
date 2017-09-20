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
	<title>新闻资讯</title>
	 <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	<jsp:include page="/IncludeJS.jsp"></jsp:include>
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
    
    <table class="table table-hover text-center">
      <tr>
        <th align="center">讲师头像</th>
		<th align="center">学历</th>
		<th align="center">教龄</th>
		<th align="center">开户银行</th>
		<th align="center">开户人</th>
		<th align="center">账号</th>
		<th align="center">讲师等级</th>
		<th align="center">审核状态</th>
		<th align="center">操作</th>
      </tr>
    
      <c:forEach items="${teacherList}" var="d">
        <tr>
        <td><img src="${pageContext.request.contextPath }/${d.headpictureUrl}" height="50"/></td>
		<td>${d.education}</td>
		<td>${d.teacherLength}</td>
		<td>${d.bankName }</td>
		<td>${d.accountName}</td>
		<td>${d.accountNo}</td>
		<td>${d.gradeName}</td>
		<td>
		<c:if test="${d.status==0}">未审核</c:if>
		<c:if test="${d.status==1}">审核通过</c:if>
		<c:if test="${d.status==2}">审核未通过</c:if>
		<c:if test="${d.status==3}">封号</c:if>
		</td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="${pageContext.request.contextPath }/teacherServlet?action=audit&teacherId=${d.userid}"><span class="icon-edit">
          </span> 审核</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>teacherServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
        <span class="current">1</span>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>teacherServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>teacherServlet?action=list&currentPage=${pager.currentPage}&opr=next">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
  </div>
</form>
	</body>
</html>
