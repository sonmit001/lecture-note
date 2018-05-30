<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title>Chat</title>
<link rel="stylesheet"
	href="resources/chat/bootstrap-3.0.3/css/bootstrap.css">

<script src="resources/chat/jquery/jquery-1.10.2.js"></script>
<script src="resources/chat/bootstrap-3.0.3/js/bootstrap.js"></script>
<script src="resources/chat/sockjs/sockjs-0.3.js"></script>

<style>
.contentDiv {
	width: 100%;
	height: 400px;
	border-color: #dddddd;
	border-width: thin;
	border-style: solid;
	border-radius: 4px;
	display: block;
	padding: 5px;
	overflow: auto;
}

.username {
	font-weight: bold;
	color: #555599;
}
</style>
</head>
</html>

			<tiles:insertAttribute name="content" />
