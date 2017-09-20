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
    
    <title>新增城市资料</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.cityName.value==""){
    			alert("请输入城市名称");
    			form1.cityName.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 新增城市资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>cityServlet?action=add" method="post" >
      <div class="form-group">
        <div class="label">
          <label for="sitename">省份名称：</label>
        </div>
        <div class="field">
         <td>
			<select name="provinceId" style="width:155px">
				<c:forEach items="${provList }" var="d">
					<option value="${ d.provinceId }">${ d.provinceName }</option>
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
          <input type="text" class="input w50" name="cityName" size="50" placeholder="请输入城市名称"  />         
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
