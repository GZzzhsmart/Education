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
    
    <title>查看管理员资料</title>
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
    		if(form1.managerName.value==""){
    			alert("请输入登录姓名");
    			form1.managerName.focus();
    			return false;
    		}
    		if(contact.length!=11){
    			alert("请输入11位数字的电话号码");
    			form1.contact.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
  	
    <div class="contact">
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 查看个人资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>managerServlet?action=updateSave" method="post" >
     <input type="hidden" name="managerId" value="${manager.managerId}">
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">登录账号：</label>
        </div>
        <div class="field">
          	<td>
				<input type="text" class="input w50" id="mpass" name="managerAccount" size="50" value="${manager.managerAccount}" /> 
			</td>       
        </div>
      </div>      
       <div class="form-group">
        <div class="label">
          <label for="sitename">管理员姓名：</label>
        </div>
        <div class="field">
          	<td>
				<input type="text" class="input w50" name="managerName" size="50" value="${manager.managerName}"  /> 
			</td>          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
         	<td>
				<c:if test="${manager.sex==0}">
				<input type="radio" name="sex" value="0" checked="checked">男
				<input type="radio" name="sex" value="1">女
			</c:if>
			<c:if test="${manager.sex==1}">
				<input type="radio" name="sex" value="0">男
				<input type="radio" name="sex" value="1"  checked="checked">女
			</c:if>  
			</td>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">联系电话：</label>
        </div>
        <div class="field">
          	<td>
          		<input type="text" class="input w50" name="contact" size="50" value="${manager.contact}" /> 
          	</td>          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
