<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"  %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>
		<!-- title영역 -->
		<tiles:getAsString name="title"/>
	</title>
	<link href="notice.css" type="text/css" rel="stylesheet">
</head>

<body>
	<!-- Header 영역 -->
	<tiles:insertAttribute name="header"/>
	<!-- Visual 영역 -->
	<tiles:insertAttribute name="visual"/>
	<div id="main">
		<div class="top-wrapper clear">
			<!-- Content영역 -->
			<tiles:insertAttribute name="content"/>
			<!-- Aside 영역 -->
			<tiles:insertAttribute name="aside"/>
		</div>
	</div>
	<!-- footer영역 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>