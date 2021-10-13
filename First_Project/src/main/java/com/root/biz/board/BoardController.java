package com.root.biz.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/insertBoard.do")
	public void insertBoard(BoardBean bb) {
		System.out.println("####[BoardController.insertBoard]");
		boardService.insertBoard(bb);
	}
	
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(@RequestParam(value="page", defaultValue="1", required=false) int pageNum) {
		System.out.println("####[BoardController.getBoardList]");
		ModelAndView mav = new ModelAndView();
		int pageTotal = 1;
		System.out.println("pageNum : "+pageNum);
		int boardCount = boardService.boardCount();
		
		pageTotal = boardCount / 5;
		if(boardCount % 5 > 0) pageTotal += 1;
		
		mav.addObject("pageTotal", pageTotal);
		mav.addObject("boardList", boardService.getBoardlist(pageNum));
		mav.setViewName("BoardTest.jsp");
		return mav;
	}
	
}

/*
 
		List<BoardBean> boardList = boardService.getBoardlist();
		
		Iterator<BoardBean> it = boardList.iterator();
		
		while(it.hasNext()) {
			BoardBean bb = it.next();
			System.out.println("id : "+bb.getReview_id());
			System.out.println("content : "+bb.getReview_content());
			System.out.println("score : "+bb.getReview_score());
			System.out.println("date : "+bb.getReview_regdate());
		}
		System.out.println("dot1");
		
	return "BoardTest.jsp?page="+pageNum;
 */