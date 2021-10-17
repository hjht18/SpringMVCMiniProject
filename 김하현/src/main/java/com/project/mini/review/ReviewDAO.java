package com.project.mini.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.mini.review.login.MemberVO;
import com.project.mini.review.product.ProductVO;

@Repository
public class ReviewDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertReview(ReviewVO reviewVO) {
		System.out.println("##[ReviewDAO.insertBoard]");
		mybatis.insert("sql.insert", reviewVO);
	}
	
	public void updateReview(ReviewVO reviewVO) {
		System.out.println("##[ReviewDAO.updateReview]");
		mybatis.insert("sql.update", reviewVO);
	}
	
	public void deleteReview(ReviewVO reviewVO) {
		System.out.println("##[ReviewDAO.deleteReview]");
		mybatis.insert("sql.delete", reviewVO);
	}
	
	
	public List<ReviewVO> getBoardList(Map<String, Integer> pageMap) {
		System.out.println("##[ReviewDAO.getBoardList]");
		Map<String, Integer> rangeMap = new HashMap();
		
		int pageNum = pageMap.get("page");
		int product_id = pageMap.get("product_id");
		
		rangeMap.put("top", pageNum*10);  
		rangeMap.put("bottom", pageNum*10-9);
		rangeMap.put("product_id", product_id);
		return mybatis.selectList("sql.getBoardList", rangeMap);
	}
	
	public int boardCount(int product_id) {
		System.out.println("##[ReviewDAO.boardCount]");
		return mybatis.selectOne("sql.boardCount", product_id);
	}
	
	
	
	
	/*=============================================*/
	/* 로그인 테스트 */
	public MemberVO getMember(MemberVO memberVO) {
		return mybatis.selectOne("sql.getMember", memberVO);
	}
	
	public ProductVO getProduct(int productVO) {
		return mybatis.selectOne("sql.getProduct", productVO);
	}
	/*=============================================*/
	
}
