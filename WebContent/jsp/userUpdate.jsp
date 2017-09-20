<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改用户资料</title>
    <link rel="stylesheet" href="css/pintuer.css">
	<link rel="stylesheet" href="css/admin.css">
	<script src="js/jquery2.js"></script>
	<script src="js/pintuer.js"></script>
    <script type="text/javascript">
    	function checks(){
    		if(form1.mobile.value==""){
    			alert("请输入手机号码。");
    			form1.mobile.focus();
    			return false;
    		}
    		if(form1.homeAddress.value==""){
    			alert("请输入家庭住址。");
    			form1.homeAddress.focus();
    			return false;
    		}
    		if(form1.userName.value==""){
    			alert("请输入真实姓名");
    			form1.userName.focus();
    			return false;
    		}
    		return true;
    	}
    	function changeProv(provinceId){
    		var mobile = form1.mobile.value;
    		var userName = form1.userName.value;
    		var homeAddress = form1.homeAddress.value;
    		var email = form1.email.value;
    		var provinceId = form1.provinceId.value;
    		var cityId = form1.cityId.value;
    		var sex = form1.sex.value;
    		var money = form1.money.value;
    		location.href="<%=basePath%>usersServlet?action=updateinit&provinceId="+provinceId+"&mobile="+mobile+"&userName="+userName+"&homeAddress="+homeAddress+"&email="+email+"&cityId="+cityId+"&sex="+sex+"&money="+money;
    	}
    	
    </script>
  </head>
  
  <body>
      <div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改用户资料</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath%>usersServlet?action=updateSave" method="post" >
    	<input type="hidden" name="userid" value="${user.userid}">
      <div class="form-group">
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">省份名称：</label>
        </div>
        <div class="field">
          	<td>
				<select name="provinceId" style="width:155px" onchange="changeProv(this.value);">
					<c:if test="${requestScope.tel!=null}">
						<c:forEach items="${provList}" var="d">
							<c:if test="${d.provinceId == provinceId}">
								<option value="${d.provinceId}" selected="selected">${d.provinceName}</option>
							</c:if>
							<c:if test="${d.provinceId !=  provinceId}">
								<option value="${d.provinceId}">${d.provinceName}</option>
							</c:if>
						</c:forEach>
					</c:if>
					<c:if test="${requestScope.tel==null}">
						<c:forEach items="${provincelist}" var="d">
							<c:if test="${d.provinceId == user.provinceId}">
								<option value="${d.provinceId}" selected="selected">${d.provinceName}</option>
							</c:if>
							<c:if test="${d.provinceId !=  user.provinceId}">
								<option value="${d.provinceId}">${d.provinceName}</option>
							</c:if>
						</c:forEach>
					</c:if>
				</select>
			</td>       
        </div>
      </div>      
       <div class="form-group">
        <div class="label">
          <label for="sitename">城市名称：</label>
        </div>
        <div class="field">
          	<td>
				<select name="cityId" style="width:155px" >
					<c:if test="${requestScope.tel!=null}">
						<c:forEach items="${cityList}" var="d">
							<option value="${d.cityId}" selected="selected">${d.cityName}</option>
						</c:forEach>
					</c:if>
					<c:if test="${requestScope.tel==null}">
						<c:forEach items="${citylist}" var="d">
							<c:if test="${d.cityId == user.cityId}">
								<option value="${d.cityId}" selected="selected">${d.cityName}</option>
							</c:if>
							<c:if test="${d.cityId !=  user.cityId}">
								<option value="${d.cityId}">${d.cityName}</option>
							</c:if>
						</c:forEach>
					</c:if>
				</select>
			</td>          
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">手机号码：</label>
        </div>
        <div class="field">
         	<td>
				<c:if test="${requestScope.tel==null}">
					<input type="text" name="mobile" style="width:155px" value="${user.mobile}"/>
				</c:if>
				<c:if test="${requestScope.tel!=null}">
					<input type="text" name="mobile" style="width:155px" value="<%=new String(request.getAttribute("tel").toString().getBytes("iso-8859-1"),"utf-8") %>"/>
				</c:if>
			</td> 
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">真实姓名：</label>
        </div>
        <div class="field">
          	<td>
				<c:if test="${requestScope.name==null}">
					<input type="text" name="userName" style="width:155px" value="${user.userName}"/>
				</c:if>
				<c:if test="${requestScope.name!=null}">
					<input type="text" name="userName" style="width:155px" value="<%=new String(request.getAttribute("name").toString().getBytes("iso-8859-1"),"utf-8") %> "/>
				</c:if>
			</td>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
          	<td>
				<c:if test="${sex==null}">
					<c:if test="${user.sex==0}">
						<input type="radio" name="sex" value="0" checked="checked">男
						<input type="radio" name="sex" value="1">女
					</c:if>
					<c:if test="${user.sex==1}">
						<input type="radio" name="sex" value="0">男
						<input type="radio" name="sex" value="1"  checked="checked">女
					</c:if>
				</c:if>
				<c:if test="${sex!=null}">
					<c:if test="${sex==0}">
						<input type="radio" name="sex" value="0" checked="checked">男
						<input type="radio" name="sex" value="1">女
					</c:if>
					<c:if test="${sex==1}">
						<input type="radio" name="sex" value="0">男
						<input type="radio" name="sex" value="1"  checked="checked">女
					</c:if>
				</c:if>
			</td>     
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label for="sitename">家庭地址：</label>
        </div>
        <div class="field">
          	<td>
				<c:if test="${requestScope.home==null}">
					<input type="text" name="homeAddress" style="width:155px" value="${user.homeAddress}"/>
				</c:if>
				<c:if test="${requestScope.home!=null}">
					<input type="text" name="homeAddress" style="width:155px" value="<%=new String(request.getAttribute("home").toString().getBytes("iso-8859-1"),"utf-8") %>"/>
				</c:if>
			</td> 
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">电子邮件：</label>
        </div>
        <div class="field">
          	<td>
				<c:if test="${requestScope.em==null}">
					<input type="text" name="email" style="width:155px" value="${user.email}"/>
				</c:if>
				<c:if test="${requestScope.em!=null}">
					<input type="text" name="email" style="width:155px" value="<%=new String(request.getAttribute("em").toString().getBytes("iso-8859-1"),"utf-8") %>"/>
				</c:if>
			</td>
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
  
  </body>
</html>
