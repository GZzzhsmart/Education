<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>海源教育平台</title> 
<link href="${pageContext.request.contextPath }/web/css/index.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/web/css/bottom.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/web/js/jquery-1.5.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/web/js/tool.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/web/js/banner.js" type="text/javascript"></script>
 <script language=Javascript> 
	 function time(){
		 var now=new Date() 
		 var s=now.getFullYear()+"年"+(now.getMonth()+1)+"月"+now.getDate() +"日"+now.getHours()+"时"+now.getMinutes()+"分"+now.getSeconds()+"秒";
		 document.getElementById('date').innerHTML=s;
		 setTimeout(time,1000);
	 } 
 </script>
 <body onload="time()">
<!-- 头部 -->
<div id="header">
  <div class="top">    
     <div class="welcome">
     您好！欢迎来到海源教育官网！  <a href="${pageContext.request.contextPath }/web/login.jsp">登录</a>|<a href="${pageContext.request.contextPath }/usersServlet?action=init">注册</a>
     </div>
	<div class="top_right">             
     <div id="date" style="float: left; line-height: 36px;padding-right: 10px;"></div>
        <span style="CURSOR: hand" onclick="window.external.addFavorite('wwww.sms98.cn')" title="宏图在线教育官网">收藏本站</span>
    </div>
  </div>
  <div class="top_nav">
    <div class="logo"><a href="#" title="宏图教育"><img src="./image/logo.jpg" alt="宏图教育" width="400" height="80"></a></div>
    <div class="search"> 
   	  <div class="xiala">
			<dl id="tdwt" class="dropdowns tdwt">
      		<dt><a href="javascript:void(0)"><span>文章</span></a></dt>
     		 <dd>
   				 <ul>
					<li><a href="javascript:void(0)">文章<span class="value">文章</span></a></li>
					<li><a href="javascript:void(0)">视频<span class="value">视频</span></a></li>
					<li><a href="javascript:void(0)">试题<span class="value">试题</span></a></li>
					<li><a href="javascript:void(0)">教材<span class="value">教材</span></a></li>
				</ul>
  			</dd>
 			</dl>
      </div>
      <form id="frm_add" name="frm_add" method="post" action="#">
        <input type="text" class="key" name="key" id="key" placeholder="搜索你感兴趣的视频...">
        <input type="hidden" name="searchtype" id="searchtype" value="文章">
        <input type="submit" class="button" name="button" id="button" value="提交">
      </form>
      <ul class="host">
      <li class="ik">热搜：</li>
      <li class="o"><a target="_blank" href="#">编程教材</a></li>
      <li class="ik"><a target="_blank" href="#">IT资讯</a></li>
      <li class="ik"><a target="_blank" href="#">行业信息</a></li>
      <li class="ik"><a target="_blank" href="#">精品课程</a></li>
      </ul>
    </div>
  </div>
  <div class="nav">
	<ul>
		<li class="n"><a href="#">首页</a></li>
		<li><a target="_self" href="${pageContext.request.contextPath}/html/index.html">个人信息</a></li>
		<li><a target="_self" href="#">在线课程</a></li>
		<li><a target="_self" href="#">新闻公告</a></li>
		<li><a target="_self" href="#">一线讲师</a></li>
		<li><a target="_self" href="#">优惠活动</a></li>                               
		<li><a target="_self" href="${pageContext.request.contextPath}/index1.html">在线答题</a></li>                               
		<li><a target="_self" href="${pageContext.request.contextPath}/index.html">查看评论</a></li>
	</ul>
  </div>
</div>
<!-- 左侧导航 -->
<div id="left_nav" style="left: 33px; position: absolute; top: 151px;">
<h1>推荐精品课程</h1>
<div class="nav_list" id="nav_k">
	<ul><h2><img src="./image/left_nav_img1.gif">C语言从入门到精通实训</h2></ul>
  	<ul><h2><img src="./image/left_nav_img2.gif">SQL2005从入门到精通</h2></ul>
	<ul><h2><img src="./image/left_nav_img14.gif">JAVA语言从入门到精通</h2></ul>
  	<ul><h2><img src="./image/left_nav_img3.gif">JavaScript从入门到精通 </h2></ul>
  	<ul><h2><img src="./image/left_nav_img4.gif">JSP从入门到精通项目实训</h2></ul>
     <ul><h2><img src="./image/left_nav_img13.gif">仿QQ即时通讯教学视频</h2></ul>
	<img src="./image/22.jpg" alt="" width="99%">
	<div class="qqbtnV">
		<a href="#"><div class="qqbtn"><span>客服QQ<br/>1729340612</span></div></a>
		<a href="#"><div class="qqbtn"><span>客服QQ<br/>1729340612</span></div></a>
		<a href="#"><div class="qqbtn"><span>客服QQ<br/>1729340612</span></div></a>
		<a href="#"><div class="qqbtn"><span>客服QQ<br/>1729340612</span></div></a>
	</div>
 	<div style="height: 30px;width: 100%; float: left;"></div>
