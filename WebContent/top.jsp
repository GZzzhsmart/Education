<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.ManagerVo"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="css/style.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript">
		function exit(){
			top.location.href="Login1.jsp";
		}
	</script>
</head>
<body leftmargin="0" topmargin="0"  marginwidth="0" marginheight="0">
	<%
		ManagerVo manager = (ManagerVo)session.getAttribute("manager");
	 %>
	<div class="header">
		<div class="topleft">
		 <a href="" target="_parent">
			<div class="title" >
				<h1><font color="white">后台管理中心</font></h1>
			</div>
		</a>
		</div>
		<div class="topright">
		 <li><span><img src="images/peo.png"></span><a href="<%=basePath%>managerServlet?action=updatewo&managerid=<%= manager.getManagerId()%>" target="rightFrame"><%=manager.getManagerAccount() %></a></li>
		 <li><span><img src="images/Set.png"></span><a href="<%=basePath%>jsp/modifyPwd3.jsp?managerId=<%=manager.getManagerId() %>" target="rightFrame">修改密码</a></li>
		 <li><span><img src="images/exit.png"></span><a href="${pageContext.request.contextPath}/Login.jsp" onclick="exit();">退出</a></li>
		</div>
	</div>
</body>
</html>