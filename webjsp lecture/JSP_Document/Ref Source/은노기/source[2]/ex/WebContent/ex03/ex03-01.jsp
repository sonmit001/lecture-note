<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>
<title>ex03-01</title>
</head>
<body>
<%
  String id = "abcd";
  String name = "test";
%>
<dl>
  <dd>아이디:<%=id %></dd>
  <dd>이름:<%=name %></dd>
</dl>
</body>
</html>