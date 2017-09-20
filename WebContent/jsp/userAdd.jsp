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
    
    <title>注册学生界面</title>
       <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/pintuer.js"></script>
	<script src="js/jquery2.js"></script>
    <script type="text/javascript">
    	var mobile = document.getElementById("mobile").value;
    	var password = document.getElementById("password").value;
    	var cfgpwd = document.getElementById("cfgpwd").value;
    	function check(){
    		if(form1.mobile.value==""){
    			alert("请输入手机号码。");
    			form1.mobile.focus();
    			return false;
    		}
    		if(form1.password.value==""){
    			alert("请输入登录密码。");
    			form1.password.focus();
    			return false;
    		}
    		if(form1.password.value!=form1.cfgpwd.value){
    			alert("登录密码与确认密码不一致。");
    			form1.cfgpwd.focus();
    			return false;
    		}
    		return true;
    	}
    	function changeProv(provinceId){
    		location.href="<%=basePath%>usersServlet?action=init&provinceId="+provinceId;
    	}
    </script>
  </head>
  
  <body background="img/2.jpg">
   <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 注册学生资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>usersServlet?action=add" method="post" >
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">省份名称：</label>
        </div>
        <div class="field">
          	<td>
				<select name="provinceId" style="width:155px" onchange="changeProv(this.value);">
					<c:forEach items="${provList}" var="d">
						<c:if test="${d.provinceId == provinceId}">
							<option value="${d.provinceId}" selected="selected">${d.provinceName}</option>
						</c:if>
						<c:if test="${d.provinceId != provinceId}">
							<option value="${d.provinceId}">${d.provinceName}</option>
						</c:if>
					</c:forEach>
				</select>
			</td>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">城市名称：</label>
        </div>
        <div class="field">
          	<td>
				<select name="cityId" style="width:155px">
					<c:forEach items="${cityList}" var="d">
						<option value="${d.cityId}">${d.cityName}</option>
					</c:forEach>
				</select>
			</td>         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">手机号码：</label>
        </div>
        <div class="field">
          <input type="password" id="mobile" class="input w50" name="mobile" size="50" placeholder="请输入手机号码"  />          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">登录密码：</label>
        </div>
        <div class="field">
          <input type="password" id="password" class="input w50" name="password" size="50" placeholder="请输入登录密码"  />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认密码：</label>
        </div>
        <div class="field">
          <input type="password" id="cfgpwd" class="input w50" name="cfgpwd" size="50" placeholder="请再次输入密码" data-validate="required:请再次输入密码,repeat#password:两次输入的密码不一致"  />          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">真实姓名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="userName" size="50" placeholder="请输入真实姓名"  />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
          	<td>
				<input type="radio" name="sex" value="0" checked="checked">男
				<input type="radio" name="sex" value="1">女
			</td>          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">家庭地址：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="homeAddress" size="50" placeholder="请输入家庭住址"  />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">电子邮件：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="email" size="50" placeholder="请输入邮件地址"  />          
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
