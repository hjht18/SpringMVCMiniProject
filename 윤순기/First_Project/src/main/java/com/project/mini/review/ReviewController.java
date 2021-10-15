package com.project.mini.review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	private int reviewBox;
	private int reviewTotal;
	private int reviewBoxNum = 1;
	private int reviewSet=1;
	private String queryString;
	
	@RequestMapping("/insertBoard.do")
	public void insertBoard(ReviewVO bb) {
		System.out.println("####[ReviewController.insertBoard]");
		reviewService.insertBoard(bb);
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="page", defaultValue="1", required=false) int page,
			HttpServletRequest request, Model model) {
//		ModelAndView mav = new ModelAndView();
		System.out.println("####[ReviewController.getBoardList]");
		
		queryString = request.getQueryString();
		System.out.println("query : "+request.getQueryString());
		
		System.out.println("####################### getBoardList @ reviewSet : "+reviewSet);
		int reviewLimit = 10;
		int pageLimit = 10;
		int reviewCount = reviewService.boardCount();
		Map<String, Integer> pageRange = new HashMap<String, Integer>();
		
		reviewTotal = reviewCount / reviewLimit;
		if(reviewCount % reviewLimit > 0) reviewTotal += 1;
		int lastReviewBox = reviewTotal;
		
		// reviewBox
		reviewBox = reviewTotal / pageLimit;
		if(reviewTotal % pageLimit > 0) reviewBox += 1;
		
		if(reviewTotal >= pageLimit) reviewTotal = pageLimit * reviewBoxNum;
		
		if(reviewBox == reviewBoxNum) {
			int top = lastReviewBox;
			int bottom = reviewBox*pageLimit-reviewLimit;
			if(bottom < 1) bottom = 1;
			pageRange.put("top", top);
			pageRange.put("bottom", bottom);
			
		} else {
			pageRange.put("top", reviewTotal);
			pageRange.put("bottom", reviewTotal-(pageLimit-1));
		}
//		mav.addObject("pageRange", pageRange);
//		mav.addObject("boardList", reviewService.getBoardlist(page));
//		mav.setViewName("/review/getBoardList");
		model.addAttribute("pageRange", pageRange);
		model.addAttribute("boardList", reviewService.getBoardlist(page));
		return "/review/getBoardList";
	}
	 
	@RequestMapping("/reviewSend.do")
	@ResponseBody
	public List<ReviewVO> reviewSend(@RequestParam(value="review", defaultValue="1", required=false)int reviewNum,
			HttpServletRequest request
			) {
		return reviewService.getBoardlist(reviewNum);
	}
	
	@RequestMapping("/test.do")
	@ResponseBody
	public int testmethod(@RequestParam(value="pageNum", defaultValue="0", required=false)int reviewBoxNum) {
		if(reviewBoxNum < 0 ) {  
			if(this.reviewBoxNum > 1) {
				this.reviewBoxNum += reviewBoxNum;
			}
		} else if(reviewBox > this.reviewBoxNum){
			this.reviewBoxNum += reviewBoxNum;
		}
		
		reviewSet = this.reviewBoxNum+((this.reviewBoxNum-1)*9);
		
//		if(this.reviewBoxNum == 1 && reviewBox <= this.reviewBoxNum+1) {
//			return "unable";
//		}
//		
//		if(this.reviewBoxNum == 1){
//			return "subUnable";
//		}
//		
//		if(reviewBox <= this.reviewBoxNum+1){
//			return "addUnable";
//		}
		return reviewSet;
	}
	
}
