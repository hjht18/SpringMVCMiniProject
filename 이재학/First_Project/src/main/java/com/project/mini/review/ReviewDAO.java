package com.project.mini.review;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(ReviewVO bb) {
		System.out.println("##[ReviewDAO.insertBoard]");
		bb.setReview_regdate(new Date());
		mybatis.insert("sql.insert", bb);
		
	}
	
	public List<ReviewVO> getBoardList(int pageNum) {
		System.out.println("##[ReviewDAO.getBoardList]");
		Map<String, Integer> rangeMap = new HashMap();
		rangeMap.put("top", pageNum*5);
		rangeMap.put("bottom", pageNum*5-4);
		return mybatis.selectList("sql.getBoardList", rangeMap);
	}
	
	public int boardCount() {
		System.out.println("##[ReviewDAO.boardCount]");
		return mybatis.selectOne("sql.boardCount");
	}
	
}
