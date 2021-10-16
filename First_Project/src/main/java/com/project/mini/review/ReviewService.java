package com.project.mini.review;

import java.util.List;
import java.util.Map;

import com.project.mini.review.login.MemberVO;
import com.project.mini.review.product.ProductVO;


public interface ReviewService {
	public void insertBoard(ReviewVO bb);
	public List<ReviewVO> getBoardlist(Map<String, Integer> pageMap);
	public int boardCount(int product_id);
	
	/*=============================================*/
	/* 로그인 테스트 */
	public MemberVO getMember(MemberVO memberVO);
	
	/* 상품 선택 테스트 */
	public ProductVO getProduct(int productVO);
	/*=============================================*/
}
