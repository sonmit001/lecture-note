<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<!-- ******HEADER****** -->
<header id="header" class="header navbar-fixed-top">
	<div class="container">
		<h1 class="logo">
			<a href="index.htm"><span class="text">보람 4조</span></a>
		</h1>
		<!--//logo-->
		<nav class="main-nav navbar-right" role="navigation">
			<div class="navbar-header">
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!--//nav-toggle-->
			</div>
			<!--//navbar-header-->
			<div id="navbar-collapse" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active nav-item"><a href="index.htm">Home</a></li>
					<li class="nav-item"><a href="chat.htm">Chatting</a></li>
					<li class="nav-item"><a href="chat.htm">미구현</a></li>
					<li class="nav-item dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" data-hover="dropdown" data-delay="0"
						data-close-others="false" href="#">미구현 <i
							class="fa fa-angle-down"></i></a>
						<ul class="dropdown-menu">
							<li><a href="download.html">김선화는</a></li>
							<li><a href="blog.html">이쁘다</a></li>
							<li><a href="blog-single.html">뻥이다</a></li>
							<li><a href="blog-category.html">ㅋㅋㅋ</a></li>
						</ul></li>
					<!--//dropdown-->
					<li class="nav-item nav-item-cta">
					<sec:authorize access="!hasRole('ROLE_USER')">
						<a class="btn btn-cta btn-cta-secondary" href="login.htm">로그인</a>
					</sec:authorize>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN, ROLE_USER')">
					<sec:authentication property="name" var="loginUser" />
					<a class="btn btn-cta btn-cta-secondary" href="${pageContext.request.contextPath}/logout">${loginUser}님 로그아웃</a>
					</sec:authorize>
					</li>
					<sec:authorize access="hasAnyRole('ROLE_ADMIN, ROLE_USER')">
					</sec:authorize>
					<sec:authorize access="!hasRole('ROLE_USER')">
					<li class="nav-item nav-item-cta last">
						<a class="btn btn-cta btn-cta-secondary" href="join.htm">회원가입</a>
					</li>
					</sec:authorize>
				</ul>
				<!--//nav-->
			</div>
			<!--//navabr-collapse-->
		</nav>
		<!--//main-nav-->
	</div>
	<!--//container-->
</header>
<!--//header-->