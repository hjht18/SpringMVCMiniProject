<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}" />

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