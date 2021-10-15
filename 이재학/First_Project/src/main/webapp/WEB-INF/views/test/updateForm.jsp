<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 수정</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="../css/main.css">
<%
	pageContext.setAttribute("newLineChar", "\n");
%>
<c:set var="data" value="${article.content}" />
</head>

<body>
	<div class="container">
		<div class="box-wrapper">
			<form action="modify.do" method="post">
				<p>
					제목 : <br><input id="input_box" type="text" name="title" value="${article.title}">
				</p>
				<p>
					내용 : <br />
					<textarea id="textarea_box" name="content" rows="5" cols="30">${article.content}</textarea>
				</p>
				<input type="submit" value="게시글 수정">
			</form>
			<form action="/crud/index.jsp">
				<input type="submit" value="취소">
			</form>
		</div>
	</div>
</body>
</html>