package com.project.mini.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.member.MemberVO;

@Controller
@RequestMapping("/review")
public class ReviewController {

	@RequestMapping("/test")
	public String selectMemberAddress(MemberVO vo) {
		
		return "review/reviewTest";
	}
}
