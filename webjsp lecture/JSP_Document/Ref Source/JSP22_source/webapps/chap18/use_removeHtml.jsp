<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<html>
<head><title>removeHtml</title></head>
<body>
<c:set var="dateEL" value="<%= new Date() %>" />
<tf:removeHtml trim="true">
  <font size="10"> ���� <style>�ð�</style>�� ${dateEL} �Դϴ�. </font>
</tf:removeHtml>
<br>
<tf:removeHtml length="15" trail="..." trim="true">
  <u>���� �ð�</u>�� <b>${dateEL}</b> �Դϴ�.
</tf:removeHtml>
<br>
<tf:removeHtml length="15">
  <jsp:body><u>���� �ð�</u>�� <b>${dateEL}</b> �Դϴ�.</jsp:body>
</tf:removeHtml>

</body>
</html>
