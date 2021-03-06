<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>INDEX</title>
<!-- Bootstrap CSS 링크 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Bootstrap JavaScript 파일 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
        /* style about Scrollspy & Affix */
body {
  position: relative;
}
.affix {
  top: 0;
  width: 100%;
  z-index: 9999;
}
.navbar {
  margin-bottom: 0px;
}
.affix ~ .container-fluid {
  position: relative;
  top: 50px;
}

/* jumbotron */

.jumbotron-imgs {
  margin: auto;
  background-color: transparent;
  background-image: url("images/jumbotron_coding.png");
  background-size: cover;
  background-repeat: no-repeat;
}

/* well-text */
.well-text {
  width: 70%;
  text-align: center;
  margin: auto;
  padding-left: 20px;
  padding-right: 20px;
  color: #000000;
  background-color: rgba(255, 255, 255, 0.6);
  border-style: none;
}

/* text-center */
.text-center {
	text-align: center;
}

/* footer */
.footer {
   position: fixed;
   left: 0;
   right: 0;
   bottom: 0;
   background-color: #000000;
   color: #FFFFFF;
   text-align: center;
}

/* navbar */
    /* 메뉴바 배경, 보더 색 */ 
.navbar-default { /* (variable) */
    background-color: #000000;
    border-color: #000000;
}
/* Title */
    /* 메뉴바의 메인 제목 */
.navbar-default .navbar-brand { /* (fixed) */
    color: #FFFFFF;
}
    /* 메뉴바의 메인 제목 마우스 호버 */
.navbar-default .navbar-brand:hover, /* (variable) */
.navbar-default .navbar-brand:focus {
    color: #5E5E5E;
}
/* Link */
    /* 링크 기본 */
.navbar-default .navbar-nav > li > a { /* (fixed) */
    color: #FFFFFF;
}
    /* 링크 마우스 호버*/
.navbar-default .navbar-nav > li > a:hover, /* (variable) */
.navbar-default .navbar-nav > li > a:focus {
    color: #5E5E5E;
}
    /* 링크 활성화되었을 때, 마우스 호버 */
.navbar-default .navbar-nav > .active > a, /* (variable) */
.navbar-default .navbar-nav > .active > a:hover,
.navbar-default .navbar-nav > .active > a:focus {
    color: #5E5E5E;
    background-color: #E7E7E7;
}
    /* 메뉴 클릭했을 때, 폰트, 배경색 */
.navbar-default .navbar-nav > .open > a, /* (fixed) */
.navbar-default .navbar-nav > .open > a:hover,
.navbar-default .navbar-nav > .open > a:focus {
    color: #000000;
    background-color: #FFFFFF;
}
/* Caret */
    /* 드롭다운메뉴의 화살표 기본 색 */
.navbar-default .navbar-nav > .dropdown > a .caret { /* (fixed) */
    border-top-color: #FFFFFF;
    border-bottom-color: #FFFFFF;
}
    /* 드롭다운메뉴의 화살표 마우스 호버 색 */
.navbar-default .navbar-nav > .dropdown > a:hover .caret, /* (fixed) */
.navbar-default .navbar-nav > .dropdown > a:focus .caret {
    border-top-color: #333;
    border-bottom-color: #333;
}
    /* 드롭다운메뉴의 화살표 클릭시 변경되는 색 */
.navbar-default .navbar-nav > .open > a .caret, /* (fixed) */
.navbar-default .navbar-nav > .open > a:hover .caret,
.navbar-default .navbar-nav > .open > a:focus .caret {
    border-top-color: #555;
    border-bottom-color: #555;
}
/* Mobile version */
    /* 모바일 반응형 메뉴 */
.navbar-default .navbar-toggle { /* (fixed) */
    border-color: #DDD;
}
.navbar-default .navbar-toggle:hover,
.navbar-default .navbar-toggle:focus { /* (fixed) */
    background-color: #DDD;
}
.navbar-default .navbar-toggle .icon-bar { /* (fixed) */
    background-color: #FFFFFF;
}
@media (max-width: 767px) {
    .navbar-default .navbar-nav .open .dropdown-menu > li > a { /* (fixed) */
        color: #FFFFFF;
    }
    .navbar-default .navbar-nav .open .dropdown-menu > li > a:hover,
    .navbar-default .navbar-nav .open .dropdown-menu > li > a:focus { /* (fixed) */
          color: #5E5E5E;
    }
}
    </style>
    <script type="text/javascript">
    $(function() { //$(documnet).ready(function() {...})
    	  //계절 이미지 정보 JSON(봄, 여름, 가을, 겨울)
    	  var seasonArr = {
    	    jumboSpring: 
    	      {
    	          image: 'url("images/spring.jpg")', //이미지 주소
    	          menuColor: '#d25386', //메뉴바 컬러
    	          hoverColor: '#ff0080' //마우스 호버 컬러
    	      },
    	    jumboSummer: 
    	      {
    	          image: 'url("images/summer.jpg")',
    	          menuColor: '#01dddd',
    	          hoverColor: '#00bfaf'
    	      },
    	    jumboFall: 
    	      {
    	          image: 'url("images/fall.jpg")',
    	          menuColor: '#a32a2a',
    	          hoverColor: '#d83000'
    	      },
    	    jumboWinter: 
    	      {
    	          image: 'url("images/winter.jpg")',
    	          menuColor: '#c8d3e5',
    	          hoverColor: '#9e94a5'
    	      }
    	  };
    	  //계절 버튼 클릭 시
    	  $('button.season').click(function() {
    	    var seasonId = $(this).attr('id'); //button id속성 변수 선언
    	    $.each(seasonArr, function(key, value) { //each로 반복문 실행
    	      if(key === seasonId) { //계절이미지 JSON의 key값과 버튼 클릭의 ID값이 같으면
    	        //상위 스크린 배경화면 css설정
    	        $('.jumbotron-imgs').css({ 'background-image': value.image });
    	        //메뉴바 배경, 보더 색 css설정
    	        $('.navbar-default').css({
    	            'background-color': value.menuColor,
    	            'border-color': value.menuColor
    	        });
    	        //메뉴바의 메인 제목 마우스 호버 css설정
    	        $('.navbar-brand').hover(function() {
    	            $(this).css({'color': value.hoverColor});
    	        }, function() {
    	            $(this).css({'color': ''});
    	        });
    	        //링크 마우스 호버 css설정 
    	        $('.navbar-nav > li > a').hover(function() {
    	            $(this).css({'color': value.hoverColor});
    	        }, function() {
    	            $(this).css({'color': ''});
    	        });  
    	        //링크 활성화되었을 때, 마우스 호버 css설정 
    	        $('.navbar-nav > .active > a').hover(function() {
    	            $(this).css({'color': value.hoverColor});
    	        }, function() {
    	            $(this).css({'color': ''});
    	        });
    	        //하단바 배경색 css설정
    	        $('.footer').css({ 'background-color': value.menuColor });    
    	      }; //end if
    	    }); //end each
    	  }); //end click

    	}); //end jQuery

    	// iframe 자동 사이즈 조절
    	// 해당 html파일의 사이즈를 받아 조절
    	function autoResize(i) {
    	    var iframeHeight = i.contentWindow.document.body.scrollHeight;
    	    i.height = iframeHeight + 500;
    	};
    </script>
</head>
<body>
	<!-- Header 영역 -->
	<tiles:insertAttribute name="header"/>
	<!-- Main 영역 -->
	<div id="main">
		<!-- Content영역 -->
		<tiles:insertAttribute name="content"/>
	</div>

	<!-- footer 영역 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>