<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>充值记录</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.paymoney.value==""){
    			alert("请输入充值金额");
    			form1.paymoney.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  <body>
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 充值记录</strong></div>
  <div class="body-content">
    <form name="form1" method="post" class="form-x" action="<%=basePath%>moneyrecordServlet?action=add" method="post" >
      <input type="hidden" name="recordid" value="${moneyrecord.recordid }"/>
      <div class="form-group">
        <div class="label">
          <label for="sitename">用户id：</label>
        </div>
        <div class="field">
          	<select name="userid" style="width:155px">
				<c:forEach items="${userList}" var="d">
					<c:if test="${d.userid==moneyrecord.recordid}">
						<option value="${d.userid}" selected="selected">${d.userName}</option>
					</c:if>
					<c:if test="${d.userid != moneyrecord.recordid}">
						<option value="${d.userid}">${d.userName}</option>
					</c:if>
				</c:forEach>
			</select>     
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">充值金额：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="paymoney" size="50" placeholder="请输入充值金额"  />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 充值</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  </body>
</html>
