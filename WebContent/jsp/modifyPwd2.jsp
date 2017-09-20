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
    
    <title>修改密码</title>
    <link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery2.js"></script>
<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.oldpwd.value==""){
    			alert("请输入旧密码");
    			form1.oldpwd.focus();
    			return false;
    		}
    		if(form1.newPassword.value==""){
    			alert("请输入新密码");
    			form1.newPassword.focus();
    			return false;
    		}
    		if(form1.newPassword.value != form1.cfgpwd.value){
    			alert("新密码与确认密码不一致,请重新输入");
    			form1.cfgpwd.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>teacherServlet?action=modifyPwd2" method="post" >
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="oldpwd" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newPassword" size="50" placeholder="请输入新密码"  />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="cfgpwd" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
