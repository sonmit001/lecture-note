<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.io.*" %>
<html>
<head><title>���� ��� ����Ͽ� �ڿ� �б�</title></head>
<body>

<%
	FileReader fr = null;
	char[] buff = new char[512];
	int len = -1;
	
	try {
		fr = new FileReader(
			"C:\\apache-tomcat-7.0.27\\webapps\\chap06"+
			"\\message\\notice\\notice.txt");
		
		while ( (len = fr.read(buff)) != -1) {
			out.print(new String(buff, 0, len));
		}
	} catch(IOException ex) {
		out.println("�ͼ��� �߻�: "+ex.getMessage());
	} finally {
		if (fr != null) try { fr.close(); } catch(IOException ex) {}
	}
%>

</body>
</html>
