package com.project.mini.review;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.mini.review.login.MemberVO;
import com.project.mini.review.product.ProductVO;

@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	private HttpSession session;
	private int reviewBox;
	private int reviewTotal;
	private int reviewBoxNum = 1;
	private int reviewSet=1;
	private int product_id;
	Map<String, Integer> pageMap = new HashMap<String, Integer>();
	
	
	/* Controller 메소드 */
	@RequestMapping("/insertBoard.do")
	public void insertBoard(ReviewVO bb) {
		System.out.println("####[ReviewController.insertBoard]");
		reviewService.insertBoard(bb);
	}
	
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="page", defaultValue="1", required=false) int page,
			HttpServletRequest request, Model model) {
		System.out.println("####[ReviewController.getBoardList]");
		
		/* 상품 번호 */
		session = request.getSession();
		product_id = (int) session.getAttribute("product_id");
		
		pageMap.put("page", page);
		pageMap.put("product_id", product_id);
		
		model.addAttribute("pageRange", pRange(product_id));
		model.addAttribute("boardList", reviewService.getBoardlist(pageMap));
		return "/review/getBoardList";
	}
	
	
	
	/* AJAX 처리 메소드       */
	@RequestMapping("/reviewSend.do")
	@ResponseBody
	public List<ReviewVO> reviewSend(@RequestParam(value="review", defaultValue="1", required=false)int reviewNum,
			HttpServletRequest request
			) {
		System.out.println("###[ReviewController.reviewSend]");
		
		pageMap.put("page", reviewNum);
		
		return reviewService.getBoardlist(pageMap);
	}
	
	
	@RequestMapping("/reviewPaging.do")
	@ResponseBody
	public int reviewPaging(@RequestParam(value="pageNum", defaultValue="0", required=false)int reviewBoxNum) {
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
	
	/* paging 처리 메소드 */
	public Map<String, Integer> pRange(int product_id) {
		int reviewLimit = 10;                               // 하나의 리뷰페이지에 표시할 리뷰 개수
		int pageLimit = 10;                                 // 리뷰 페이지를 끊는 값 (previous, next를 적용 시킬 페이지 단위) 
		int top;                                            // JSP로 반환해 리뷰를 보여줄 최대 값
		int bottom;                                         // JSP로 반환해 리뷰를 보여줄 최소 값
		int reviewCount = reviewService.boardCount(product_id);       // 레코드의 총 개수
		System.out.println("reviewCount : "+reviewCount);
		Map<String, Integer> pageRange = new HashMap<String, Integer>();
		
		reviewTotal = reviewCount / reviewLimit;             // reviewTotal : 레코드 개수를 pageLimit으로 나눈 값
		if(reviewCount % reviewLimit > 0) reviewTotal += 1;  // pageLimit으로 연산 후 남은 레코드가 있을 경우 페이지를 추가한다. (추가된 페이지에 남은 레코드 출력)
		int lastReviewBox = reviewTotal;                     // lastReviewBox : 남은 레코드를 표현할 페이지까지 추가된 페이지의 총 개수
		
		
		// lastReviewBox = 1;
		// reviewTotal = 1
		
		// reviewBox
		reviewBox = reviewTotal / pageLimit;                 // reviewBox
		if(reviewTotal % pageLimit > 0) reviewBox += 1;
		
		if(reviewTotal >= pageLimit) reviewTotal = pageLimit * reviewBoxNum;
		
		if(reviewBox == reviewBoxNum) {
			top = lastReviewBox;
			if(top % 10 == 1) {
				bottom = top;
			} else {
				bottom = reviewBox*pageLimit-reviewLimit;
			}
			if(bottom < 1) bottom = 1;
			pageRange.put("top", top);
			pageRange.put("bottom", bottom);
			
		} else {
			top = reviewTotal;
			bottom = reviewTotal-(pageLimit-1);
			
			if(bottom < 0) {
				bottom = 1;
			}
			pageRange.put("top", top);
			pageRange.put("bottom", bottom);
		}
		
		return pageRange;
	}
	
	
	
	
	/*=============================================*/
	/* Login Test Controller */
	@RequestMapping("/login.do")
	public String login(MemberVO memberVO, HttpServletRequest request) {
		System.out.println("####[ReviewController.login]");
		
		MemberVO mVO = reviewService.getMember(memberVO);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("member_id", mVO.getMember_id());
		return "/review/ProductTest";
	}
	
	
	/* product Select Test */
	@RequestMapping("/selectProduct.do")
	public ModelAndView getProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("####[ReviewController.selectProduct]");
		HttpSession session = request.getSession();
		
		ProductVO pVO = reviewService.getProduct(Integer.parseInt(request.getParameter("product_id")));
		session.setAttribute("product_id", pVO.getProduct_id());
		
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}
}
