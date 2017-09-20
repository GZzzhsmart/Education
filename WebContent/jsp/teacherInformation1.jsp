<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="bean.TeacherVo"%>
<%@page import="base.IBaseDAO"%>
<%@page import="base.BaseDAOImpl"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教师1</title>
	<style type="text/css">
		body{
			font:14px/28px "微软雅黑";
		}
		.contact *:focus{outline :none;}
		.contact{
			width: 700px;
			height: auto;
			background: #f6f6f6;
			margin: 40px auto;
			padding: 10px;
		}
		.contact ul {
			width: 650px;
			margin: 0 auto;
		}
		.contact ul li{
			border-bottom: 1px solid #dfdfdf;
			list-style: none;
			padding: 12px;
		}
		.contact ul li label {
			width: 120px;
			display: inline-block;
			float: left;
		}
		.contact ul li input[type=text],.contact ul li input[type=password]{
			width: 220px;
			height: 25px;
			border :1px solid #aaa;
			padding: 3px 8px;
			border-radius: 5px;
		}
		.contact ul li input:focus{
			border-color: #c00;
			
		}
		.contact ul li input[type=text]{
			transition: padding .25s;
			-o-transition: padding  .25s;
			-moz-transition: padding  .25s;
			-webkit-transition: padding  .25s;
		}
		.contact ul li input[type=password]{
			transition: padding  .25s;
			-o-transition: padding  .25s;
			-moz-transition: padding  .25s;
			-webkit-transition: padding  .25s;
		}
		.contact ul li input:focus{
			padding-right: 70px;
		}
		.btn{
			position: relative;
			left: 300px;
		}
		.tips{
			color: rgba(0, 0, 0, 0.5);
			padding-left: 10px;
		}
		.tips_true,.tips_false{
			padding-left: 10px;
		}
		.tips_true{
			color: green;
		}
		.tips_false{
			color: red;
		}
  </style>
  </head>
  
  <body>
  	<h1 align="center"><font color="#ff3300">讲师资料</font></h1>
  	<div class="contact">
  	<form name="form1" action="teacherServlet?action=updateSave" method="post"> 
  		<input type="hidden" name="teacherId" value="${ teacher.userid }">
  	 	<table align="center" border="0" width="420" cellspacing="1" cellpadding="1">
  			<tr height="40">
  				<td align="right">教师简介：</td>
  				<td>${ teacher.teacherIntroduce }</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教师特长：</td>
  				<td>
  						${ teacher.teacherSpecial }
  				
  						
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">教龄：</td>
  				<td>${ teacher.teacherLength }</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">学历：</td>
  				<td>
  					${ teacher.education }
  				
  				</td>	
  			</tr>
  			<tr height="40">
  				<td align="right">头像上传地址：</td>
  				<td>
  					<img src="${ teacher.headpictureUrl}">
  				</td>	
  			</tr>
  			
  			<tr height="40">
  				<td align="right">教师分类：</td>
  				<td>
  						<c:if test="${ teacher.gradeId==1 }"><font color="red"><b>认证讲师</b></font></c:if>
			  			<c:if test="${ teacher.gradeId==2 }"><font color="red"><b>中级讲师</b></font></c:if>
			  			<c:if test="${ teacher.gradeId==3 }"><font color="red"><b>高级讲师</b></font></c:if>
			  			<c:if test="${ teacher.gradeId==4 }"><font color="red"><b>特级讲师</b></font></c:if>
			  			<c:if test="${ teacher.gradeId==5 }"><font color="red"><b>金牌讲师</b></font></c:if>
  				</td>	
  			</tr>
  			
  		</table>
  	</form>
   	</div>
  </body>
</html>
