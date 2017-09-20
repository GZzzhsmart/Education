function show(grade,subject){
	if(grade == 7){
		if(subject == "sx"){
			document.getElementById("sx7").style.display="";
			document.getElementById("yw7").style.display="none";
			document.getElementById("yy7").style.display="none";
		}else if(subject == "yy"){
			document.getElementById("sx7").style.display="none";
			document.getElementById("yy7").style.display="";
			document.getElementById("yw7").style.display="none";
		}else if(subject == "yw"){
			document.getElementById("sx7").style.display="none";
			document.getElementById("yy7").style.display="none";
			document.getElementById("yw7").style.display="";
		}
	}
	if(grade == 8){
		if(subject == "sx"){
			document.getElementById("sx8").style.display="";
			document.getElementById("yy8").style.display="none";
			document.getElementById("yw8").style.display="none";
			document.getElementById("wl8").style.display="none";
		}else if(subject == "yy"){
			document.getElementById("sx8").style.display="none";
			document.getElementById("yy8").style.display="";
			document.getElementById("yw8").style.display="none";
			document.getElementById("wl8").style.display="none";
		}else if(subject == "yw"){
			document.getElementById("sx8").style.display="none";
			document.getElementById("yy8").style.display="none";
			document.getElementById("yw8").style.display="";
			document.getElementById("wl8").style.display="none";
		}else if(subject == "wl"){
			document.getElementById("sx8").style.display="none";
			document.getElementById("yy8").style.display="none";
			document.getElementById("yw8").style.display="none";
			document.getElementById("wl8").style.display="";
		}
	}
	if(grade == 9){
		if(subject == "sx"){
			document.getElementById("sx9").style.display="";
			document.getElementById("yy9").style.display="none";
			document.getElementById("yw9").style.display="none";
			document.getElementById("wl9").style.display="none";
			document.getElementById("hx9").style.display="none";
		}else if(subject == "yy"){
			document.getElementById("sx9").style.display="none";
			document.getElementById("yy9").style.display="";
			document.getElementById("yw9").style.display="none";
			document.getElementById("wl9").style.display="none";
			document.getElementById("hx9").style.display="none";
		}else if(subject == "yw"){
			document.getElementById("sx9").style.display="none";
			document.getElementById("yy9").style.display="none";
			document.getElementById("yw9").style.display="";
			document.getElementById("wl9").style.display="none";
			document.getElementById("hx9").style.display="none";
		}else if(subject == "wl"){
			document.getElementById("sx9").style.display="none";
			document.getElementById("yy9").style.display="none";
			document.getElementById("yw9").style.display="none";
			document.getElementById("wl9").style.display="";
			document.getElementById("hx9").style.display="none";
		}else if(subject == "hx"){
			document.getElementById("sx9").style.display="none";
			document.getElementById("yy9").style.display="none";
			document.getElementById("yw9").style.display="none";
			document.getElementById("wl9").style.display="none";
			document.getElementById("hx9").style.display="";
		}
	}
}
function mycourse(url){
	$.get(url+"ajaxLoginJudge.do",{time:escape(new Date())}, function(user){
		if(user == ""){
			alert("请登陆并升级为VIP用户使用此功能。");
			window.location.href=url+"login.do";
		}else if(user == "novip"){
			alert("非常抱歉！此功能只有VIP用户才可以使用，快去升级为VIP用户吧！");
		}else if(user == "vip"){
			window.location.href=url+"mycourse_0_0.htm";
		}
	});
}

function addcourse(courseid){
	$.ajax({
	   type: "POST",
	   url: "ajaxAddCourse.do",
	   dataType:"text",
	   data: {courseid:courseid},
	   processData: true,
	   success: function(message){ 
        	alert(message);     
	   }
	});
}

function zhongkaoPlay(url,courseid,videoid){
	$.get(url+"ajaxLoginJudge.do",{time:escape(new Date())}, function(user){
		if(user != ""){
			window.location.href=url+"zhongkaoPlay_"+courseid+"_"+videoid+".htm";
		}else{
			alert("请先登陆后才能进行播放。");
			window.location.href=url+"login.do?forward="
			+ url +"zhongkaoPlay_"+courseid+"_"+videoid+".htm";     
		}				 	
	});
}
