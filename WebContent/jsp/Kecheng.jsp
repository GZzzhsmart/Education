<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!-- saved from url=(0029)http://www.tigu.cn/course.htm -->
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>在线教学平台</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/007/global.css">		
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/007/courseindex.css">
		<script type="text/javascript" async="" src="${pageContext.request.contextPath }/007/ga.js"></script><script src="../007/hm.js"></script><script type="text/javascript" src="../007/baidutongji.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/007/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/007/course.js"></script>
	<script type="text/javascript" async="async" charset="utf-8" src="../007/zh_cn.js" data-requiremodule="lang"></script><script type="text/javascript" async="async" charset="utf-8" src="../007/chat.in.js" data-requiremodule="chatManage"></script><script type="text/javascript" async="async" charset="utf-8" src="../007/mqtt31.js" data-requiremodule="MQTT"></script><script type="text/javascript" async="async" charset="utf-8" src="../007/mqtt.chat.js" data-requiremodule="Connection"></script></head>

	<body><div id="nTalk_post_hiddenElement" style="left: -10px; top: -10px; visibility: hidden; display: none; width: 1px; height: 1px;"></div><div id="nt-flash-div" style="position: absolute; z-index: 9996; top: -200px;"><embed id="ntkf_flash_ntid" name="ntkf_flash_ntid" src="http://dl.ntalker.com/js/xn6/siteid/respack_nt6.8.6/fs/NTID.swf?2016.12.08" width="1" height="1" style="" flashvars="siteid=kf_9115&amp;loadnid=1" wmode="opaque" allowscriptaccess="always" pluginspage="https://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash"></div>
		<div class="bodymin">
		

