<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <title>教师界面修改</title>
	 <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
  </head>
  
  <body>
  	 <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改管理员资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>teacherServlet?action=updateSave" method="post" enctype="multipart/data-form">
     <input type="hidden" name="userid" value="${teacher.userid}">
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师简介：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="mpass" name="teacherIntroduce" size="50"value="${ teacher.teacherIntroduce }"/>       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师特长：</label>
        </div>
        <div class="field">
          	<td>
 				<input type="text" class="input w50" name="teacherSpecial" size="50" value="${ teacher.teacherSpecial }" /> 
			</td>	
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">教龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="teacherLength" size="50" value="${ teacher.teacherLength }" />          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">学历：</label>
        </div>
        <div class="field">
           		<td>
 					<c:if test="${ teacher.education==1 }"><font color="red"><b>小学</b></font></c:if>
		  			<c:if test="${ teacher.education==2 }"><font color="red"><b>初中</b></font></c:if>
		  			<c:if test="${ teacher.education==3 }"><font color="red"><b>高中</b></font></c:if>
		  			<c:if test="${ teacher.education==4 }"><font color="red"><b>本科</b></font></c:if>
		  			<c:if test="${ teacher.education==5 }"><font color="red"><b>专科</b></font></c:if>
		  			<c:if test="${ teacher.education==6 }"><font color="red"><b>博士</b></font></c:if>
  					<select name="education" style="width:100px">
  						<option value="小学">小学</option>
  						<option value="初中">初中</option>
  						<option value="高中">高中</option>
  						<option value="本科">本科</option>
  						<option value="专科">专科</option>
  						<option value="博士">博士</option>
  					</select>
  				</td>		          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">头像上传地址：</label>
        </div>
        <div class="field">
         	<input type="file" name="file1"/>        
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">银行id：</label>
        </div>
        <div class="field">
          		<td>
  						<c:if test="${ teacher.bankId==1 }"><font color="red"><b>中国银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==2 }"><font color="red"><b>中国农业银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==3 }"><font color="red"><b>中国建设银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==4 }"><font color="red"><b>中国工商银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==5 }"><font color="red"><b>九江银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==6 }"><font color="red"><b>交通银行</b></font></c:if>
			  			<c:if test="${ teacher.bankId==7 }"><font color="red"><b>中国邮政储蓄银行</b></font></c:if>
  					<select name="bankId" style="width:100px">
  						<option value="1">中国银行</option>
  						<option value="2">中国农业银行</option>
  						<option value="3">中国建设银行</option>
  						<option value="4">中国工商银行</option>
  						<option value="5">九江银行</option>
  						<option value="6">交通银行</option>
  						<option value="7">中国邮政储蓄银行</option>
  					</select>
  				</td>	         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">银行账户：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="accountNo" size="50" value="${ teacher.accountNo }" />        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">开户人：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="accountName" size="50" value="${ teacher.accountName }" />        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师分类：</label>
        </div>
        <div class="field">
         	<td>
  						<c:if test="${ TeacherVo.gradeId==1 }"><font color="red"><b>认证讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==2 }"><font color="red"><b>中级讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==3 }"><font color="red"><b>高级讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==4 }"><font color="red"><b>特级讲师</b></font></c:if>
			  			<c:if test="${ TeacherVo.gradeId==5 }"><font color="red"><b>金牌讲师</b></font></c:if>
  					<select name="gradeId" style="width:100px">
  						<option value="1">认证讲师</option>
  						<option value="2">中级讲师</option>
  						<option value="3">高级讲师</option>
  						<option value="4">特级讲师</option>
  						<option value="5">金牌讲师</option>
  					</select>
  				</td>	        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">状态：</label>
        </div>
        <div class="field">
         	<td>
  					<c:if test="${ teacher.status==0 }" >
  						<input type="radio" checked="checked" name="sex" value="0">未审核
  						<input type="radio" name="status"  value="1">已审核
  						<input type="radio" name="status"  value="2">审核未通过
  						<input type="radio" name="status"  value="3">封号
  					</c:if>
  					<c:if test="${ teacher.status==1 }">
  						<input type="radio" checked="checked" name="sex"  value="1">已审核
  						<input type="radio" name="status"  value="0">未审核
  						<input type="radio" name="status"  value="2">审核未通过
  						<input type="radio" name="status"  value="3">封号
  					</c:if>
  					<c:if test="${ teacher.status==2 }" >
  						<input type="radio" checked="checked" name="sex" value="2">审核未通过
  						<input type="radio" name="status"  value="0">未审核
  						<input type="radio" name="status"  value="1">已审核
  						<input type="radio" name="status"  value="3">封号
  						
  					</c:if>
  					<c:if test="${ teacher.status==3 }">
  						<input type="radio" checked="checked" name="sex"  value="3">封号
  						<input type="radio" name="status"  value="0">未审核
  						<input type="radio" name="status"  value="1">已审核
  						<input type="radio" name="status"  value="2">审核未通过
  					</c:if>
  				</td>	      
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">未通过原因：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="reason" size="50" value="${ teacher.reason }" />        
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
