<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<% request.setCharacterEncoding("utf-8");%>

<h2>입력 결과</h2>
<%
   int val = Integer.parseInt(request.getParameter("val"));
   String result = "";
   
   if (val >= 10) {//두개의 문자열이 같은가를 비교
 	   result = "10보다 크거나 같은 값";
   }else{
	   result = "10보다 작은 값";
   }
%>
<dl>
  <dd>입력값에 대한 결과:<%=result %></dd>
</dl>    