<script type="text/javascript" src="${pageContext.request.contextPath }/007/ntkfstat.js" charset="utf-8"></script>
	
	
	<div id="maintop">
        <!-- 在线客服-begin-->
	<div class="body_right">
		<ul>
	    	<li><a href="javascript:scroll(0,0)" title="返回顶部" class="body_r_fhdb" style="height:34px;"></a></li>
	        <li><a onmouseover="showDiv(&#39;zaixian&#39;);" onmouseout="closeDiv(&#39;zaixian&#39;);" href="javascript:void(0);" class="body_r_zxkf"></a>
	        	<div onmouseover="showDiv(&#39;zaixian&#39;);" onmouseout="closeDiv(&#39;zaixian&#39;);" id="zaixian_div" class="body_r_zxkfs">
	        		<a id="BizQQWPA" href="javascript:void(0);NTKF.im_openInPageChat();"></a>
	        	</div>
	        </li>
	        <li><a onmouseover="showDiv(&#39;QQqun&#39;);" onmouseout="closeDiv(&#39;QQqun&#39;);" href="javascript:void(0);" class="body_r_qq"></a>
	        </li>
	        <li><a onmouseover="showDiv(&#39;saoyisao&#39;);" onmouseout="closeDiv(&#39;saoyisao&#39;);" href="javascript:void(0);" class="body_r_sys"></a>
	        	<div onmouseover="showDiv(&#39;saoyisao&#39;);" onmouseout="closeDiv(&#39;saoyisao&#39;);" id="saoyisao_div" class="body_r_syss">
	        		<a href="javascript:void(0);"></a>
	        	</div>
	        </li>
	        <li><a onmouseover="showDiv(&#39;yijian&#39;);" onmouseout="closeDiv(&#39;yijian&#39;);" href="javascript:void(0);showDialog();" class="body_r_yjfk"></a>
	        	<div onmouseover="showDiv(&#39;yijian&#39;);" onmouseout="closeDiv(&#39;yijian&#39;);" id="yijian_div" class="body_r_yjfks">
	        		<a href="javascript:void(0);showDialog();"></a>
	        	</div>
	        </li>
	    </ul>
	    <div onmouseover="showDiv(&#39;QQqun&#39;);" onmouseout="closeDiv(&#39;QQqun&#39;);" id="QQqun_div" class="body_r_qqlist">
	    	<a id="QQqun_xuesheng_1" onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;index_QQqun_xuesheng_1&#39;, &#39;click&#39;, &#39;QQqun_xuesheng_1&#39;])" href="http://jq.qq.com/?_wv=1027&amp;k=g0XZIa" target="_blank">学生QQ群(2)</a>
	    	<a id="QQqun_xuesheng_2" onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;index_QQqun_xuesheng_2&#39;, &#39;click&#39;, &#39;QQqun_xuesheng_2&#39;])" href="http://jq.qq.com/?_wv=1027&amp;k=g7VRXm" target="_blank" style="border-right:none">学生QQ群(满)</a>
	    	<a id="QQqun_jiazhang_1" onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;index_QQqun_jiazhang_1&#39;, &#39;click&#39;, &#39;QQqun_jiazhang_1&#39;])" href="http://jq.qq.com/?_wv=1027&amp;k=XdgzX7" target="_blank" style="border-bottom:none;">家长QQ群(1)</a>
	    	<a id="QQqun_jiazhang_2" onclick="_hmt.push([&#39;_trackEvent&#39;, &#39;index_QQqun_jiazhang_2&#39;, &#39;click&#39;, &#39;QQqun_jiazhang_2&#39;])" href="http://jq.qq.com/?_wv=1027&amp;k=e257Lj" target="_blank" style="border-right:none;border-bottom:none;">家长QQ群(2)</a>
	    </div>
	</div>
	<!-- 在线客服-end---->
	
	<script type="text/javascript">
	function showDiv(divname) {
		if(divname == 'zaixian'){
			$("#zaixian_div").show();
		}else if(divname == 'QQqun'){
			$("#QQqun_div").show();
		}else if(divname == 'saoyisao'){
			$("#saoyisao_div").show();
		}else if(divname == 'yijian'){
			$("#yijian_div").show();
		}else if(divname == 'downerweima'){
			$("#downerweima").show();
		}else if(divname=='tieba'){
			$("#tieba").show();
		}
	}
	function closeDiv(divname) {
		if(divname == 'zaixian'){
			$("#zaixian_div").hide();
		}else if(divname == 'QQqun'){
			$("#QQqun_div").hide();
		}else if(divname == 'saoyisao'){
			$("#saoyisao_div").hide();
		}else if(divname == 'yijian'){
			$("#yijian_div").hide();
		}else if(divname == 'downerweima'){
			$("#downerweima").hide();
		}else if(divname=='tieba'){
			$("#tieba").hide();
		}
	}
	</script>
	
	<!--意见反馈-->
	<div id="bookClearBg" class="bookdeletbg" style="display:none;"></div>
    <div id="SD_window" class="yjfkbox" style="display:none;">
    	<a href="javascript:void(0);divClose();" class="closebut"></a>
        <div class="clear"></div>
        <div class="yjfk">
            <h3>意见反馈</h3>
            <textarea id="content_id">意见详细错误描述：</textarea>
            <a href="javascript:void(0);confirmClick();" class="submit_but">确　定</a>
        </div>
     </div>
    	
    </div>
   	<!--搜索框-->
     <div class="clear"></div>
    <div class="search_logo showgrid">
    	<form id="sform" name="sform" method="post" action="${ pageContext.request.contextPath }/Course?action=sousuo2">
	    	<a href="" id="logo"><img src="${ pageContext.request.contextPath }/007/logo.jpg"></a>
	    	<input type="hidden" id="type" name="type">
	    	<input type="hidden" id="type" name="username" value="${param.userid}">
	        <div class="topsearch">
            	<div class="topsearchbox">
                	<div class="topsearchall" onmouseover="typeListShow();" onmouseout="typeListHide();">
                    	<a>
                        	<label id="typeTitle">全部</label>
                        	<span class="caret"></span>
                        </a>
                        <ul id="typeList" style="display:none" onmouseout="typeListHide();">
                        	<li><a href="">视频讲解</a></li>
                            <li><a href="">文字解析</a></li>
                        </ul>
                    </div>
                    <input type="text" id="sw" name="sw" value="" placeholder="按课程名称，讲师名称查找" class="topsearchtext" onfocus="input();" onblur="" escapexml="true">
                    <a href="javascript:void(0);keyBoardDivShow();" class="topsearchimg on"></a>
                    <!---小键盘--->
                    <div id="keyBoard" class="keyboardbox" style="display:none">
                    </div>
                </div>
                <input type="submit" name="sousuo" value="搜索" class="topsearch_button">
            </div>
         </form>
    </div> 
    <!--主导航-->
    <div class="clear"></div>
    <div id="mainnav">
    	<div class="indexnav showgrid">
            <ul class="indexnavs">
                <li><a href="${pageContext.request.contextPath }/web/index.jsp">首页</a></li>
                <li><a href="">作业书</a></li>
                <li><a href="">视频题库</a></li>
                <li><a href="<%=basePath %>/Kecheng.jsp" class="on">课程</a></li>
                <li><a id="">试卷</a></li>
                <li><a href="">学习轨迹</a></li>
                <li><a href="">思维训练</a></li>
                <li><a id="payfuwu">服务购买</a></li>
            </ul>
            <div class="shijuanbox" style="display: none;">
            	<span></span>
                <ul>
                	<li><a href="">java系列</a></li>
                    <li><a href="">php系列</a></li>
                    <li><a href="">C系列</a></li>
                    <li><a href="" style="border-bottom:none;">ASP.NET系列</a></li>
                </ul>
            </div>
            <div class="payfuwubox" style="display: none;">
            	<span></span>
            </div>
        </div>
    </div>
    <script type="text/javascript">
	function showDialog() {
		$(".bookdeletbg").show();
		$("#SD_window").show();
		$("#content_id").focus();
	}
	function confirmClick(){
	var content = $("#content_id").val();
	content=content.replace(/<[^>]+>/g,"");//去除所有html标签
		if($.trim(content) == "" || '意见详细错误描述：'==$.trim(content)){
			alert("请输入意见反馈内容！");
			$("#content_id").val('');
			$("#content_id").focus();
		}else{
			$.ajax({
			   type: "POST",
			   url: "http://www.tigu.cn/ajaxAddMessage.do",
			   dataType:"text",
			   data: {"content":content},
			   processData: true,
			   success: function(date){ 
		        	alert(date);   
		        	divClose();
			   }
			});	
		}
	}
	function divClose(){
		$(".bookdeletbg").hide();
		$("#SD_window").hide();
	}
