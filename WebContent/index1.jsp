<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<title>用户评价</title>
		<meta charset="utf-8">
		<meta name="Author" content="苏淮">
		<style type='text/css'>
			*{ margin:0; padding:0;}
			
			#wrap{
				width:600px;
				height:400px;
				margin:50px auto;
			}
			#top{
				width:600px;
				height:220px;
				border-bottom:1px solid #bbb;
				font-family:'Microsoft yahei';
			}
			#top p{
				margin-bottom:15px;
			}
			#top p font{
				font-size:14px;
				color:#000;
				margin-right:15px;
			}
			#top p span{
				font-size:14px;
				color:#666;
				border:1px solid #999;
				display:inline-block;
				padding:8px;
				cursor:pointer;
			}
			#top p span.on{
				border:2px solid #f60;
				padding:7px;
				background:url(img/on.png) no-repeat right bottom;
			}
			#bottom{
				width:600px;
				height:159px;
				padding-top:20px;
				font-family:'Microsoft yahei';
			}
			#bottom p font{
				color:#f60;
				font-size:20px;
				margin-right:20px;
			}
			#bottom p a{
				font-size:14px;
				color:blue;
			}
			#bottom p a i{
				margin:0 5px;
				color:#90c;
			}
			#bottom button{
				width:330px;
				height:50px;
				font-family:'Microsoft yahei';
				margin-top:20px;
				font-size:20px;
				background:#f60;
				color:#fff;
				border:none;
				
			}
		</style>
	</head>
	<body>
		
		<div id="wrap">
			<div id="top">
				<p id='model'>
					<font>评价</font>
					<span>1级</span>
					<span>2级</span>
					<span>3级</span>
					<span>4级</span>
					<span>5级</span>
				
				</p>
				<p id='color'>
					<font>颜色</font>
					<span>银色</span>
					<span>金色</span>
					<span>深空灰色</span>
				</p>
				<p id='rom'>
					<font>内存</font>
					<span>16GB</span>
					<span>64GB</span>
					<span>128GB</span>
				</p>
				
			</div>
			<div id="bottom">
				
				<a href=''><button>立即评价</button></a>
			</div>
		</div>

		<script type="text/javascript">
			
			var mSpan = document.getElementById('model').getElementsByTagName('span');
			var cSpan = document.getElementById('color').getElementsByTagName('span');
			var rSpan = document.getElementById('rom').getElementsByTagName('span');
			var bSpan = document.getElementById('banben').getElementsByTagName('span');
			var aSpan = document.getElementsByTagName('span');
			var oModel = document.getElementById('model');
			var oRom = document.getElementById('rom');
			var oPrice = document.getElementById('price');

			mSpan[0].className = 'on';
			cSpan[0].className = 'on';
			rSpan[0].className = 'on';
			bSpan[0].className = 'on';

			for (var i=0;i<aSpan.length;i++ )
			{
				
				aSpan[i].onclick = function(){
					var siblings = this.parentNode.children;
					for (var j=0;j<siblings.length;j++ )
					{
						siblings[j].className = '';
					}
					this.className = 'on';
					
					if ( this.parentNode == oModel || this.parentNode == oRom )
					{
						price();
					}
				};
			};

			
		</script>
		<div style="text-align:center;">
</div>
	</body>
</html>