<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>充值中心</title>
	<link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
  </head>
  
  <body>
    <div class="panel admin-panel">
  <div class="panel-head"><strong>&ldquo;<span class="icon-key"></span> 充值中心</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath %>moneyRecordServlet?action=chongzhi"/>
    <%
    		String uu=request.getParameter("moey");
    		String hh=request.getParameter("chonid");
    		String userid =request.getParameter("userid");
     %>
     	<input type="hidden" name="userid" value="<%=userid%>">
    	<input type="hidden" name="moey" value="<%=uu%>">
    	<input type="hidden"  name="chonid" value="<%=hh%>">
      <div class="form-group">
        <div class="label">
          <label for="sitename">充值金额/元：</label>
        </div>
        <div class="field">
          	<td>
				<input type="text" class="input w50" name="xmoney" size="50" placeholder="请输入充值金额"  /> 
			</td>
        </div>
      </div>
      </div>
        <div class="field">
        &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
         &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
          <button class="button bg-main icon-check-square-o" type="submit"> 充值</button>   
        </div>
      </div>      
  </body>
</html>
