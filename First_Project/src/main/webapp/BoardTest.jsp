<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>리뷰 게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-1.12.3.js"></script>
    <script src="js/jquery.js"></script>
</head>
<body>
    <header>
        <div class="container mt-3">
            <ul class="nav nav-tabs" id="nav">
                <li class="nav-item"><a href="#" class="nav-link">상품정보</a></li>
                <li class="nav-item"><a href="#" class="nav-link">상세정보</a></li>
                <li class="nav-item"><a href="#" class="nav-link">FAQ</a></li>
                <li class="nav-item"><a href="#" class="nav-link active">고객후기</a></li>
            </ul>
        </div> 
    </header>

    <div class="c_image">
        <h6 class="image-count">고객 후기 사진(7)</h6>
        <hr class="l1">
        <div class="image">
            ...
        </div>
    </div>

    <div class="c_review">
        <h6>고객 후기</h6>
        <hr class="l1">
        <div class="review_score">
            ...
        </div>
        <hr class="l1">
        <div class="review">
            <div class="container mt-3">
                <table class="table table-hover">
                  <tbody>
                  <c:forEach items="${ boardList }" var="board">
                    <tr>
                        <td>${board.review_score}</td>
                        <td>${board.review_content}</td>
                        <td>${board.review_id}</td>
                        <td>${board.review_regdate}</td>
                    </tr>
                   </c:forEach>
                  </tbody>
                </table>
                <ul class="pagination pagination-lg">
  					<li class="page-item"><a class="page-link" href="#">Previous</a></li>
  					<li class="page-item"><a class="page-link" href="#">1</a></li>
  					<li class="page-item"><a class="page-link" href="#">2</a></li>
  					<li class="page-item"><a class="page-link" href="#">3</a></li>
  					<li class="page-item"><a class="page-link" href="#">Next</a></li>
		  	   </ul>
           </div>
        </div>
    </div>
             
</body>
</html>