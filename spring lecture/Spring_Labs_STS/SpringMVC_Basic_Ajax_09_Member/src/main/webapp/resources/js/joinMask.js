var joinMaskHeight = 300;
var joinMaskWidth  = 500;

function wrapWindowByMask()
{
	//화면의 높이와 너비를 구한다.
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();
	
	$('#mask').css({'width':maskWidth,'height':maskHeight});
	
	var joinMaskTop = ( maskHeight / 2 ) - (joinMaskHeight / 2);
	var joinMaskleft = ( maskWidth / 2 ) - (joinMaskWidth / 2);
	
	$('#joinMask').css({'width':joinMaskWidth,'height':joinMaskHeight, 'background-color':'#FFFFFF',
		'top':joinMaskTop, 'left':joinMaskleft});
	
	
	$('#mask').fadeTo("slow",0.8);
	$('#joinMask').fadeTo("slow",0.9);
	$('#loginMask').fadeTo("slow",1);
	$('#joinIFrame').attr('src','join.blog');
}

$(document).ready(function(){
	
	//검은 막을 눌렀을 때
	$('#mask').click(function () {  
	    $(this).hide();  
	    $('#joinMask').hide();
	});
});


$(window).resize(function(){ //창 사이즈 변환시
	
	var joinMaskTop =  ($(document).height() / 2) - (joinMaskHeight / 2);
	var joinMaskleft = ($(window).width() / 2) - (joinMaskWidth / 2);
	$('#mask').css({'width':$(window).width(),'height':$(window).height()});
	$('#joinMask').css({'top':joinMaskTop, 'left':joinMaskleft});
});

/*$(window).scroll(function(){
	$('#mask').css({'top':$(window).scrollTop(),'left':$(window).scrollLeft()});
});*/
