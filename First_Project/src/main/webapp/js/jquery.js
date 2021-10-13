$(function() {
	window.onload = test();
	
	function test(pageNum) {
		$.get(
			'./test.do',
			{
				page:pageNum
			},
			function(data) {
				if(data.length > 0) {
					var tb = $("<tbody>");
					for(var i=0; i<data.length; i++) {
						//alert(data[i].review_id);
						var $id = data[i].review_id;
						var $score = data[i].review_score;
						var $content = data[i].review_content;
						var $regdate = data[i].review_regdate;
						var row = $("<tr>").append(
							$("<td>").text($id),"</td>",
							$("<td>").text($score),"</td>",
							$("<td>").text($content),"</td>",
							$("<td>").text($regdate),"</td></tbody>");
						tb.append(row);
					}
				}
				$(".table").empty().append(tb);
			}
		);
	};
	
	$(".pNum").on("click", function() {
		var pageNum = $(this).attr("value");
		test(pageNum);
	});
	
	$(".nav-link").click(function() {
		$(".nav-link").removeClass("active");
		$(this).addClass("active");
	});
});