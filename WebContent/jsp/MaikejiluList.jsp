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
   
    <title>提现审核</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
	
		<script type="text/javascript">
			function chh(){
				var  sou=listform.keywords.value;
			}
		</script>
	
  </head>
  
  <body>
   
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 提现审核</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
 		<th>买课用户</th>
   		<th>是否缴费</th>
   		<th>付款金额</th>
   		<th>优惠券金额</th>
   		<th>是否提现</th>
   		<th>操作</th>
    </tr>
      <c:forEach items="${jilu}" var="d">
        <tr>
        
          <td style="text-align:left; padding-left:20px;">${d.payer }</td>
          <td>
  			<c:if test="${d.payorreturn==0}">缴费</c:if>
	      </td>
	      <td>${d.paymoney }</td>
	      <td>${d.discountmoney }</td>
          <td>
          	<c:if test="${d.isCash==0 }">未提现</c:if>
	    	<c:if test="${d.isCash==1 }">已提现</c:if>
          </td>
          <td>
          <div class="button-group"> 
          <a class="button border-main" href="${pageContext.request.contextPath }/payrecordServlet?action=shenqin&payid=${d.payrecordid}"><span class="icon-edit">
          </span> 申请提现</a> 
          </div>
          </td>
        </tr>
   	</c:forEach>
    </table>
  </div>

<script type="text/javascript">

</script>
       </body>
</html>