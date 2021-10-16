/*  ---------------------------------------------------
    Template Name: Ogani
    Description:  Ogani eCommerce  HTML Template
    Author: Colorlib
    Author URI: https://colorlib.com
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */

'use strict';

(function ($) {
    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
//        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Gallery filter
        --------------------*/
        $('.featured__controls li').on('click', function () {
            $('.featured__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.featured__filter').length > 0) {
            var containerEl = document.querySelector('.featured__filter');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*-----------------------
        Categories Slider
    ------------------------*/
    $(".categories__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            0: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 3,
            },

            992: {
                items: 4,
            }
        }
    });
    
    
    /*--------------------------
    Soon made js start
	----------------------------*/
    /*
	function reviewSend(reviewNum) {
		alert("reviewSend call");
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
		alert("reviewPaging call");
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
		alert("page_box_add call()");
		reviewPaging(pageNum);
	});
	
	$(".page_box_sub").on("click", function() {
		pageNum = -1;
		alert("page_box_sub call()");
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
    
 */
    /*--------------------------
    Soon made js end
	----------------------------*/
    


    $('.hero__categories__all').on('click', function(){
        $('.hero__categories ul').slideToggle(400);
    });

    /*--------------------------
        Latest Product Slider
    ----------------------------*/
    $(".latest-product__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------------
        Product Discount Slider
    -------------------------------*/
    $(".product__discount__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 3,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            320: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 2,
            },

            992: {
                items: 3,
            }
        }
    });

    /*---------------------------------
        Product Details Pic Slider
    ----------------------------------*/
    $(".product__details__pic__slider").owlCarousel({
        loop: true,
        margin: 20,
        items: 4,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------
		Price Range Slider
	------------------------ */
    var rangeSlider = $(".price-range"),
        minamount = $("#minamount"),
        maxamount = $("#maxamount"),
        minPrice = rangeSlider.data('min'),
        maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 0));
    maxamount.val('$' + rangeSlider.slider("values", 1));

    /*--------------------------
        Select
    ----------------------------*/
    $("select").niceSelect();

    /*------------------
		Single Product
	--------------------*/
    $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
		Quantity change
	--------------------- */
    var proQty = $('.pro-qty');
    proQty.prepend('<span class="dec qtybtn">-</span>');
    proQty.append('<span class="inc qtybtn">+</span>');
    proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 0) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 0;
            }
        }
        $button.parent().find('input').val(newVal);
    });

})(jQuery);