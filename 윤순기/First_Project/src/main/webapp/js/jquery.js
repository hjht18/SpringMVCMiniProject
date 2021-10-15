$(function() {
//	window.onload = reviewSend();
//	document.ready(function() {
//		reviewSend();
//	})
	$(window).ready(function() {
		test(0);
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
							$("<td>").text($id),"</td>",
							$("<td>").text($score),"</td>",
							$("<td><a href='www.naver.com'>").text($content),"</td>",
							$("<td>").text($regdate),"</td></tbody>");
						tb.append(row);
					}
				}
				$(".table").empty().append(tb);
			}
		);
	};
	
	function test(pageNum) {
		$.get(
			'./test.do',
			{
				pageNum:pageNum
			},
			function(data) {
				$(".pNum").first().focus();
//				if($(".pNum").attr("value") == data) {
//					alert("data : "+data+", value : "+$(".pNum").attr("value"));
//					$(this).focus();
//				}
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
		test(pageNum);
	});
	
	$(".page_box_sub").on("click", function() {
		pageNum = -1;
		
		test(pageNum);
	});
	
	
	$(".nav-link").click(function() {
		$(".nav-link").removeClass("active");
		$(this).addClass("active");
	});
	
	
});