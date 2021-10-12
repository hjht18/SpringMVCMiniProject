package com.root.biz.board;

import java.util.Date;
import java.util.List;

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
	
	public List<BoardBean> getBoardList() {
		System.out.println("##[BoardDAO.getBoardList]");
		return mybatis.selectList("sql.getBoardList");
	}
	
}
