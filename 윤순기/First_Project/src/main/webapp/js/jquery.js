$(function() {
//	window.onload = reviewSend();
//	document.ready(function() {
//		reviewSend();
//	})
	$(window).ready(function() {
		reviewPaging(0);
	})
	
	
	
	function reviewSend(reviewNum) {
//		var reviewNum;
//		if(reviewParam != null) {
//			alert("test");
//			reviewNum = reviewParam;
//		}
		
		$.get(
			'./reviewSend.do',
			{
				review:reviewNum
			},
			function(data) {
				if(data.length > 0) {
					var tb = $("<tbody>");
					for(var i=0; i<data.length; i++) {
						var $id = data[i].review_id;
						var $score = data[i].review_score;
						var $content = data[i].review_content;
						var $regdate = data[i].review_regdate;
						var row = $("<tr>").append(
							$("<td>").text($score),
							$("<a class='ttb1' href='www.naver.com?index="+(i+1)+"'>").text($content),
							$("<td>").text($id),
							$("<td>").text($regdate));
						tb.append(row);
					}
				}
				$(".table").empty().append(tb);
//				$(".tt1").empty().append(row);
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
	
	
	$(".nav-link").click(function() {
		$(".nav-link").removeClass("active");
		$(this).addClass("active");
	});
	
	
});