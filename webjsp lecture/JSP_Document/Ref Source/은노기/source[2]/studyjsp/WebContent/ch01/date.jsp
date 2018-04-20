<!--date.jsp-->
<!--jsp예제-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP예제</title>
</head>
<body>
<% 
  Date nowDate = new Date();//현재날짜와 시간을 얻어옴
  //날짜형식을 yyyy년MM월dd일형태로 사용하기위해서 SimpleDateFormat객체 생성
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");
  //현재의 날짜와 시간에 yyyy년MM월dd일형식을 format( )메소드를 사용해서 적용
  String formatDate = dateFormat.format(nowDate);
%>
  <p> 일반적인 JSP 페이지의 형태로 아래와 같이 현재 날짜를 제공합니다.<br/>
   현재 날짜는 <%= formatDate%> 입니다.</p>
</body>
</html>