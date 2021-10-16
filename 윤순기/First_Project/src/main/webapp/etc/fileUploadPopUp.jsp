<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <meta charset='utf-8'>
    <title>리뷰 게시판</title>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-1.12.3.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/addFileJs.js"></script>
</head>
<body>
     <p>drag and drop your image!</p>
     


      	<form method="post" action="file/upload" enctype="multipart/form-data">
		     <div class=content></div>
		     <input type="file" name="uploadFile"><br>    
	 		 <button type="submit">파일 업로드</button><br><br>
     	<br>

	 	<div class="d_file">
	 	</div><br><br>
	 	<input type="submit" value="확인"/>
 	</form>


             
</body>
</html>