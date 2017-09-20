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
         
          </form>
      </ul>
    </div>
     <table class="table table-hover text-center">
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
        <th width="310">操作</th>
      </tr>
    
      <c:forEach items="${newMsgList}" var="d">
        <tr>
          <td style="text-align:left; padding-left:20px;"><img src="http://localhost:8080/education/${ d.imageUrl }"></td>
         <td>${ d.msgName }</td>
    	 <td>${ d.oneWord }</td>
         <td>
          	<a href="${ pageContext.request.contextPath}/${ d.msgContentUrl }"  target="_blank"
    		onclick="javascript:void(0); ">预览</a>
          </td>
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
    		 <td>${d.seq }</td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="<%=basePath%>newsMsgServlet?action=update&newsid=${ d.newMsgId }"><span class="icon-edit">
          </span> 修改</a> 
          <a class="button border-red" href="<%=basePath%>newsMsgServlet?action=delete&newsid=${ d.newMsgId }" onclick="javascript:if(confirm('删除确认')){return true;}else{return false;}"><span class="icon-trash-o">
          </span> 删除</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
      <tr>
        <td colspan="8"><div class="pagelist"> 
        <a href="<%=basePath%>newsMsgServlet?action=list&currentPage=${pager.currentPage}&opr=piror">上一页</a> 
         <a href="<%=basePath%>newsMsgServlet?action=list&currentPage=1&opr=first">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="<%=basePath%>newsMsgServlet?action=list&currentPage=${pager.currentPage}&opr=next">下一页</a>
        <a href="<%=basePath%>newsMsgServlet?action=list&currentPage=${pager.pageCount}&opr=last">尾页</a> 
        </div>
        </td>
      </tr>
    </table>
  </div>

<script type="text/javascript">

</script>
  </body>
</html>
