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
	<!-- css영역 -->
	  
	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>

<body>
	<!-- Header 영역 -->
	<tiles:insertAttribute name="header"/>
	
	<div id="main">
		<div class="top-wrapper clear">
			<!-- Content영역 -->
			<tiles:insertAttribute name="content"/>
			
		</div>
	</div>
	<!-- footer영역 -->
	<tiles:insertAttribute name="footer"/>
</body>
</html>