<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册银行资料</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.bankname.value==""){
    			alert("请输入银行名称");
    			form1.bankname.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 注册银行资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>bankServlet?action=add" method="post" >
       <div class="form-group">
        <div class="label">
          <label for="sitename">银行名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="bankname" size="50" placeholder="请输入银行名称"  />  
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 添加</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
</body>
</html>
