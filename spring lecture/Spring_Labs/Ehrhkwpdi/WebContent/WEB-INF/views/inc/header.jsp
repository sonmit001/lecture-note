<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 상위 스크린 -->
<div class="container jumbotron jumbotron-imgs">
  <!-- 계절 테마 버튼 -->
  <div class="btn-group">
    <button type="button" class="btn btn-default btn-xs season" id="jumboSpring">SPRING</button>
    <button type="button" class="btn btn-default btn-xs season" id="jumboSummer">SUMMER</button>
    <button type="button" class="btn btn-default btn-xs season" id="jumboFall">FALL</button>
    <button type="button" class="btn btn-default btn-xs season" id="jumboWinter">WINTER</button>
  </div>
  <div class="well well-sm well-text">
    <h1>{ Bitcamp Group 3 }</h1>
    <p>Make it work! Make it right! Make it fast!</p>
  </div>
</div>
<!-- 메뉴 바  -->
<nav class="container navbar navbar-inverse navbar-default" data-spy="affix" data-offset-top="197">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="home.html" target="contents">{ Bitcamp Group 3 }</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">WEB <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="fileupload.html" target="contents">fileupload</a></li>
            <li><a href="drag_drop.html" target="contents">Drag&Drop</a></li>
            <li><a href="mousehover.html" target="contents">MouseHover</a></li>
            <li><a href="GIFfile.html" target="contents">GIFfile</a></li>
          </ul>
        </li>
        <li><a href="dragGIFupload.html" target="contents">Combination</a></li>
        <li><a href="jqueryUI_Football/index.html" target="contents">jQueryUI</a></li>
        <li><a href="chart.html" target="contents">Chart</a></li>
        <li><a href="papagoHTML.html" target="contents">Translation</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="introduce.htm">게시판</a></li>
        <li><a href="join.htm">회원가입</a></li>
        <li><a href="login.htm" >로그인</a></li>
      </ul>
    </div>
  </div>
</nav>