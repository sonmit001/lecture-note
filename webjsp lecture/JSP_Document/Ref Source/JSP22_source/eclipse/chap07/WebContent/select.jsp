<%@ page contentType = "text/html; charset=euc-kr" %>
<html>
<head><title>�ɼ� ���� ȭ��</title></head>
<body>

<form action="<%= request.getContextPath() %>/view.jsp">

���� ���� ������ ����:
    <select name="code">
        <option value="A">A ������</option>
        <option value="B">B ������</option>
        <option value="C">C ������</option>
    </select>

<input type="submit" value="�̵�">

</form>

</body>
</html>
