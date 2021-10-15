package com.project.mini.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<ReviewVO> getBoardlist(int pageNum) {
		System.out.println("###[BoardServiceImpl.getBoardlist]");
		return reviewDAO.getBoardList(pageNum);
	}

	@Override
	public int boardCount() {
		return reviewDAO.boardCount();
	}
	
}
