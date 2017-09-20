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
    
    <title>修改讲师等级资料</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
     <script type="text/javascript">
    	function check(){
    		if(form1.gradeName.value==""){
    			alert("请输入讲师等级名称");
    			form1.gradeName.focus();
    			return false;
    		}
    		if(form1.gradePercent.value==""){
    			alert("请输入提成比例，在0~1之间的数字");
    			form1.gradePercent.focus();
    			return false;
    		}
    		if(isNaN(form1.gradePercent.value)){
    			alert("提成比例含有非法字符，请输入0~1之间的数字");
    			form1.gradePercent.focus();
    			return false;
    		}
    		var percent = form1.gradePercent.value;
    		if(parseFloat(percent)<0 || parseFloat(percent)>1){
    			alert("提成比例必须是0~1之间的小数");
    			form1.gradePercent.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改讲师等级资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>gradeServlet?action=updateSave" method="post" >
     <input type="hidden" name="gradeId" value="${grade.gradeId}">
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">讲师名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="gradeName" size="50" value="${grade.gradeName}" />       
        </div>
      </div>      
       <div class="form-group">
        <div class="label">
          <label for="sitename">提成比例：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="gradePercent" size="50" value="${grade.gradePercent}"  />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 修改</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
