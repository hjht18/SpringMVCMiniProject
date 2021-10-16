package com.project.mini.review;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.mini.review.login.MemberVO;
import com.project.mini.review.product.ProductVO;


@Service("ReviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDAO reviewDAO;

	@Override
	public void insertBoard(ReviewVO bb) {
		System.out.println("###[BoardServiceImpl.insertBoard]");
		reviewDAO.insertBoard(bb);
	}

	@Override
	public List<ReviewVO> getBoardlist(Map<String, Integer> pageMap) {
		System.out.println("###[BoardServiceImpl.getBoardlist]");
		return reviewDAO.getBoardList(pageMap);
	}

	@Override
	public int boardCount(int product_id) {
		return reviewDAO.boardCount(product_id);
	}

	/*=============================================*/
	/* 로그인 테스트 */
	@Override
	public MemberVO getMember(MemberVO memberVO) {
		return reviewDAO.getMember(memberVO);
	}

	
	/* 상품 선택 테스트 */
	@Override
	public ProductVO getProduct(int productVO) {
		
		return reviewDAO.getProduct(productVO);
	}
	/*=============================================*/
	
}
