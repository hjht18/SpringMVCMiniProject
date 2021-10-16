<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
    <title>리뷰 게시판</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
    <link href="css/style.css?ver=4" rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
    <script src="js/jquery.js?ver=4"></script>
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
            <%= session.getAttribute("member_id") %>
            <%= session.getAttribute("product_id") %>
        </div>
        <hr class="l1">
        <div class="review">
            <div>
                <table class="table table-hover">       <!-- AJAX로 리뷰 넣을 공간 -->
                </table>
                <ul class="pagination">
  					<li class="page-item"><a class="page_box_sub page-link" href="getBoardList.do?reviewBoxSub='true'">Previous</a></li>
  					<!--  <li class="page-item"><input class="page_box_sub page-link" type="button" value="Previous"></li> -->
  					<c:forEach begin="${ pageRange.bottom }" end="${pageRange.top}" step="1" var="index">
  						<!-- <li class="page-item"><a class="page-link" value="${index}" href="getBoardList.do">${index}</a></li> -->
  						<li class="page-item"><input class="pNum page-link" type="button" value="${index}"></li> 
  					 </c:forEach>
  					 
  					<li class="page-item"><a class="page_box_add page-link" href="getBoardList.do?reviewBoxAdd=true">Next</a></li>
  					<li class="page-item"><a class="insertReview page_box_add page-link data-bs-toggle='modal' data-bs-target='#insertReview'" href="getBoardList.do">글쓰기</a></li>
  					 <!-- <li class="page-item"><input class="page_box_add page-link" type="button" value="Next"></li>-->
		  	   </ul>
           </div>
        </div>
    </div>
    <!-- The Modal(updateReview) -->
    <div class="modal" id="updateReview">
       <div class="modal-dialog modal-lg">
         <div class="modal-content">
     
           <!-- Modal Header -->
           <div class="modal-header">
               <ul>
                   <li>
                       제목 <input type="text" class="title" name="review_title">
                       
                   </li>
                   <li>
                       평점 <input class="score" type="text" name="review_title">
                       &emsp;아이디 <span class="id" name="review_id"></span>
                       &emsp;수정 날짜 <span class="regdate" name="review_regdate"></span>
                   </li> 
               </ul>
           </div>
     
           <!-- Modal body -->
           <div class="modal-body">
               &emsp;&emsp;게시글 내용<br>
               &emsp;&emsp;<textarea class="content" name="review_content"></textarea>
               &emsp;&emsp;<div class="upload_content">
                   upload..
               </div>
           </div>
     
           <!-- Modal footer -->
           <div class="modal-footer">
               <button type="button" class="btn btn-info" data-bs-dismiss="modal">업로드</button>
               <button type="button" class="btn btn-primary" data-bs-dismiss="modal">수정하기</button>
               <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
           </div>
         </div>
       </div>
     </div> 
     
     <!-- The Modal(updateReview) -->
    <div class="modal" id="updateReview">
       <div class="modal-dialog modal-lg">
         <div class="modal-content">
     
           <!-- Modal Header -->
           <div class="modal-header">
               <ul>
                   <li>
                       제목 <input type="text" class="title" name="review_title">
                       
                   </li>
                   <li>
                       평점 <input class="score" type="text" name="review_title">
                       &emsp;아이디 <span class="id" name="review_id"></span>
                       &emsp;수정 날짜 <span class="regdate" name="review_regdate"></span>
                   </li> 
               </ul>
           </div>
     
           <!-- Modal body -->
           <div class="modal-body">
               &emsp;&emsp;게시글 내용<br>
               &emsp;&emsp;<textarea class="content" name="review_content"></textarea>
               &emsp;&emsp;<div class="upload_content">
                   upload..
               </div>
           </div>
     
           <!-- Modal footer -->
           <div class="modal-footer">
               <button type="button" class="btn btn-primary" data-bs-dismiss="modal">저장하기</button>
               <button type="button" class="btn btn-danger" data-bs-dismiss="modal">닫기</button>
           </div>
         </div>
       </div>
     </div> 
     
     
     
</body>
</html>