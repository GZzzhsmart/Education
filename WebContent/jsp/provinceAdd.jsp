<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新增省份资料</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.provinceName.value==""){
    			alert("请输入省份名称");
    			form1.provinceName.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  <body>
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 新增省份资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>provinceServlet?action=add" method="post" >
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">省份名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="provinceName" size="50" placeholder="请输入省份名称" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 新增</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
