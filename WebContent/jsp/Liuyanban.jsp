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
    
    <title>My JSP 'Liuyanban.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="./Ljsp/styles.css">
	-->
	<link  rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/sinaFaceAndEffec.css" />

	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.4.min.js"></script>

	<script type="text/javascript">
		
		function check(){
			
			if(form1.oText.value==""){
				
				alert("请输入内容！");
				form1.oText.focus();
				return false;
			}
			return true;
		}
		
	</script>

  </head>
  

  	<body>
  	<form name="form1" action="${pageContext.request.contextPath }/forumServlet?action=add"  method="post" onsubmit="return check();">
  	
  	<input type="hidden" name="userid" value="${param.userid}">
  		
    <div id="content" style="width: 700px; height: auto;margin-left:320px;margin-top:40px">
	<div class="wrap">
		<div class="comment">
			<div class="head-face">
				<img src="${pageContext.request.contextPath }/css/1.jpg" / >
				<p>我是胡歌</p>
			</div>
			<div class="content">
				<div class="cont-box">
					<textarea class="text" placeholder="请输入..." id="neiron" name="neiron"></textarea>
				</div>
				<div class="tools-box">
					<div class="operator-box-btn"><span class="face-icon"  >☺</span><span class="img-icon">▧</span></div>
					<div class="submit-btn"><input type="submit" onClick="out()"value="提交评论" /></div>
				</div>
			</div>
		</div>
		<div id="info-show">
			<ul></ul>
		</div>
	</div>
</div>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/sinaFaceAndEffec.js"></script>
<script type="text/javascript">
	// 绑定表情
	$('.face-icon').SinaEmotion($('.text'));
	// 测试本地解析
	function out() {
		var inputText = $('.text').val();
		$('#info-show ul').append(reply(AnalyticEmotion(inputText)));
	}
	
	var html;
	function reply(content){
		html  = '<li>';
		html += '<div class="head-face">';
		html += '<img src="./Ljsp/images/1.jpg" / >';
		html += '</div>';
		html += '<div class="reply-cont">';
		html += '<p class="username">小小红色飞机</p>';
		html += '<p class="comment-body">'+content+'</p>';
		html += '<p class="comment-footer">2016年10月5日　回复　点赞54　转发12</p>';
		html += '</div>';
		html += '</li>';
		return html;
	}
	
</script>

<Script Language="JavaScript">  
function borderColor(){  
if(self['oText'].style.borderColor=='red'){  
self['oText'].style.borderColor = 'yellow';  
}else{  
self['oText'].style.borderColor = 'red';  
}  
oTime = setTimeout('borderColor()',400);  
}  
</Script>  
	<table align="center" >
		<tr align="center">
			<td align="center">
		<c:forEach items="${forums}" var="d">
			<textarea  rows="" cols=""   style="width:580px;height:50px"  name="oText" id="oText" style="border:50px dotted red;color:red" onfocus="borderColor(this);" onblur="clearTimeout(oTime);">
			${d.content }
			</textarea>
			${d.username }
			${d.forumdate }
		</c:forEach>  
			<td>
		</tr>
		<tr align="center">
			<td align="center">
		<c:forEach items="${forum}" var="d">
			<textarea  rows="" cols=""   style="width:580px;height:50px"   id="oText" >
				${d.content }
			</textarea>
			${d.username }
			${d.forumdate }
		</c:forEach>  
			<td>
		</tr>
	</table>
</body>
</html>
