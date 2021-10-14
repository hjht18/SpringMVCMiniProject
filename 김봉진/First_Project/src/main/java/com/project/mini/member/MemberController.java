package com.project.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/test.do")
	public String selectMemberAddress(MemberVO vo) {
		
		return "member/memberTest";
	}
	
//	@RequestMapping("/login.do")
//	public String login(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.setAttribute("login", "로그인 상태 테스트");
//		return "login";
//	}
//	
//	@RequestMapping("/logout.do")
//	public String logout(HttpSession session) {
//		session.invalidate();
//		return "logout";
//	}
	
	
	// 회원가입 폼
	@RequestMapping("/register.do")
	public String register(MemberVO vo) {
//		memberService.signUp(vo);
		return "register";
	}
	
	// 회원가입
	@RequestMapping("/join.do")
	public String join(MemberVO vo) {
		memberService.signUp(vo);
		return "registerSuccess";
	}
	
	// 탈퇴
	@RequestMapping("/unregister.do")
	public String unregister() {
		return "unregister";
	}
	
	
	@RequestMapping("/modify.do")
	public String modify() {
		return "modify";
	}
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/addressAPI.do")
	public String address() {
		return "addressAPIPopup";
	}
}
