<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta property="wb:webmaster" content="4f7692598978096d">
	<meta property="wb:webmaster" content="a776c1c443a518a4">
	<title>欢迎登陆宏图在线教育！</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/css/style.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/css/web-foot.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/web/css/sign.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/web/css/bottom.css">
</head>
<body>
<div >
<div class="sign_top">
  <div class="g-o-a">
    <div class="g-f-r sign-help"><div class="rightTop"><span>咨询热线：<b>18720865791</b></span> <span>如果您在注册、登录遇到问题，请咨询QQ：1729340612</span>
    </div></div>
    <h1><a href="#"  class="logo"><img width="280" height="57" src="./image/logo.jpg"></a></h1>
      </div>
</div>
  	<%
  		if(session.getAttribute("user")!=null){
  			response.sendRedirect(basePath+"web/webCenter.jsp");
  		}else{
	  		//读取cookie变量的值
	  		Cookie cookies[]=request.getCookies();
	  		String mobile = "";
	  		String pass="";
	  		//如果没有cookie则，数组为空
	  		if(cookies!=null){
	  			for(int i=0;i<cookies.length;i++){
	  				Cookie c = cookies[i];
	  				System.out.println(c.getName()+"="+c.getValue());
	  				if(c.getName().equals("mobile")){
	  					//解码操作URLDecoder.decode();
	  					mobile=URLDecoder.decode(c.getValue());//获取cookie的值
	  				}
	  				if(c.getName().equals("password")){
	  					pass=URLDecoder.decode(c.getValue());//获取cookie的值
	  				}
	  			}
	  		}%>
	  		<c:if test="${msg==null}">
	       <%
	       		if(!mobile.equals("") && !pass.equals("")){
	  			%>
					<jsp:forward page="/usersServlet?action=autologin">
						<jsp:param name="mobile" value="<%=mobile%>"/>
						<jsp:param name="password" value="<%=pass%>"/>
					</jsp:forward>  			
	  			
	  			<%
	  			}
	       %>
	       </c:if>
	       <%
       }
  	 %>


<div class="g-o-a login">
  <div class="g-h-25"></div>
  <div class="login-loc">
    <div style="padding:10px 10px 20px 28px;">
      <h2 class="g-ff-y">用户登录</h2>
       <div id="logtips" class="">
       
       </div>
       <c:if test="${msg!=null}">
       	<script type="text/javascript">
       		alert("${msg}");
       	</script>
       </c:if>
      <form action="${pageContext.request.contextPath }/usersServlet?action=login2" method="post" name="loginform" onsubmit="return csc.sign.submitlog();">
        <input id="redirecturi" type="hidden" name="done" value="">
        <input type="hidden" name="ref" value="#">
        <input type="hidden" name="inviteId" value="">
        <ul>
          <li class="g-c-f">
            <label>手机号码：</label>
            <input name="mobile" id="mobile" autocomplete="off" type="text" class="txt loginName" value="" placeholder="请输入手机号码">
          </li>
          <li class="g-c-f">
            <label>登录密码：</label>
            <input name="password" id="password" type="password" class="txt" placeholder="请输入登录密码"/>
          </li>
         <li class="login-sub-btn">
            <input name="" id="logmain" class="btn-bg" type="submit" value="登录"/>
            <a href="＃">忘记密码?</a> 
         </li>
        </ul>
      </form>
      <div id="other-list" class="other-list"><em>用第三方账号登录：</em><span id="qqLoginBtn" class="qq"></span> <span id="wb_connect_btn" class="sina"></span> <!--span id="baidu_login" class="baidu"></span--><span id="weixinlogin" class="weixin"></span><span id="taobaologin" class="taobao"></span><!--span id="login-360" class="login-360"></span--></div>
    </div>
    <div class="log_dis"><span>还不是在线教学平台用户？</span>一分钟轻松注册，加入平台大家庭！<a href="${pageContext.request.contextPath }/usersServlet?action=init" class="btn-reg">免费注册</a></div>
  </div>
  <div class="log-img">
  <img src="./image/27.jpg" alt="" />
  
  
  
  </div>
  <div class="g-h-30"></div>
</div>
<jsp:include page="/web/footer.jsp"></jsp:include>
</body>
</html>