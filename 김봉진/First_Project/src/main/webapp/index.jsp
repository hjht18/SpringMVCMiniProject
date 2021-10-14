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
	<a href="${context}/member/test.do">멤버 테스트</a><br>
	<a href="${context}/product/test.do">상품 테스트</a><br>
	<a href="${context}/review/getBoardList.do">리뷰 목록 테스트</a><br>	
	<a href="${context}/review/indexTest.do">리뷰 인덱스 테스트</a><br>
	<hr>	
	<a href="${context}/member/login.do">로그인 페이지</a>
	<a href="${context}/product/list.do">상품 페이지</a><br>
	<hr>
	<a href="${context}/member/register.do">회원가입</a><br>
	<a href="${context}/member/unregister.do">회원탈퇴</a><br>
	<a href="${context}/member/modify.do">회원정보 수정</a><br>
	<a href="${context}/member/loginForm.do">로그인 폼</a><br>
	
</body>
</html>