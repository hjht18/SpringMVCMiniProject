package com.root.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ModelAndView getBoardList(@RequestParam(value="page", defaultValue="1", required=false) int pageNum ) {
		ModelAndView mav = new ModelAndView();
		int boardCount = boardService.boardCount();
		
		int pageTotal = boardCount / 5;
		if(boardCount % 5 > 0) pageTotal += 1;
		
		mav.addObject("boardList", boardService.getBoardlist(pageNum));
		mav.addObject("pageTotal", pageTotal);
		mav.setViewName("getBoardList");
		return mav;
	}
	
	@RequestMapping("/test.do")
	@ResponseBody
	public List<BoardBean> testMethod(@RequestParam(value="page", defaultValue="1", required=false)int pageNum) {
		return boardService.getBoardlist(pageNum);
	}
	
}

/*

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(@RequestParam(value="page", defaultValue="1", required=false) int pageNum,
			@RequestParam(value="pageBoxSub", required=false) boolean pageBoxSub,
			@RequestParam(value="pageBoxAdd", required=false) boolean pageBoxAdd,
			HttpServletRequest request
			) {
		System.out.println("####[BoardController.getBoardList]");
		System.out.println("요청 경로 : "+request.getRequestURI()+request.getQueryString());
		System.out.println("요청 쿼리 : "+request.getQueryString());
		System.out.println("reffer : "+request.getHeader("Referer"));
		System.out.println("pageBoxSub : "+pageBoxSub);
		System.out.println("pageBoxSub : "+pageBoxAdd);
		ModelAndView mav = new ModelAndView();
		int pageTotal = 1;
		System.out.println("pageNum : "+pageNum);
		int boardCount = boardService.boardCount();
		
		pageTotal = boardCount / 5;
		if(boardCount % 5 > 0) pageTotal += 1;
		
		mav.addObject("pageTotal", pageTotal);
		mav.addObject("boardList", boardService.getBoardlist(pageNum));
		mav.setViewName("BoardTest.jsp?page="+pageTotal);
		return mav;
	}



 */