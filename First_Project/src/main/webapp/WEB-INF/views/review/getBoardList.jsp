<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>PRODUCT</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="/css/style2.css" type="text/css">
    <link href="/css/style-soon.css?ver=2" rel="stylesheet">
	
	<!-- Js Plugins -->
    <script src="/js/jquery-3.3.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/jquery.nice-select.min.js"></script>
    <script src="/js/jquery-ui.min.js"></script>
    <script src="/js/jquery.slicknav.js"></script>
    <script src="/js/mixitup.min.js"></script>
    <script src="/js/owl.carousel.min.js"></script>
    <script src="/js/main.js"></script>
    <script src="/js/jquery-soon.js?ver=1"></script>
	
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>
 
    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                            <img class="product__details__pic__item--large" src="https://s3.ap-northeast-2.amazonaws.com/freshcode/menu/origin/14_20211015180633" alt="salad">
                        </div>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>아쉬파 샐러드</h3>
                        <p style="font-size: 12px">부드러운 생아보카도와 탱글한 갈릭쉬림프 그리고 달콤상큼한 파인애플의 깔끔한 피니시</p>
                            <p style="font-size: 15px; color: #252525;">"[아]보카도 • [쉬]림프 • [파]인애플"</p>
                            <p style="font-size: 14px">무엇하나 뺄 수 없는, 최고의 조합을 샐러드로!?<br>중독적인 단짠단짠의 조화와 아삭 탱글 식감까지.<br>좋아할 수 밖에 없는 프리미엄 샐러드 :)</p>
                        </div>
                        <div class="product__details__price"><strong>${product.formattedPrice}</strong></div><hr>
                        <p style="font-size: 14px">상품설명<br>
                            [재료 및 드레싱]<br>
                            		아보카도·갈릭쉬림프·파인애플·적양파·스위트콘·할라피뇨<br>
									블랙올리브·파프리카·방울토마토·샐러드믹스 + 유자드레싱
                            		<br>
                            		* 아보카도 후숙으로 인해 거뭇거뭇하게 변할 수 있으나,
									품질에는 이상이 없으니 안심하고 드셔도 됩니다.
									제품 선선도를 위해 당일 섭취를 강력 권장합니다!<br>
                            		*파우치 드레싱은 샐러드 용기 위에 스티커 부착 되어 제공 됩니다.</p>
                        <div class="product__details__quantity">
                            <div class="quantity">
                                <div class="pro-qty">
                                    <input type="text" value="1">
                                </div>
                            </div>
                        </div>
                        <a href="#" class="primary-btn">장바구니에 담기</a>
                    </div>
                </div>
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">상세 설명</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">배송 정보</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">후기 <span>(0)</span></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <img alt="product1" src="https://s3.ap-northeast-2.amazonaws.com/freshcode/menu/content/origin/7552_20210629172226">
                                    ....
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <img alt="deilvery" src="https://s3.ap-northeast-2.amazonaws.com/freshcode/menu/content/origin/7961_20210707162002">
											...                                    
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
<!-- ############################################ review Board Start ############################################ -->                                
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
								  					<li class="page-item"><a href="#" class="reviewCreateModal page_box_add page-link" data-toggle="modal" data-target="#reviewModal">글쓰기</a></li>
								  					 <!-- <li class="page-item"><input class="page_box_add page-link" type="button" value="Next"></li>-->
										  	   </ul>
								           </div>
								        </div>
								    </div>
								    
									<!-- The Modal(updateReview) -->
									<div class="modal fade" id="reviewModal">
									   <div class="modal-dialog">
									     <div class="modal-content">
									         <form action="./test.do" method="get">
									       <!-- Modal Header -->
									           <div class="modal-header">
									               <ul>
									                   <li> 
									                        <div class="reviewHeade update"> 
									                                                게시글 수정
									                        </div>
									                        <div class="reviewHeade insert">
									                                                게시글 생성
									                        </div>
									                        <div class="reviewHeade select">
									                           	게시글
									                        </div>
									                    </li>
									                    <li>
									                        <div class="insert">
									                                                   아이디 <input class="input" type="text" name="review_id">
									                             &emsp;&emsp;평점 <input class="score" type="text" name="review_score">
									                             &emsp;&emsp;수정 날짜 <input class="input" type="text" name="review_regdate">
									                        </div>
									                        <div class="update">
									                                                   아이디<span class="id"></span>
									                             &emsp;&emsp;평점 <input class="score" type="text" name="review_score">
									                             &emsp;&emsp;수정 날짜 <span class="regdate" name="review_regdate"></span>
									                        </div>
									                        <div class="select">
									                                                   아이디 <span class="id"></span>
									                             &emsp;&emsp;평점 <span class="score"></span>
									                             &emsp;&emsp;수정 날짜 <span class="regdate"></span>
									                        </div>
									                    </li> 
									               </ul>
									           </div>
									     
									           <!-- Modal body -->
									           <div class="modal-body">
									              	 게시글 내용<br>
									               <div class="selectCon">
									               		<span class="reviewContent"></span>
									               </div>
									               <div class="nonSelectCon">
									               		<textarea class="reviewContent" name="review_content"></textarea>
									               </div>
									               <div class="upload_content">
									                   upload..
									               </div>
									           </div>
									           <!-- Modal footer -->
									           <div class="modal-footer">
									             <div class="update">
									                <button type="button" class="btn btn-primary" data-dismiss="modal">수정하기</button>
									                <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
									             </div>
									             <div class="insert">
									                <!-- <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="location.href='test.do'">생성하기</button> -->
									                <input type="submit" class="btn btn-primary" value="생성하기">
									                <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
									             </div>
									             <div class="select">
									                <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
									             </div>
									           </div>
									        </form>
									     </div>
									   </div>
									</div> 
<!-- ############################################ review Board Start ############################################ -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </section>
    <!-- Product Details Section End -->


</body>

</html>