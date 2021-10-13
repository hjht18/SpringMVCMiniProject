package com.project.mini.review;

import java.util.List;

public interface ReviewService {
	public void insertBoard(ReviewVO bb);
	public List<ReviewVO> getBoardlist(int pageNum);
	public int boardCount();
}