</script>
			<div class="bread_line">
			    <p>当前位置：<a href="">首页</a><em>&gt;</em><a href="${pageContext.request.contextPath }/jsp/Kecheng.jsp" class="on">课程</a></p>
			</div>
			<!--头部状态栏-->
			<div class="infobg"></div>
		    <!--搜索-->
		    <div class="logobg"></div>
		    <!--主导航-->
		    <div class="mian_navbg"></div>
		    <!--面包线导航-->
		    <div class="line_navbg"></div>
		    <!--内容部分-bigen-->
		    <div class="mian ">
		        <!--===右边==-->
		        <!--限时免费-->
		        <h2 class="xs_mianfeititle"><img src="${pageContext.request.contextPath }/007/c_i_xmbg.png"></h2>
		    	<div class="xs_mianfei">
		    		
			            <dl>
				       		<dt><a href="${ pageContext.request.contextPath }/teacherServlet?action=xin1" title="Hibernate/structs/spring"><img src="../007/1.jpg"></a>
				          		<span><a href="" title="Hibernate/structs/spring">&nbsp;&nbsp;</a></span>
				            </dt>
			               	<dd>Hibernate/structs/spring<br><span><a href="${pageContext.request.contextPath }/Course?action=buylist" title="知识结构梳理">金牌讲师-赖国荣</a></span></dd>
			          	</dl>
		          	
			            <dl>
				       		<dt><a href="" title="系统/维运"><img src="../007/4.JPG"></a>
				          		<span><a href="" title="系统/维运">&nbsp;&nbsp;</a></span>
				            </dt>
			               	<dd>系统/维运<br><span><a href="" title="系统/维运">金牌讲师-陈飞龙</a></span></dd>
			          	</dl>
		          	
			            <dl>
				       		<dt><a href="${ pageContext.request.contextPath }/teacherServlet?action=xin2" title="java/JSP"><img src="../007/3.jpg"></a>
				          		<span><a href="" title="java/JSP">&nbsp;&nbsp;</a></span>
				            </dt>
			               	<dd>java/JSP<br><span><a href="${ pageContext.request.contextPath }/Course?action=buylist1" title="java/JSP">高级讲师-赖勇健</a></span></dd>
			          	</dl>
		          	
			            <dl>
				       		<dt><a href="${ pageContext.request.contextPath }/teacherServlet?action=xin3" title="HTML5/MySQL"><img src="../007/2.jpg"></a>
				          		<span><a href="" title="HTML5/MySQL">&nbsp;&nbsp;</a></span>
				            </dt>
			               	<dd>HTML5/MySQL<br><span><a href="${pageContext.request.contextPath }/Course?action=buylist2" title="HTML5/MySQL">特级讲师-曾志胡</a></span></dd>
			          	</dl>
		          	
			            <dl>
				       		<dt><a href="" title="移动开发"><img src="../007/2337.jpg"></a>
				          		<span><a href="" title="移动开发">&nbsp;&nbsp;</a></span>
				            </dt>
			               	<dd>移动开发<br><span><a href="" title="移动开发">高级讲师-程文韵</a></span></dd>
			          	</dl>
		          	
			            <dl>
				       		<dt><a href="m" title="数据库•Office办公"><img src="../007/2342.jpg"></a>
				          		<span><a href="" title="数据库•Office办公">&nbsp;&nbsp;</a></span>
				            </dt>
			               	<dd>数据库•Office办公<br><span><a href="" title="数据库•Office办公">中级讲师-李小龙</a></span></dd>
			          	</dl>
		        </div>
		        
			    <div class="clear"></div>
			    <div class="coursecont">
		        	<ul class="grade_list">
		            	<li><a href="" class="on">Unity3D</a></li>
		                <li><a href="">Oracle</a></li>
		                <li><a href="">Linux</a></li>
		                <li><a href="">Windows</a></li>
		            </ul>
		            <div class="clear"></div>
		            <div class="select_list">
		            	<span>课程：</span>
		            	<ul>
		            		<li class="on"><a href="">编程语言</a></li>
		                </ul>
		            </div>
		            <div class="video_list">
		            	
			            	<div class="video_all"><a href="">全部&gt;&gt;</a></div>
			                <dl>
			                    <dt><a href="${pageContext.request.contextPath }/Course?action=buyDetail2&userid=${param.userid }" title="jsp从入门到精通"><img src="../007/11.jpg"></a></dt>
			                    <dd><a href="" title="jsp从入门到精通">金牌讲师-赖国荣&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="${pageContext.request.contextPath }/Course?action=buyDetail3&userid=${param.userid }" title="java从入门到精通"><img src="../007/12.jpg"></a></dt>
			                    <dd><a href="" title="java从入门到精通">高级讲师-曾志湖&nbsp;&nbsp;&nbsp;课时数 40</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="${pageContext.request.contextPath }/Course?action=buyDetail4&userid=${param.userid }" title="html从入门到精通"><img src="../007/13.jpg"></a></dt>
			                    <dd><a href="" title="html从入门到精通">金牌讲师-赖国荣&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="${pageContext.request.contextPath }/Course?action=buyDetail5&userid=${param.userid }" title="c++从入门到精通"><img src="../007/14.jpg"></a></dt>
			                    <dd><a href="" title="c++从入门到精通">认证讲师-赖勇建&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="${pageContext.request.contextPath }/Course?action=buyDetail6&userid=${param.userid }" title="JavaScript从入门到精通"><img src="../007/15.jpg"></a></dt>
			                    <dd><a href="" title="JavaScript从入门到精通">中级讲师-邱智才&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="${pageContext.request.contextPath }/Course?action=buyDetail7&userid=${param.userid }" title="MySql从入门到精通"><img src="../007/16.jpg"></a></dt>
			                    <dd><a href="" title="MySql从入门到精通">特级讲师-陈飞龙&nbsp;&nbsp;&nbsp;课时数 40</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="" title="Oracle从入门到精通"><img src="../007/17.jpg"></a></dt>
			                    <dd><a href="" title="Oracle从入门到精通">中级讲师-张磊&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="" title="Ajax从入门到精通"><img src="../007/18.jpg"></a></dt>
			                    <dd><a href="" title="Ajax从入门到精通">金牌讲师-赖勇建&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="" title="jQuery从入门到精通"><img src="../007/19.jpg"></a></dt>
			                    <dd><a href="" title="jQuery从入门到精通">认证讲师-伍群斌</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="" title="Hibernate从入门到精通"><img src="../007/20.jpg"></a></dt>
			                    <dd><a href="" title="Hibernate从入门到精通">高级讲师-曾志湖</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="" title="spring从入门到精通"><img src="../007/21.jpg"></a></dt>
			                    <dd><a href="" title="spring从入门到精通">特级讲师-刘书华</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
			                <dl>
			                    <dt><a href="" title="easyUI从入门到精通"><img src="../007/19.jpg"></a></dt>
			                    <dd><a href="" title="easyUI从入门到精通">高级讲师-赖勇建&nbsp;&nbsp;&nbsp;课时数 20</a></dd>
			                    <img src="../007/c_i_pbutton.png" class="playbut">
			                </dl>
			            
		        	</div>
		        </div>
		    <!--内容部分-end-->
		</div>

