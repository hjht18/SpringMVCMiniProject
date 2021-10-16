$(function() {
	$(window).ready(function() {
		reviewPaging(0);
	});

//	$(".product__details__tab__desc").on("click", function() {
//		reviewPaging(0);
//	});
	
	function reviewSend(reviewNum) {
		$.get(
			'./reviewSend.do',
			{
				review:reviewNum
			},
			function(data) {
				if(data.length > 0) {
					var tb = $("<tbody>");
					for(var i=0; i<data.length; i++) {
						var $id = data[i].member_id;
						var $score = data[i].review_score;
						var $content = data[i].review_content;
						var $regdate = data[i].review_regdate;
						var row = $("<tr>").append(
							$("<td>").text($score),
							$("<a href='#' class='aCon' data-bs-toggle='modal' data-bs-target='#updateReview' data-id="+$id+" data-score="+$score+" data-content="+$content+" data-regdate="+$regdate+">").text($content),
//							$('<input type="button" data-bs-toggle="modal" class="t_btn" value="'+$content+'">'),
//							$('<button type="button" data-bs-toggle="modal" data-bs-target="#myModal" class="t_btn">').text($content),
							$("<td>").text($id),
							$("<td>").text($regdate));
						tb.append(row);
					}
				}
				$(".table").empty().append(tb);
			}
		);
	};
	
	function reviewPaging(pageNum) {
		$.get(
			'./reviewPaging.do',
			{
				pageNum:pageNum
			},
			function(data) {
				$(".pNum").first().focus();
				reviewSend(data);
			}
		);
	};
	
	
	$(".pNum").on("click", function() {
		var reviewNum = $(this).attr("value");
		reviewSend(reviewNum);
	});
	
	$(".page_box_add").on("click", function() {
		pageNum = 1;
		reviewPaging(pageNum);
	});
	
	$(".page_box_sub").on("click", function() {
		pageNum = -1;
		
		reviewPaging(pageNum);
	});
	
	
//	$(".nav-link").click(function() {
//		$(".nav-link").removeClass("active");
//		$(this).addClass("active");
//	});
	
	$("#updateReview").on("show.bs.modal", function(e) {
//		$(".title").attr("value",$(e.relatedTarget).data("title"));
		$(".id").text($(e.relatedTarget).data("id"));
		$(".score").attr("value",$(e.relatedTarget).data("score"));
		$(".regdate").text($(e.relatedTarget).data("regdate"));
		$(".content").text($(e.relatedTarget).data("content"));
		
		
		
//		var id = $(e.relatedTarget).data("id");
//		var score = $(e.relatedTarget).data("score");
//		var content = $(e.relatedTarget).data("content");
//		var regdate = $(e.relatedTarget).data("regdate");
	});
});
