<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<%
  String fileName = request.getRequestURI();
  application.log("My Log : " + fileName + " 에서 작성");
%>
