<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ page import = "java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<html>
<head><title>out</title></head>
<body>
<tf:out>
 <jsp:body><u>���� �ð�</u>�� <b>${dateEL}</b> �Դϴ�.</jsp:body>
</tf:out>

<br />

<tf:out>
 <%= new Date() %><u>���� �ð�</u>�� <b>${dateEL}</b> �Դϴ�.
</tf:out>

</body>
</html>
