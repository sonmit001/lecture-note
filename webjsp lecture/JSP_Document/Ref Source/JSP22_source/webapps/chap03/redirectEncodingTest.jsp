<%@ page import = "java.net.URLEncoder" %>
<%@ page pageEncoding="euc-kr" %>
<%
	String value = "�ڹ�";
	String encodedValue = URLEncoder.encode(value, "euc-kr");
	response.sendRedirect("/chap03/index.jsp?name=" + encodedValue);
%>
