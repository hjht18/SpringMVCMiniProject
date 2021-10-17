<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 테스트</title>
</head>
<body>
	<form action="login.do" method="POST">
		아이디 : <input type="text" name="member_id">
		비밀번호 : <input type="text" name="password">
		<input type="submit" value="로그인">
	</form>
</body>
</html>