</div>
 <div class="nav_list2" >
 	 	<ul>
 	<li style="font-size: 18px;">就业岗位</li>
 	
 	  	<li><a href="#">Java高级软件工程师</a></li>
 	  	<li><a href="#">Python web开发工程师</a></li>
 	  	<li><a href="#">PHP开发</a></li>
 	  	<li><a href="#">JSP开发</a></li>
 	  	<li><a href="#">ASP.NET开发</a></li>
 	  	<li><a href="#">C开发</a></li>
 	  	<li><a href="#">大数据开发</a></li>
 	  	<li><a href="#">云计算</a></li>
    </ul>
 </div>
</div>
<!-- 内容部分 -->
<div id="ibody">
  <div class="body_k">
  	<div class="left">
	  <div class="banner_k" style="height: 242px;">
<div id="banner" style="height: 242px;">
    <ul id="show_pic" style="left: -694px;">
		<li><a href="javascript:void(0);" target="_blank"><img src="./image/4.jpg" width="695" height="242" ></a></li>
		<li><a href="javascript:void(0);" target="_blank"><img src="./image/5.jpg" width="694" height="242" alt="网络视频"></a></li>
		<li><a href="javascript:void(0);" target="_blank"><img src="./image/6.jpg" width="694" height="286" alt="在线报名"></a></li>
    </ul>
    <ul id="icon_num">
        <li class="">1</li>
        <li class="active">2</li>
        <li class="">3</li>
    </ul>
