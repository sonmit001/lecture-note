<%@page import="vo.ChaVO"%>
<%@page import="dao.ChatDao"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
// * ����� ȸ�� �������� �ۼ��ϸ� �˴ϴ�.
/* response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Credentials","true"); */
String u_id = URLDecoder.decode(request.getParameter("u_id"),
		"utf-8");
String chat = URLDecoder.decode(request.getParameter("chat"),
		"utf-8");
System.out.println("u_id:"+u_id);
System.out.println("char"+chat);
	ChaVO v= new ChaVO();
	v.setU_id(u_id);// ä�û����
	v.setChat(chat);// ä�ø޼���
	v.setReip(request.getRemoteAddr());// ������
	ChatDao.getDao().insertChat(v);//mybatis���� �� ����
%>

