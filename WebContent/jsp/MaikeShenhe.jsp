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
    
    <title>My JSP 'MaikeShenhe.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		
  		<h3 align="center"><font color="red">提现审核</font></h3>
    <form name="form1" action="${pageContext.request.contextPath}/payrecordServlet?action=tixian" method="post" onsubmit="return check();">
    	<input type="hidden" name="fumoney" value="${course.paymoney}"/>
    	<input type="hidden" name="youmoney" value="${course.discountmoney}"/>
    	<input type="hidden" name="userid" value="${course.userid}"/>
    	<input type="hidden" name="courseid" value="${course.courseid}"/>
    	<table align="center" border="1" cellpadding="1" cellspacing="1" width="800">
		<tr height="40">
			<td align="right">课程ID：</td>
			<td>${course.courseid}</td>
		</tr>
		<tr height="40">
			<td align="right">是否缴费：</td>
			<td>
				<c:if test="${course.payorreturn==0}">
					缴费
				</c:if>
				<c:if test="${course.payorreturn==1}">
					退费
				</c:if>
			</td>
		</tr>
		<tr height="40">
			<td align="right">付款时间：</td>
			<td>
				${ course.paydate }
			</td>
		</tr>
		<tr height="40">
			<td align="right">付款金额：</td>
			<td>${course.paymoney }</td>
		</tr>
		<tr height="40" colspan="2">
			<td align="right">优惠券金额：</td>
			<td>${course.discountmoney}</td>
		</tr>
		<tr>
			<td align="right">付款方式：</td>
			<td>
					${course.cardnum }
			</td>
		</tr>
		
		<tr height="40" colspan="2">
			<td align="right">付款人：</td>
			<td>${course.payer}</td>
		</tr>
		
		<tr height="40" colspan="2">
			<td align="right">订单号：</td>
			<td>${course.ordernumber}</td>
		</tr>
		
		<tr height="40" colspan="2">
			<td align="right">缴费状态：</td>
			<td>
				<c:if test="${course.paystatus==0}">
					未付
				</c:if>
				<c:if test="${course.paystatus==1}">
					已付
				</c:if>
				
			</td>
		</tr>
		
		<tr height="40">
			<td align="right">审核：</td>
			<td>
			<select name="status" style="width:200px">
				<c:if test="${course.status==0}">
					<option value="0" selected="selected">未审核</option>
					<option value="1">已审核</option>
					<option value="2">审核未通过</option>
				</c:if>
				<c:if test="${course.status==1}">
				
					
					<option value="1" selected="selected">已审核</option>
					<option value="0">未审核</option>
					<option value="2">审核未通过</option>
				</c:if>
				
				<c:if test="${course.status==2}">
				
					
					<option value="2" selected="selected">审核未通过</option>
					<option value="0">未审核</option>
					<option value="1">已审核</option>
				</c:if>
				
				
			</select>
			</td>
		</tr>
		
		<tr height="40" colspan="2">
			<td align="right">未通过原因：</td>
			<td>
				<textarea name="reason" style="width:580px;height:50px"></textarea>
			</td>
		</tr>
		<tr height="40">
			<td colspan="3" align="center"><input type="submit" value=" 提 现 "></td>
		</tr>
	</table>
    </form>
  		
  		
  </body>
</html>
