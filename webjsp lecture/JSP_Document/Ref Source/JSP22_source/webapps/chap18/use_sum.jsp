<%@ page contentType = "text/html; charset=euc-kr" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<html>
<head><title>sum ���</title></head>
<body>

<tf:sum begin="1" end="10">
1-10���� �� : ${sum} 
</tf:sum>

</body>
</html>
