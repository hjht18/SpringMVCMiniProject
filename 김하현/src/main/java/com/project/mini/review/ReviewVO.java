package com.project.mini.review;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReviewVO {
	private int review_id;
	private int review_score;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
	private Date review_regdate;
	private String review_content;
	
	/* member Table foreign */
	private String member_id;
	private int product_id;

	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getReview_score() {
		return review_score;
	}
	public void setReview_score(int review_score) {
		this.review_score = review_score;
	}
	public Date getReview_regdate() {
		return review_regdate;
	}
	public void setReview_regdate(Date review_regdate) {
		this.review_regdate = review_regdate;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	
	/* member Table foreign getter / setter */
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	
}



/*
	private String user_code;
	private int product_id;	
	
		@Override
	public String toString() {
		return "review_id : "+review_id+", review_score : "+review_score+", review_regdate : "+review_regdate+", review_content : "+review_content+
			", user_code : "+user_code+", product_id : "+product_id;
	}



*/