package com.project.mini.review;

import java.util.List;
import java.util.Map;

import com.project.mini.review.login.MemberVO;
import com.project.mini.review.product.ProductVO;

public interface ReviewService {
	public void insertReview(ReviewVO reviewVO);
	public List<ReviewVO> getBoardlist(Map<String, Integer> pageMap);
	public int boardCount(int product_id);
	public void updateReview(ReviewVO reviewVO);
	public void deleteReview(ReviewVO reviewVO);
	
	/*=============================================*/
	/* 로그인 테스트 */
	public MemberVO getMember(MemberVO memberVO);
	
	/* 상품 선택 테스트 */
	public ProductVO getProduct(int productVO);
	/*=============================================*/
}
