<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기 화면</title>
</head>
<body>
	<h3>게시판 글쓰기 입력 폼</h3>
	<h3>form 태그에 action 주소가 없으면 현재 url창에 있는 주소가 전송 주소이다.</h3>
	<form method="post">
		<input type = "hidden" name="parentId" value="0">
		제목 : <input type="text" name="title"><br>
		내용 : <input type="text" name="content"><br>
			 <input type="submit" value="작성하기">
	</form>
</body>
</html>