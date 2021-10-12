package com.root.biz.board;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String getBoardList(Model model) {
		System.out.println("####[BoardController.getBoardList]");
		List<BoardBean> boardList = boardService.getBoardlist();
		
		Iterator<BoardBean> it = boardList.iterator();
		
		while(it.hasNext()) {
			BoardBean bb = it.next();
			System.out.println("id : "+bb.getReview_id());
			System.out.println("content : "+bb.getReview_content());
			System.out.println("regdate : "+bb.getReview_regdate());
			System.out.println("score : "+bb.getReview_score());
		}
		
		model.addAttribute("boardList", boardList);
		return "BoardTest.jsp";
	}
	
}

