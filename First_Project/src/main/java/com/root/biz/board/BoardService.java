package com.root.biz.board;

import java.util.List;

public interface BoardService {
	public void insertBoard(BoardBean bb);
	public List<BoardBean> getBoardlist();
}
