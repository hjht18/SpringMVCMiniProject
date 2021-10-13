package com.project.mini.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BoardService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private ReviewDAO boardDAO;

	@Override
	public void insertBoard(ReviewVO bb) {
		System.out.println("###[BoardServiceImpl.insertBoard]");
		boardDAO.insertBoard(bb);
	}

	@Override
	public List<ReviewVO> getBoardlist(int pageNum) {
		System.out.println("###[BoardServiceImpl.getBoardlist]");
		return boardDAO.getBoardList(pageNum);
	}

	@Override
	public int boardCount() {
		return boardDAO.boardCount();
	}
	
}
