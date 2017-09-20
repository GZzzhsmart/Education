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
    
    <title>新闻资讯</title>
    <jsp:include page="/IncludeJS.jsp"></jsp:include>
	
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
    <div class="panel-head"><strong class="icon-reorder"> 新闻资讯列表</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="<%=basePath %>jsp/newsMsgAdd.jsp"> 添加内容</a> </li>
        <li>
          <form name="hf" action="<%=basePath %>newsMsgServlet?action=shousuo" method="post">
          	<input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style="width:250px; line-height:17px;display:inline-block" />
          	<input type="submit" class="button border-main icon-search" value=" 搜 索 ">
          	<a href="<%=basePath %>newsMsgServlet?action=list" class="button border-main icon-search"> 首 页 </a>
          </form>
      </ul>
    </div>
    <table align="center" border="0" cellspacing="1" cellpadding="1" width="100%">
    	<thead>
    		<tr>
    			<th align="center">图标</th>
				<th align="center">新闻名称</th>
				<th align="center">一句话</th>
				<th align="center">预览</th>
				<th align="center">发布人</th>
				<th align="center">发布时间</th>
				<th align="center">类别</th>
				<th align="center">状态</th>
				<th align="center">排序</th>
				<th align="center">操作</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:forEach items="${ newsMsgList }" var="d">
    			<tr>
    				<td><img src="http://localhost:8080/education/${ d.imageUrl }"></td>
    				<td>${ d.msgName }</td>
    				<td>${ d.oneWord }</td>
    				<td><a href="${ pageContext.request.contextPath}/${ d.msgContentUrl }"  target="_blank"
    				 onclick="javascript:void(0); ">预览</a></td>
    				 <td>${ d.publishUsername }</td>
    				 <td>${ d.publishDate  }</td>
    				 <td>
    				 	<c:if test="${ d.newsType==0 }">通告</c:if>
    				 	<c:if test="${ d.newsType==1 }">公告</c:if>
    				 </td>
    				 <td>
    				 	<c:if test="${ d.effective==0 }">无效</c:if>
    				 	<c:if test="${ d.effective==1 }">有效</c:if>
    				 </td>
    				 <td>
    				 	${ d.seq }
    				 </td>
    				 <td>
    				 	<a href="<%=basePath %>/newsMsgServlet?action=update&newsid=${ d.newMsgId }">修改</a>
    				 	<a href="<%=basePath %>/newsMsgServlet?action=delete&newsid=${ d.newMsgId }"  onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}">删除</a>
    				 </td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
    
   
    
    
  </body>
</html>
