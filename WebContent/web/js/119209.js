
















if(typeof doyoo=='undefined' || !doyoo){
var d_genId=function(){
    var id ='',ids='0123456789abcdef';
    for(var i=0;i<34;i++){ id+=ids.charAt(Math.floor(Math.random()*16));  }  return id;
};
var doyoo={
env:{
secure:false,
mon:'http://m155.looyu.com/monitor',
chat:'http://ali218.looyu.com/chat',
file:'http://static.doyoo.net/110402',
compId:51473,
confId:119209,
vId:d_genId(),
lang:'',
fixFlash:0,
subComp:0
}

, monParam:{
index:1,

title:'\u5728\u7ebf\u5ba2\u670d',
text:'\u5c0a\u656c\u7684\u540c\u5b66\u60a8\u597d\uff0c\u6b22\u8fce\u5149\u4e34\u5fb7\u7acb\u6559\u80b2\u5b98\u7f51\uff01\u6211\u4eec\u53ef\u4ee5\u5e2e\u60a8\u89e3\u7b54\u5173\u4e8e\u5b66\u4e60\u7684\u7591\u95ee\uff0c\u6211\u662f\u4eca\u5929\u7684\u5728\u7ebf\u503c\u73ed\u5ba2\u670d\uff0c\u5f88\u9ad8\u5174\u4e3a\u60a8\u670d\u52a1!',
auto:2,
group:'',
start:'00:00',
end:'24:00',
mask:false,
status:false,
fx:1,
mini:0,
pos:0,
offShow:0,
loop:15,
autoHide:0,
hidePanel:0,
miniStyle:1,
monHideStatus:[0,0,0],
monShowOnly:''
}


, panelParam:{
category:'icon',
position:1,
vertical:120,
horizon:5


,mode:1,
target:'76104',
online:'http://res.delijy.com/Public/images/ckzxtb.png',
offline:'http://res.delijy.com/Public/images/ckzxtb.png',
width:152,
height:342,
status:0,
closable:0


}


};


document.write('<div id="doyoo_panel"></div>');


document.write('<div id="doyoo_monitor"></div>');

document.write('<div id="doyoo_share" style="display:none;"></div>');
document.write('<lin'+'k rel="stylesheet" type="text/css" href="http://static.doyoo.net/110402/looyu.css?140702"></li'+'nk>');
document.write('<scr'+'ipt type="text/javascript" src="http://static.doyoo.net/110402/looyu.js?141104"></scr'+'ipt>');

}

