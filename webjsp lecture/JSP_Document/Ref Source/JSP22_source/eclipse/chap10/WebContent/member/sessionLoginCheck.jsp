<%@ page contentType = "text/html; charset=euc-kr" %>
<%
    String memberId = (String)session.getAttribute("MEMBERID");
    boolean login = memberId == null ? false : true;
%>
<html>
<head><title>�α��ο��� �˻�</title></head>
<body>

<%
    if (login) {
%>
���̵� "<%= memberId %>"�� �α��� �� ����
<%
    } else {
%>
�α������� ���� ����
<%
    }
%>
</body>
</html>
