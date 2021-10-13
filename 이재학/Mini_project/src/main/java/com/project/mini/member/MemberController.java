package com.project.mini.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@RequestMapping("/test")
	public String selectMemberAddress(MemberVO vo) {
		
		return "member/memberTest";
	}
}
