<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>관리자 페이지 (상품 등록)</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<%
	pageContext.setAttribute("newLineChar", "\n");
%>
<c:set var="data" value="${product.content}" />
</head>
<body>
	<div class="container">
		<div class="box-wrapper">
			<form action="registerProduct.do" method="post">
				<p>
					상품명 : <br><input id="input_box" type="text" name="name" value="${param.name}">
				</p>
				<p>
					상품 설명 : <br>
					<textarea id="textarea_box" name="content" rows="5" cols="30">${param.content}</textarea>
				</p>
				<p>
					상품가격 : <br><input id="input_box" type="number" name="price" value="${param.price}">
				</p>
				<p>
					상품이미지: <br><input id="input_box" type="text" name="image" value="${param.image}">
				</p>
				<input type="submit" value="상품 등록">
			</form>
			<form action="/index.jsp">
				<input type="submit" value="취소">
			</form>
		</div>
	</div>
</body>
</html>