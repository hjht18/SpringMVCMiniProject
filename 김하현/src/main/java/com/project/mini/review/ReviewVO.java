package com.project.mini.review;

import java.util.Date;

public class ReviewVO {
	private int review_id;
	private int review_score;
	private Date review_regdate;
	private String review_content;

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