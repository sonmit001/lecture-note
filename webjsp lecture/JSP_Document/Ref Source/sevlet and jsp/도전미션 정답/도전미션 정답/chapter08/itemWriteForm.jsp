<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		<h2>���� �Է� ��</h2>
		<form method="post" action="itemWriteResult.jsp">
			<table>
				<tr>
					<td id="rowstyle">��ǰ��</td>
					<td><input type="text" name="name"></td>

				</tr>
				<tr>
					<td id="rowstyle">����</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr> 
					<td id="rowstyle" height="100px">����</td>
					<td>
					<textarea cols="80" rows="10" name="description"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="����">
						<input type="reset" value="���">
					</td>
				</tr>
				<tr>
			</table>
			
		</form>
</body>
</html>