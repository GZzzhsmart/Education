<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册教师资料</title>
     <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function check(){
    		if(form1.teacherPassword.value==""){
    			alert("请输入教师密码");
    			form1.teacherPassword.focus();
    			return false;
    		}
    		if(form1.teacherName.value==""){
    			alert("请输入教师姓名");
    			form1.teacherName.focus();
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  <table class="tablelist2">   	
	        <tbody>     
			<tr>
	        <td class="tableselect2" style="border-bottom:none;">
			 <div class="tools">
			  <ul class="toolbar">
			    <li class="click"><a href="${pageContext.request.contextPath }/web/webCenter.jsp"><i></i>返回</a></li>
			  </ul>
			 </div>
			</td>
	        </tr>        
	        </tbody>
		</table>
  <body background="img/3.jpg">
     <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 注册教师资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>teacherServlet?action=add" method="post" enctype="multipart/data-form">
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师简介：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="teacherIntroduce" name="teacherIntroduce" size="50" placeholder="请输入教师简介" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师特长：</label>
        </div>
        <div class="field">
  				<td>
  					<input type="text" class="input w50" name="teacherSpecial" size="50" placeholder="请输入特长"  />
  				</td>	
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">教龄：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" name="teacherLength" size="50" placeholder="请输入教龄"  />          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">学历：</label>
        </div>
        <div class="field">
           	<td>
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
         	<input type="file"name="file1"  />        
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">银行id：</label>
        </div>
        <div class="field">
          		<td>
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
         	<input type="text" class="input w50" name="accountNo" size="50" placeholder="请输入银行账户" />        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">开户人：</label>
        </div>
        <div class="field">
         	<input type="text" class="input w50" name="accountName" size="50" placeholder="请输入开户人" />        
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">教师分类：</label>
        </div>
        <div class="field">
         	<td>
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
