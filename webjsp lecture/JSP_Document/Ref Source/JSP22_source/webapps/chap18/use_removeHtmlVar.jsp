<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<html>
<head><title>removeHtmlVar</title></head>
<body>
<c:set var="dateEL" value="<%= new Date() %>" />
<tf:removeHtmlVar trim="true" var="removed">
  <font size="10"> ���� <style>�ð�</style>�� ${dateEL} �Դϴ�. </font>
</tf:removeHtmlVar>

ó�����: ${removed}

</body>
</html>
