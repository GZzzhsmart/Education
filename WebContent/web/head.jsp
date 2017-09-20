<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<div id="topinfo">
        <div class="topinfo_con">
            <div class="top_left">
            	您好！欢迎来到宏图教育官网！<a href="${pageContext.request.contextPath}/web/login.jsp">登录</a> 
            </div>
        </div>
    </div>
	<div id="header">
        <div class="mainHeader">
        	<div class="left_mh">
            	<img src="${pageContext.request.contextPath}/web/image/logo.jpg" width="300" height="80" alt="培考网官网">  
            </div>
        </div>
        <div id="nav">
            <ul class="nav_list">
				<li class="n"><a href="${pageContext.request.contextPath}/web/index.jsp">首页</a></li>
				<li><a target="_self" href="#">走进海源</a></li>
				<li><a target="_self" href="#">在线课程</a></li>
				<li><a target="_self" href="${pageContext.request.contextPath}/newsMsgServlet?action=list">新闻公告</a></li>
				<li><a target="_self" href="#">一线讲师</a></li>  
				<li><a target="_self" href="#">优惠活动</a></li>                               
				<li><a target="_self" href="#">免费视频</a></li>                               
				<li><a target="_self" href="#" target="rightFrame">关于我们</a></li>
            </ul>
        </div>
    </div>   