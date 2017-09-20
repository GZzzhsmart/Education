// JavaScript Document

$(function () {
$(window).scroll(function(){
if ($(window).scrollTop()>100){
$("#goTopBtn").fadeIn(1000);
}
else
{
$("#goTopBtn").fadeOut(800);
}
});
//当点击跳转链接后，回到页面顶部位置
$("#goTopBtn").click(function(){
$('body,html').animate({scrollTop:0},1000);
return false;
});
});