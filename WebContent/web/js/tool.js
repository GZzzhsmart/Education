// JavaScript Document
//处理左侧导航
function autoHeight() {
var w = $(window).width();
nw = w/2;
if(nw>600){
$("#left_nav").css('left', nw-600);
}else{
$("#left_nav").css('left', 0);
}
}
var d;
    window.onload = window.onscroll = function () {
       d = document.getElementById("d");
       //d.innerHTML = document.documentElement.scrollTop;
	   //var h = document.documentElement.scrollTop;
	   var h = document.documentElement.scrollTop || window.pageYOffset || document.body.scrollTop;
	  /* if(h>151){
		   		$("#left_nav").css('position', 'fixed');
				$("#left_nav").css('top', 0);
		   }else{
		   		$("#left_nav").css('position', 'absolute');
				$("#left_nav").css('top', 151);
		   }
		   */
    }
$(function() {
autoHeight()
$(window).resize(autoHeight);
})
//处理搜索下拉菜单
$(document).ready(function() {
            $(".tdwt dt a").click(function() {
                $(".tdwt dd ul").toggle();
            });
            $(".tdwt dd ul li a").click(function() {
                var text = $(this).html();
                $(".tdwt dt a span").html(text);
                $(".tdwt dd ul").hide();
				window.document.frm_add.searchtype.value=getSelectedValue("tdwt");
            });
            function getSelectedValue(id) {
                return $("#" + id).find("dt a span.value").html();
            }
            $(document).bind('click', function(e) {
                var $clicked = $(e.target);
                if (! $clicked.parents().hasClass("tdwt"))
                    $(".tdwt dd ul").hide();
				});
        });