</div>
      </div>
      <!-- news start -->
      <div class="news_k">
      		<img src="./image/2.jpg" width="324" height="239">
        <div class="news_wz">
           	<h1><a href="javascript:void(0);" target="_blank">2017年IT行业就业形势小分析</a></h1>
            	<p>公司方向：互联网、传统软件公司、非IT公司<a href="/education/html/1.html" target="_blank"> &lt;&lt;详细&gt;&gt; </a></p>
                <div class="new_list">
               	  <ul>
                  	<li><i>•</i> <a target="_blank" href="javascript:void(0);">[IT动态]如何打造类似数据虫巢官网</a></li>
					<li><i>•</i> <a target="_blank" href="javascript:void(0);">[IT动态]Linux下的静态库与动态库</a></li>
					<li><i>•</i> <a target="_blank" href="javascript:void(0);">[IT动态]基于Node.js+Express实现简易博客系统</a></li>
					<li><i>•</i> <a target="_blank" href="javascript:void(0);">[IT动态]SQL/NoSQL谁更适合大数据编程技术</a></li>
				</ul>
                </div>
                <div class="more">
                <a href="/education/html/2.html">更多>></a></div>
                
            </div>
       </div>
      </div>
  <!-- 右侧开始 -->
  <div class="right">
  <!-- manber -->
	  <div class="manber_k">
      	<div style="float:left;padding-top:25px;padding-left:15px;width:80;"><img src="./image/manber.jpg" width="60"></div>
        <div style="float:right; width:150px;padding-right:10px;">
	        <a href="${pageContext.request.contextPath }/Login1.jsp"><img style="padding-top:5px;" src="./image/img/teacherBtn.png" width="100%"></a>
	        <a href="${pageContext.request.contextPath }/web/login.jsp"><img style="padding-top:5px;" src="./image/img/studentBtn.png" width="100%"></a>
        </div>        	
	  </div>
	  <div class="gongao">
	  	<h1>最新资讯</h1>
	    	<ul>
	           <li><i>•</i> <a target="_blank" href="javascript:void(0);">RancherOS 0.8.0 发布，多地加快推进大数据产业发展</a></li>
			   <li><i>•</i> <a target="_blank" href="javascript:void(0);">Awe - 采用Vue.js开发material design风格的日历组件</a></li>
			   <li><i>•</i> <a target="_blank" href="javascript:void(0);">从0开始搭建坚不可摧的Web系统主流架构</a></li>
			   <li><i>•</i> <a target="_blank" href="javascript:void(0);">甲骨文预测：2017年大数据的变化趋势</a></li>
			   <li><i>•</i> <a target="_blank" href="javascript:void(0);"> 静态库与动态库</a></li>
			</ul>
	        <div class="more">
	    <a href="#">更多>></a></div>           
	  </div>	 
	  <img style="padding-top: 12px;" src="./image/ad.jpg" width="100%" height="180px">
    </div>
    <div class="clear"></div>
  <!-- rongyu -->
  <div class="rongyu_k"  style="height: 380px;">
  <h1>在线课程<a target="_blank" href="javascript:void(0);">更多&gt;&gt;</a></h1>
  <div class="show_pic">   
           <div class="smallPic" >
             <ul>
             <li>   	
             	<img src="./image/11.jpg"><br/><br/>
             	<a href="#">JSP从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/12.jpg"><br/><br/>
             	<a href="#">java从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/13.jpg"><br/><br/>
             	<a href="#">html从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/14.jpg"><br/><br/>
             	<a href="#">c++从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/15.jpg"><br/><br/>
             	<a href="#">JavaScript从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/16.jpg"><br/><br/>
             	<a href="#">MySql从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/20.jpg"><br/><br/>
             	<a href="#">Hibernate从入门到精通教程</a>
             </li>
             
             <li>   	
             	<img src="./image/17.jpg"><br/><br/>
             	<a href="#">Oracle从入门到精通教程</a>
             </li>
             
             <li>   	
             	<img src="./image/21.jpg"><br/><br/>
             	<a href="#">spring从入门到精通教程</a>
             </li>
             <li>   	
             	<img src="./image/19.jpg"><br/><br/>
             	<a href="#">jQuery从入门到精通教程</a>
             </li>
        
                  
             </ul>
          </div>
      </div>
  </div>
    <div class="rongyu_k"  style="height: 380px;">
  <h1>一线实战老师<a target="_blank" href="javascript:void(0);">更多&gt;&gt;</a></h1>
  <div class="show_pic">   
           <div class="smallPic" >
             <ul>
             <li>   	
             	<img src="./image/23.jpg"><br/><br/>
             	<a href="#">赖国荣</a>
             </li>                
             <li>   	
             	<img src="./image/24.jpg"><br/><br/>
             	<a href="#">曾志湖</a>
             </li>                
             <li>   	
             	<img src="./image/25.jpg"><br/><br/>
             	<a href="#">赖勇建</a>
             </li>                
             <li>   	
             	<img src="./image/26.jpg"><br/><br/>
             	<a href="#">陈飞龙</a>
             </li>                
             <li>   	
             	<img src="./image/p7.jpg"><br/><br/>
             	<a href="#">伍群斌</a>
             </li>                
          </div>
      </div>
  <h1>一线实战课程<a target="_blank" href="javascript:void(0);">更多&gt;&gt;</a></h1>
  	<div class="show_pic">   
           <div class="smallPic" >
             <ul>
             <li>   	
             	<img src="./image/17.jpg"><br/><br/>
             	<a href="#">Oracle</a>
             </li>                
             <li>   	
             	<img src="./image/13.jpg"><br/><br/>
             	<a href="#">html</a>
             </li>                
             <li>   	
             	<img src="./image/14.jpg"><br/><br/>
             	<a href="#">C++</a>
             </li>                
             <li>   	
             	<img src="./image/15.jpg"><br/><br/>
             	<a href="#">JavaScript</a>
             </li>                
             <li>   	
             	<img src="./image/19.jpg"><br/><br/>
             	<a href="#">jQuery/easyUI</a>
             </li>   
            </ul>
           </div>
          </div>     
        
  </div>

  </div>

  
  <div style="height:20px;width: 100%;float: left;" ></div>
  
</div>
<div class="clear"></div>
<jsp:include page="/web/footer.jsp"></jsp:include>
<script type="text/Javascript">
	function addCookie() {　 // 加入收藏
　　　　if (document.all) {
　　　　	window.external.addFavorite('http://www.sms98.cn', '房地产销售系统');
　　　　}
　　　　else if (window.sidebar) {
　　　　	window.sidebar.addPanel('房地产销售系统','http://www.sms98.cn', "");
　　　　}
　　}　
</script>
<script type="text/javascript">
//banner 图片切换
banner_show(694);
	$(document).ready(function(){
	//web下滑效果
	var scrtime;
 	
	function show(){
		scrtime = setInterval(function(){
		var $ul = $(".userName");
		var liHeight = $ul.find("li:last").height();
		$ul.animate({marginTop : liHeight+1 +"px"},694,function(){
			$ul.find("li:last").prependTo($ul)
			$ul.find("li:first").hide();
			$ul.css({marginTop:0});
			$ul.find("li:first").fadeIn(1000);
		});	
		},2500);
	}
	show();
	$(".w678 li a").hover(function(){
		$(this).children("h5").show();
		},function(){
			$(this).children("h5").hide();	
		})
	});	
</script>
</body>
</html>