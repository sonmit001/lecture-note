<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�Խ��� �۾���</title>
<style type="text/css">
#rowstyle{
	font-weight: bold;
	text-align: center;
}
</style>
</head>
<body>
	<center>
		<h2>�Խ��� �۾���</h2>
		<form method="post" action="movieWrite.jsp">
			<table>
				<tr>
					<td id="rowstyle">����</td>
					<td><input type="text" name="name"></td>

				</tr>
				<tr>
					<td id="rowstyle">����</td>
					<td><input type="text" name="price">��</td>
				</tr>
				<tr>
					<td id="rowstyle">����</td>
					<td><input type="text" name="director"></td>
				</tr>
				<tr>
					<td id="rowstyle">�⿬���</td>
					<td><input type="text" name="actor"></td>
				</tr>
				<tr>
					<td id="rowstyle" height="100px">�ó�ý�</td>
					<td>
					<textarea cols="80" rows="20" name="synopsis"></textarea>
					</td>
				</tr>
				<tr>
					<td id="rowstyle">�帣</td>
					<td>
					<select name="genre">
						<option value="�θǽ�">�θǽ�</option>
						<option value="������">������</option>
						<option value="�̽��͸�">�̽��͸�</option>
						<option value="�׼�" selected="selected">�׼�</option>
						<option value="�ڹ̵�">�ڹ̵�</option>
						<option value="�ִϸ��̼�">�ִϸ��̼�</option>
					</select>
					</td>
				<tr>
			</table>
			<input type="submit" value="���">
			<input type="reset" value="�ٽ��ۼ�">
		</form>
	</center>
</body>
</html>