<!--==footer==-->
    <div class="footernavbg">
    	<ul class="foot_nav">
	         	<li><a style="font-weight:bold;margin-right:27px;">友情链接：</a></li>
	         	<li><a href="" target="_blank">河南校讯通</a><em>|</em></li>
	         	<li><a href="" target="_blank">淘教中国</a><em>|</em></li>
	         	<li><a href="" target="_blank">腾讯精品课</a></li>
	   </ul>
    </div>
    <div class="clear"></div>
    <div class="footertopbg">
    	<div class="footertop">
            <div class="foot_help">
                <div class="f_help_l">
                   <h3><a style="color:#ffffff">帮助中心</a></h3>
                   <a class="f_h_lpic1"></a>
                  </div>
                  <div class="f_help_r">
                      <p class="telephone"><a><em></em>400-676-8080</a></p>
                  </div>
	     	</div>
                <div class="foot_help">
                    <div class="f_help_l">
                        <h3><a href="" target="_blank" style="color:#55ffdd">招商合作</a></h3>
                          <div class="f_h_lpic2"></div>
                    </div>
                    <div class="f_help_r">
                        <p>QQ：3156638809 </p>
                      <p>招商电话：010-82053396</p>
                      <p>地址：北京市西城区新街口外大街<br>28号A座4层409</p>
                  </div>
                </div>
              <div class="foot_help">
                <div class="f_help_l">
                    <h3>关注我们</h3>
                      <div class="f_h_lpic3"></div>
                  </div>
                  <div class="f_help_r">
                    <p style="float:left;margin-right:30px;">
                    <a href="">认证空间<br></a>
                    <a href="">新浪微博<br></a>
                    </p>
                      <img src="../007/footer_erweima.jpg">
                      <p style="margin:7px 0 0 72px;color:#fff;">扫一扫有惊喜！</p>
                  </div>
              </div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="footerbottombg">
        <div class="footerbottom">
            <ul>
                <li><a href="" style="margin-left:0;" rel="nofollow">关于平台</a></li>
                <li><a href="" rel="nofollow">联系我们</a></li>
                <li><a href="" rel="nofollow">版权声明</a></li>
                <li><a href="" rel="nofollow">使用协议</a></li>
                <li style="border-right:0;"><a href="" rel="nofollow">招聘英才</a></li>
                <!-- li style="border-right:0;"><a href="">题目大全</a></li-->
            </ul><br>
            <div class="clear"></div>
            <p>COPYRIGHT (C) 2012-2015 WWW.TIGU.CN INC. ALL RIGHTS RESERVED. 胡歌教育 版权所有</p>
            <p>京ICP备12041185号 京公网安备110102006152<script src="../007/stat.php" language="JavaScript"></script><script  charset="utf-8" type="text/javascript"></script><a href="http://www.cnzz.com/stat/website.php?web_id=3924713" target="_blank" title="站长统计"><img border="0" hspace="0" vspace="0" src="../007/pic.gif"></a></p>
           
		</div>
	</div>
</div>

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-30770330-1']);
  _gaq.push(['_setDomainName', 'tigu.cn']);
  _gaq.push(['_addOrganic','soso','w']);
  _gaq.push(['_addOrganic','yodao','q']);
  _gaq.push(['_addOrganic', 'so', 'q']);
  _gaq.push(['_addOrganic','sogou','query']);
   _gaq.push(['_setAllowLinker', true]);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; 
    s.parentNode.insertBefore(ga, s);
  })();
</script>
</body></html>
