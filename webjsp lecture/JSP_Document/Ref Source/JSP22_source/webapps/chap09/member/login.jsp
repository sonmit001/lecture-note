<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "util.CookieBox" %>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if (id.equals(password)) {
		// ID�� ��ȣ�� ������ �α��ο� ������ ������ �Ǵ�.
		response.addCookie(
			CookieBox.createCookie("LOGIN", "SUCCESS", "/", -1)
		);
		response.addCookie(
			CookieBox.createCookie("ID", id, "/", -1)
		);
%>
<html>
<head><title>�α��μ���</title></head>
<body>

�α��ο� �����߽��ϴ�.

</body>
</html>
<%
	} else { // �α��� ���н�
%>
<script>
alert("�α��ο� �����Ͽ����ϴ�.");
history.go(-1);
</script>
<%
	}
%>
