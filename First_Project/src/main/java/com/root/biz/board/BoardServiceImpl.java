package com.root.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("BoardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(BoardBean bb) {
		System.out.println("###[BoardServiceImpl.insertBoard]");
		boardDAO.insertBoard(bb);
	}

	@Override
	public List<BoardBean> getBoardlist(int pageNum) {
		System.out.println("###[BoardServiceImpl.getBoardlist]");
		return boardDAO.getBoardList(pageNum);
	}

	@Override
	public int boardCount() {
		return boardDAO.boardCount();
	}
	
}
