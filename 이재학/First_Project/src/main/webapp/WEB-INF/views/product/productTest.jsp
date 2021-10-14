<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}" />

<%
pageContext.setAttribute("newLineChar", "\n");
%>
<!-- 글 내용 개행 처리 -->
<c:set var="data" value="${product.content}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 테스트 페이지</title>
</head>
<body>
	<h3>상품 테스트 페이지</h3>
	<a href="${context}/product/info">상품 상세 페이지</a>
	<h3>코드 : ${product.code}</h3>
	<h3>제목 : ${product.name}</h3>
	<h3>내용 : ${fn:replace(data, newLineChar, "<br> ")}</h3>
	<h3>가격 : ${product.price}</h3>
	이미지 : <br><img src="${context}/resources/product_image/${product.image}">
</body>
</html>