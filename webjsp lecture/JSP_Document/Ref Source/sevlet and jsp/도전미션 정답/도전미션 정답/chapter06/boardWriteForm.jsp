<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��� �۾���</title>
<style type="text/css">
td
{
	border: 0;
}
#rowstyle{
	font-weight: bold;
	background-color: #e5e5e5;
	text-align: center;
}
</style>
</head>
<body>
	<center>
		<h2>�Խ��� �۾���</h2>
		<form method="post" action="boardWrite.jsp">
			<table border="1">
				<tr>
					<td id="rowstyle">�ۼ���</td>
					<td><input type="text" name="name"></td>

				</tr>
				<tr>
					<td id="rowstyle">��й�ȣ</td>
					<td><input type="password" name="pass">(�Խù� ���� ������ �ʿ��մϴ�.)</td>
				</tr>
				<tr>
					<td id="rowstyle">�̸���</td>
					<td><input type="text" size="50" name="email"></td>
				</tr>
				<tr>
					<td id="rowstyle">�� ����</td>
					<td><input type="text" size="80" name="title"></td>
				</tr>
				<tr>
					<td id="rowstyle" height="100px">�� ����</td>
					<td>
					<textarea cols="80" rows="20" name="content"></textarea>
					</td>
				</tr>
				<tr>
			</table>
			<input type="submit" value="���">
			<input type="reset" value="�ٽ��ۼ�">
		</form>
	</center>
</body>
</html>