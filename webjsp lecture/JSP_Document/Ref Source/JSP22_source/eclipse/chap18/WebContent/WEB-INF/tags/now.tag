<%@ tag body-content="empty" pageEncoding="euc-kr" %>
<%@ tag import = "java.util.Calendar" %>
<%
	Calendar cal = Calendar.getInstance();
%>
<%= cal.get(Calendar.YEAR) %>��
<%= cal.get(Calendar.MONTH)+1 %>��
<%= cal.get(Calendar.DATE) %>��
