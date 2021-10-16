<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="insertBoard.do" method="post">
		ID : <input type="text" name="review_id">
		PASSWORD : <input type="text" name="review_score">
		CONTENT : <input type="text" name="review_content">
		<input type="submit" value="전송">
	</form>
	
</body>
</html>