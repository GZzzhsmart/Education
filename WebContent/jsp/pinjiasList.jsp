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
    
    <title>用户课程评价表</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	
	<style type="text/css">

*{margin:0;padding:0;list-style-type:none;}
a,img{border:0;}
body{font:12px/180% Arial, Helvetica, sans-serif, "新宋体";}
.demo{width:560px; margin:60px auto 10px auto}
.wrap{margin:30px 0}
.wrap p{padding:10px 0}
</style>
  </head>
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 用户评价</strong></div>
  <div class="body-content">
    <form name="form1" method="post" class="form-x" action="${pageContext.request.contextPath }/Course?action=pinadd" method="post" >
      <input type="hidden" name="userid" value="${userid}"/>
       <input type="hidden" name="courseid" value="${courseid}"/>
       <input type="hidden" name="username" value="${yonname}"/>
       
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户名称：</label>
        </div>
        <div class="field">
        	&nbsp;
          ${yonname}
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">课程名称：</label>
        </div>
        <div class="field">
        	&nbsp;
        	${coursename}
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">评价等级：</label>
        </div>
       <div   class="field">
        		<input type="radio" name="evallevel" value="1" checked="checked">好评
				<input type="radio" name="evallevel" value="2">中评
				<input type="radio" name="evallevel" value="3">差评 
       </div>
      </div>      
       <div class="form-group">
        <div class="label">
          <label for="sitename">评价内容：</label>
        </div>
        <div class="field">
        </div>
        	<td colspan="2">
				<textarea  name="evalcontent" style="height:140px;width:600px"></textarea>
			</td>
      </div>      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">	
          <button class="button bg-main icon-check-square-o" type="submit"> 评价</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
