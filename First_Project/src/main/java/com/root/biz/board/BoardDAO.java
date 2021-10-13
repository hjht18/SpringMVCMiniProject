package com.root.biz.board;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardBean bb) {
		System.out.println("##[BoardDAO.insertBoard]");
		bb.setReview_regdate(new Date());
		mybatis.insert("sql.insert", bb);
		
	}
	
	public List<BoardBean> getBoardList(int pageNum) {
		System.out.println("##[BoardDAO.getBoardList]");
		Map<String, Integer> rangeMap = new HashMap();
		rangeMap.put("top", pageNum*5);
		rangeMap.put("bottom", pageNum*5-4);
		return mybatis.selectList("sql.getBoardList", rangeMap);
	}
	
	public int boardCount() {
		System.out.println("##[BoardDAO.boardCount]");
		return mybatis.selectOne("sql.boardCount");
	}
	
}
