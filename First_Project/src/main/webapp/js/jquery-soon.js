$(function() {
	$(window).ready(function() {
		review_id();
		reviewPaging(0);
	});
	
	var s_member_id;
	var s_product_id;
	var s_create = false;
	
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
						var $score = data[i].review_score;
						var $content = data[i].review_content;
						var $id = data[i].member_id;
						var $regdate = data[i].review_regdate;
						var row = $("<tr>").append(
							$("<td>").text($score),
							$("<a href='#' class='aCon' data-toggle='modal' data-target='#reviewModal' data-id="+$id+" data-score="+$score+" data-content="+$content+" data-regdate="+$regdate+">").text($content),
							$("<td>").text($id),
							$("<td>").text($regdate));
						tb.append(row);
					}
				}
				$(".table").empty().append(tb);
			}
		);
	};
	
	function review_id() {
		$.get(
			'./reviewid.do',
			function(data) {
				s_member_id = data.member_id;
				s_product_id = data.product_id;
			}
		);
	}
	
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
	
	$(".reviewCreateModal").on("click", function() {
		s_create = true;
	})
	
	
	$("#reviewModal").on("show.bs.modal", function(e) {
		var modal_review_id = $(e.relatedTarget).data("id");
		var modal_review_score = $(e.relatedTarget).data("score");
		var modal_review_regdate = $(e.relatedTarget).data("regdate");
		var modal_review_content = $(e.relatedTarget).data("content");
		if(s_create == true) {                      /* insert */
			$(".insert").css('display', 'block');
			$(".update").css('display', 'none');
			$(".select").css('display', 'none');
			$(".nonSelectCon").css('display', 'block');
			$(".selectCon").css('display', 'none');
			$(".upload_content").css('display', 'block');
			
			$(".id").empty();
			$(".score").attr("value", "");
			$(".reviewContent").empty();
			$(".regdate").attr("value", new Date()); /* select */
		} else if(modal_review_id != s_member_id) {
			$(".insert").css('display', 'none');
			$(".update").css('display', 'none');
			$(".select").css('display', 'block');
			$(".nonSelectCon").css('display', 'none');
			$(".selectCon").css('display', 'block');
			$(".upload_content").css('display', 'none');
			
			$(".id").text(modal_review_id);
			$(".score").text("value",modal_review_score);
			$(".regdate").text(modal_review_regdate);
			$(".reviewContent").text(modal_review_content);
		} else if(modal_review_id == s_member_id) {         /* update */
			$(".insert").css('display', 'none');
			$(".update").css('display', 'block');
			$(".select").css('display', 'none');
			$(".nonSelectCon").css('display', 'block');
			$(".selectCon").css('display', 'none');
			$(".upload_content").css('display', 'block');
			
			$(".id").text(modal_review_id);
			$(".score").attr("value",modal_review_score);
			$(".regdate").text(modal_review_regdate);
			$(".reviewContent").text(modal_review_content);
		}
		
		s_create = false;
	});
});
	


