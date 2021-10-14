<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}"/>

<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h3>메인 페이지</h3>
	<h5>${login}</h5>
	<br><br>
	<a href="${context}/member/test">멤버 테스트</a><br>
	<a href="${context}/product/test">상품 테스트</a><br>
	<a href="${context}/review/test">리뷰 테스트</a><br>	
	<hr>	
	<a href="${context}/login">로그인 페이지</a>
	<a href="${context}/product/">상품 페이지</a><br>
	
</body>
</html>