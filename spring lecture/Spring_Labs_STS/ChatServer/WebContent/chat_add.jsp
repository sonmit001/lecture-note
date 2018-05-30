<%@page import="vo.ChaVO"%>
<%@page import="dao.ChatDao"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
// * 허용할 회사 도메인을 작성하면 됩니다.
/* response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Credentials","true"); */
String u_id = URLDecoder.decode(request.getParameter("u_id"),
		"utf-8");
String chat = URLDecoder.decode(request.getParameter("chat"),
		"utf-8");
System.out.println("u_id:"+u_id);
System.out.println("char"+chat);
	ChaVO v= new ChaVO();
	v.setU_id(u_id);// 채팅사용자
	v.setChat(chat);// 채팅메세지
	v.setReip(request.getRemoteAddr());// 아이피
	ChatDao.getDao().insertChat(v);//mybatis에게 값 전달
%>

