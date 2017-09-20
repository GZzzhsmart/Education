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
    <title>申请提现</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  </head>
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 申请提现</strong></div>
  <div class="body-content">
    <form name="form1" method="post" class="form-x" action="${pageContext.request.contextPath }/cashrecordServlet?action=add" method="post" >
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户名称：</label>
        </div>
        <div class="field">
        	&nbsp;
          ${users.userName}
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">课程名称：</label>
        </div>
        <div class="field">
        	&nbsp;
        	${course.coursename}
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">提现银行：</label>
        </div>
        <div class="field">
        	&nbsp;
        	${bank.bankname}
        </div>
      </div>
        <div class="form-group">
        <div class="label">
          <label for="sitename">讲师级别：</label>
        </div>
        <div class="field">
        	&nbsp;
        	${grade.gradeName}
        </div>
      </div>   
       <div class="form-group">
        <div class="label">
          <label for="sitename">提现金额：</label>
        </div>
        <div class="field">
        </div>
        	&nbsp;
        	${user.remainMoney}
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">平台收入：</label>
        </div>
        <div class="field">
        </div>
        	&nbsp;
        	${cashrecord.remainMoney}
      </div>   
      
         
      <div class="form-group">
        <div class="label">
          <label for="sitename">平台收入金额：</label>
        </div>
        <div class="field">
        </div>
        	&nbsp;
        	${paymoney}
      </div>      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">	
          <button class="button bg-main icon-check-square-o" type="submit"> 提现</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
