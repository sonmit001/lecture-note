<%@page import="java.util.List"%>
<%@page import="dao.ChatDao"%>
<%@page import="vo.ChaVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page trimDirectiveWhitespaces="true" %>

<%
    response.setContentType("text/event-stream");
	/* response.setHeader("cache-control", "no-cache");
	response.setHeader("Access-Control-Allow-Origin", "*");
	response.setHeader("Access-Control-Allow-Credentials","true"); */
	List<ChaVO> list = ChatDao.getDao().getList();
	StringBuffer outs=new StringBuffer();
	//out.write("retry:3000\n");
	
	outs.append("data:");
	for (ChaVO e : list) {
		outs.append(e.getU_id());
		outs.append("/");
		outs.append(e.getChat());
		outs.append(":");
    }
	out.write(outs.toString());
	out.newLine();out.newLine();
	out.flush();
%>

