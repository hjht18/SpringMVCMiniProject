<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>

<!-- Bootstrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>

<body>

	<div class="container">
		<h3>${product.name}</h3>
		<h3>${product.content }</h3>
		<h3>${product.code}</h3>
		<img src="${context}/resources/product_image/${product.image}">
		<div class="py-5 text-center">
			<h2>상품 상세</h2>
		</div>
		<div>
			<label for="itemId">상품 ID</label> <input type="text" id="itemId"
				name="itemId" class="form-control" value="1" readonly>
		</div>
		<div>
			<label for="itemName">상품명</label> <input type="text" id="itemName"
				name="itemName" class="form-control" value="상품A" readonly>
		</div>
		<div>
			<label for="price">가격</label> <input type="text" id="price"
				name="price" class="form-control" value="10000" readonly>
		</div>
		<hr class="my-4">
		<div class="row">
			<div class="col">
				<button class="w-100 btn btn-primary btn-lg" type="button">상품
					수정</button>
			</div>
			<div class="col">
				<button class="w-100 btn btn-secondary btn-lg"
					onclick="location.href='${context}/product/'" type="button">목록으로</button>
			</div>
		</div>
	</div>
</body>
</html>