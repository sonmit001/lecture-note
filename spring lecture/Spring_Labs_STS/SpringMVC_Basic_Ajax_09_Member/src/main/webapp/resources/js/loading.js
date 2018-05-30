var lodingImgHeight = 50;
var logingImgWidth  = 50;
	
function startLayer() 
{
	//화면의 높이와 너비를 구한다.
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();
	
	$('#loadingMask').css({'width':maskWidth,'height':maskHeight});
	
	var loadingTop = ( maskHeight / 2 ) - (lodingImgHeight / 2);
	var loadingLeft =  ( maskWidth / 2 ) - (logingImgWidth / 2);
	
	$('#loadingImage').css({'width':logingImgWidth,'height':lodingImgHeight, 'background-color':'#FFFFFF',
		'top':loadingTop, 'left':loadingLeft});
	
	$('#loadingMask').fadeTo("slow",0.9);
	$('#loadingImage').fadeTo("slow",0.9);
	
}

function stopLayer(massage)
{
	
	$('#loadingImage').fadeTo("slow",0.1);
	$('#loadingMask').fadeTo("slow",0.1);
	setTimeout('hideLayer('+massage+');',1000);
		
}

function hideLayer(massage)
{
	$('#loadingImage').hide();
	$('#loadingMask').hide();
	
	if (massage == 1) 
	{
		alert("회원가입이 정상적으로 처리 되었습니다.");
		$('#mask').hide();
		$('#joinMask').hide();
	}
	else 
	{
		alert("회원가입에 실패했습니다.");
		
	}
	
}

$(window).resize(function(){ //창 사이즈 변환시
	
	var loadingTop =  ($(document).height() / 2) - (lodingImgHeight / 2);
	var loadingLeft = ($(window).width() / 2) - (logingImgWidth / 2);
	$('#loadingMask').css({'width':$(window).width(),'height':$(window).height()});
	$('#loadingImage').css({'top':loadingTop, 'left':loadingLeft});
});

