// JavaScript Document
$(function(){	

	$(".menuson li").click(function(){

		$(".menuson li.active").removeClass("active")

		$(this).addClass("active");

	});

	
	$('.title').click(function(){
		
		if($(this).hasClass("active")) $(this).removeClass("active");
        else {$(".title").removeClass("active");$(this).addClass("active");}

		var $ul = $(this).next('ul');

		$('dd').find('ul').slideUp();

		if($ul.is(':visible')){

			$(this).next('ul').slideUp();

		}else{

			$(this).next('ul').slideDown();

		}

	});
	$('.left').css('left','0px');
	
	var expanded = true;
	
	$('.dl-second-slib').click(function(){
		if(expanded){
			$('.left').animate({left:'-246'},500);
			$('.dl-second-slib').addClass('dl-second-slibOn');
		}else{
			$('.left').animate({left:'0px'},500);
			$('.dl-second-slib').removeClass('dl-second-slibOn');
		}
		expanded = !expanded;
	});

})	