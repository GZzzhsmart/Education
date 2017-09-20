<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>后台管理中心</title>
	<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css">
	<jsp:include page="/IncludeJS.jsp"></jsp:include>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/dh.js"></script>
</head>
<body leftmargin="0" topmargin="0"  marginwidth="0" marginheight="0">
		<div class="left">
		<dl class="leftmenu">
			<dd>
			  	<div class="title">
				<span>信息管理<i></i></span>
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="${pageContext.request.contextPath }/managerServlet?action=list" target="rightFrame">管理员</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/provinceServlet?action=list" target="rightFrame">省份管理</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/cityServlet?action=list" target="rightFrame">城市管理</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/bankServlet?action=list" target="rightFrame">银行管理</a></li>
				</ul>    
			</dd>
			<dd>
			  	<div class="title">
				<span>讲师管理<i></i></span>
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="${pageContext.request.contextPath }/teacherServlet?action=list" target="rightFrame">资料审核</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/gradeServlet?action=list" target="rightFrame">等级设置</a></li>
				</ul>    
			</dd>
			<dd>
			  <div class="title">
				<span>优惠券管理<i></i></span>
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="${pageContext.request.contextPath }/couponRecordServlet?action=list2" target="rightFrame">优惠券信息</a></li>
				</ul>    
			</dd>
			<dd>
			  <div class="title">
				<span>收入管理<i></i></span>
				</div>
				
				<ul class="menuson">
					<li><cite></cite><a href="${pageContext.request.contextPath }/payrecordServlet?action=houtaishenhe" target="rightFrame">提现记录</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/moneyRecordServlet?action=list2" target="rightFrame">充值记录</a></li>
				</ul>    
			</dd>
	
			<dd>
			  <div class="title">
				<span>学习管理<i></i></span>
				</div>
			</dd>
			<dd>
			  <div class="title">
				<span>新闻公告<i></i></span>
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="${pageContext.request.contextPath }/newsMsgServlet?action=list" target="rightFrame">通知公告</a>
					</li>
					<c:iterator value="#request.provinces" var="d">
						<li>
							<span><a href="javascript:void(0)" onclick="addTab1('${d.provinceName }新闻','newsAction!list.action?news.provinceId=${d.provinceId}&news.cityId=0&find=');"></a></span>
						</li>
					</c:iterator>
				</ul>  
			</dd>
			<dd>
			  <div class="title">
				<span>课程管理<i></i></span>
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="${pageContext.request.contextPath }/usersServlet?action=list" target="rightFrame">用户管理</a></li> 
					<li><cite></cite><a href="${pageContext.request.contextPath }/courseServlet?action=list1" target="rightFrame">在线课程</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/sectionServlet?action=list1" target="rightFrame">课程节表</a></li>
					<li><cite></cite><a href="${pageContext.request.contextPath }/payrecordServlet?action=list" target="rightFrame">买课记录</a></li> 
				</ul>    
			</dd>
			<dd>
			  <div class="title">
				<span>广告管理<i></i></span>
				</div>
			</dd>
			<dd>
			  <div class="title">
				<span>统计报表<i></i></span>
				</div>
			</dd>
			<dd>
			  <div class="title">
				<span>用户介绍管理<i></i></span>
				</div>
			</dd>
			<dd>
			  <div class="title">
				<span>合作伙伴<i></i></span>
				</div>
			</dd>
			<dd>
			  <div class="title">
				<span>兑换码管理<i></i></span>
				</div>
			</dd>
			<dd>
			  <div class="title">
				<span>基础数据<i></i></span>
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="ptAction!list.action" target="rightFrame">省份管理</a></li>
					<li><cite></cite><a href="ptAction!list.action" target="rightFrame">城市管理</a></li>
					<li><cite></cite><a href="ptAction!list.action" target="rightFrame">项目类型</a></li>
				</ul>    
			</dd>
			<dd>
			  <div class="title">
				<span>系统日志<i></i></span>
				</div>
				<ul class="menuson">
					<li><cite></cite><a href="logAction!log.action" target="rightFrame">系统日志</a></li>
				</ul>    
				
			</dd>
		</dl>
		<div class="dl-second-slib-con"><a class="dl-second-slib" href="javascript:"></a></div>
		</div>
</body>
</html>