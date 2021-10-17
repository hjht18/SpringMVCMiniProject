$(function() {
	$(window).ready(function() {
		review_id();
		reviewPaging(0);
		
	});
	
	var now;
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
						var $productId = data[i].product_id;
						var $reviewId = data[i].review_id;
						var $score = data[i].review_score;
						var $content = data[i].review_content;
						var $memberId = data[i].member_id;
						var $regdate = data[i].review_regdate;
						var row = $("<tr>").append(
							$("<td>").text($score),
							$("<a href='#' class='aCon' data-toggle='modal' data-target='#reviewModal' data-productid="+$productId+" data-reviewid="+$reviewId+" data-memberid="+$memberId+" data-score="+$score+" data-content="+$content+" data-regdate="+$regdate+">").text($content),
							$("<td>").text($memberId),
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
	
	function nowDate() {
		var nowDate = new Date();
		now = nowDate.getFullYear();
		now += '-' + nowDate.getMonth() +1;
		now += '-' + nowDate.getDate();
		now += ' ' + nowDate.getHours();
		now += ':' + nowDate.getMinutes();
	}
	
	
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
		nowDate();
		var modal_product_id = $(e.relatedTarget).data("productid");
		var modal_review_id = $(e.relatedTarget).data("reviewid");
		var modal_member_id = $(e.relatedTarget).data("memberid");
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
			
			$(".insert>.member_id").attr("disabled", false);
			$(".insert>.score").attr("disabled", false);
			$(".insert>.review_regdate").attr("disabled", false);
			
			$(".update>.review_id").attr("disabled", true);
			$(".update>.score").attr("disabled", true);
			
			$(".id").empty();
			$(".score").attr("value", "");
			$(".reviewContent").empty();
			$(".member_id").attr("value", s_member_id); /* select */
			$(".product_id").attr("value", s_product_id); /* select */
			$(".review_regdate").attr("value", String(now)); /* select */
		} else if(modal_member_id != s_member_id) {
			$(".insert").css('display', 'none');
			$(".update").css('display', 'none');
			$(".select").css('display', 'block');
			$(".nonSelectCon").css('display', 'none');
			$(".selectCon").css('display', 'block');
			$(".upload_content").css('display', 'none');
			
			$(".review_id").attr("value", modal_review_id);
			$(".id").text(modal_member_id);
			$(".score").text("value",modal_review_score);
			$(".review_regdate").text(modal_review_regdate);
			$(".reviewContent").text(modal_review_content);
		} else if(modal_member_id == s_member_id) {         /* update */
			$(".insert").css('display', 'none');
			$(".update").css('display', 'block');
			$(".select").css('display', 'none');
			$(".nonSelectCon").css('display', 'block');
			$(".selectCon").css('display', 'none');
			$(".upload_content").css('display', 'block');
			$(".upload_content").css('display', 'block');
			
			$(".update>.review_id").attr("disabled", false);
			$(".update>.score").attr("disabled", false);
			
			$(".insert>.review_id").attr("disabled", true);
			$(".insert>.member_id").attr("disabled", true);
			$(".insert>.score").attr("disabled", true);
			$(".insert>.review_regdate").attr("disabled", true);
			
			$(".review_id").attr("value", modal_review_id);
			$(".member_id").text(modal_member_id);
			$(".score").attr("value",modal_review_score);
			$(".review_regdate").text(modal_review_regdate);
			$(".reviewContent").text(modal_review_content);
		}
		
		s_create = false;
	});
	
	$(".rus").on("click", function() {
		$(".modal-form").attr("action", "./reviewUpdate.do");
	});
	
	$(".rds").on("click", function() {
		$(".modal-form").attr("action", "./reviewDelete.do");
	});
	
	$(".ris").on("click", function() {
		$(".modal-form").attr("action", "./reviewInsert.do");
	});
});
	


