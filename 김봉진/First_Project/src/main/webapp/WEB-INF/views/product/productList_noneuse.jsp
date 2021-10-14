<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 페이지</title>
<!-- Bootstrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
	<!-- <form action="${context}/product/saveImgTest" method="post">
		<input type="file" name="imgTest">
		<input type="submit" value="등록">
	</form>  -->
	
	<div class="container">
		<a href="${context}/product/detail.do"><img src="../resources/image/productTest.png"></a>
		<div class="py-5 text-center">
			<h2>상품 목록</h2>
		</div>
		<div class="row">
			<div class="col">
				<button class="btn btn-primary float-end" type="button">상품 등록</button>
			</div>
		</div>
		<hr class="my-4">
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>CODE</th>
						<th>상품명</th>
						<th>설명</th>
						<th>가격</th>
						<th>이미지 경로</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="p" items="${productList}">
					<tr>
						<td>${p.code}</td>
						<td>${p.name}</td>
						<td><a href="${context}/product/detail.do?code=${p.code}">${p.content}</a></td>
						<td>${p.price}</td>
						<td>${p.image}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
</body>
</html>