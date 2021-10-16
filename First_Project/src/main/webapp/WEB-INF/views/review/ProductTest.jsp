<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 선택 페이지</title>
</head>
<body>
	<%= session.getAttribute("member_id") %>
	<hr>
	<a href="selectProduct.do?product_id=1">첫 번째 상품</a><br>
	<a href="selectProduct.do?product_id=2">두 번째 상품</a><br>
	<a href="selectProduct.do?product_id=3">세 번째 상품</a><br>
	<a href="selectProduct.do?product_id=4">네 번째 상품</a><br>
	<a href="selectProduct.do?product_id=5">다섯 번째 상품</a><br>
		
</body>
</html>