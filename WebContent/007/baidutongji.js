var _hmt = _hmt || [];
_hmt.push(['_setAccount', '21f24b29afbcd9d16c10cc31c89e98cd']);

(function() {
/*	
 $.ajax({
		url:"/ajaxGetUserSomeProperty.do",
		type:"GET",
		dataType:"json",
		success:function(json){
			if(json.errCode==0){
				_hmt.push(['_setCustomVar', 1, 'login', 1, 2]);
				if(json.sUser.vip==1){
					_hmt.push(['_setCustomVar', 2, 'vip', 1, 1]);
				}
			}
		}
  });*/
 
  sendAjaxRequest("/ajaxGetUserSomeProperty.do");
 
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?21f24b29afbcd9d16c10cc31c89e98cd";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();

var XMLHttpReq;  
function createXMLHttpRequest() {  
    try {  
        XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");//IE高版本创建XMLHTTP  
    }  
    catch(E) {  
        try {  
            XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");//IE低版本创建XMLHTTP  
        }  
        catch(E) {  
            XMLHttpReq = new XMLHttpRequest();//兼容非IE浏览器，直接创建XMLHTTP对象  
        }  
    }  
  
}  
function sendAjaxRequest(url) {  
    createXMLHttpRequest();                                //创建XMLHttpRequest对象  
    XMLHttpReq.open("post", url, true);  
    XMLHttpReq.onreadystatechange = processResponse; //指定响应函数  
    XMLHttpReq.send(null);  
}  
//回调函数  
function processResponse() {  
    if (XMLHttpReq.readyState == 4) {  
        if (XMLHttpReq.status == 200) {  
            var jsonStr = XMLHttpReq.responseText;  
  
            /** 
             *实现回调 
             */  
            //text = window.decodeURI(text);  
            var json=eval("("+jsonStr+")");  
            if(json.errCode==0){
				_hmt.push(['_setCustomVar', 1, 'login', 1, 1]);
				if(json.sUser.vip==1){
					_hmt.push(['_setCustomVar', 2, 'vip', 1, 1]);
				}
				
				if(json.sUser.regDays<=7){
					_hmt.push(['_setCustomVar', 3, 'xp', 1, 1]);
				}
				
				if(json.sUser.isPay==0){
					_hmt.push(['_setCustomVar', 4, 'notPay', 1, 1]);
				}
				
			}
  
  
        }  
    }  
  
}

