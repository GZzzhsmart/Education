<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增管理员资料</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.managerAccount.value==""){
    			alert("请输入登录账号");
    			form1.managerAccount.focus();
    			return false;
    		}
    		if(form1.managerPassword.value==""){
    			alert("请输入登录密码");
    			form1.managerPassword.focus();
    			return false;
    		}
    		if(form1.managerPassword.value!=form1.managerPassword1.value){
    			alert("登录密码与确认密码不一致");
    			form1.managerPassword1.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 注册管理员资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>managerServlet?action=add" method="post" >
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">登录账号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="managerAccount" size="50" placeholder="请输入登录账号" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">登录密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="managerPassword" size="50" placeholder="请输入登录密码"  />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="managerPassword1" size="50" placeholder="请再次输入密码" data-validate="required:请再次输入密码,repeat#newpass:两次输入的密码不一致" />          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">管理员姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="managerName" size="50" placeholder="请输入管理员姓名"  />          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
         	<input type="radio" name="sex" value="0" checked="checked">男
			<input type="radio" name="sex" value="1">女      
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系电话：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="contact" size="50" placeholder="请输入联系电话"  />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 注册</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
