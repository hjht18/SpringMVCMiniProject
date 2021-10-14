package com.project.mini.member;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/test.do")
	public String selectMemberAddress(MemberVO vo) {
		
		return "member/memberTest";
	}
	
	
	// 회원가입 폼
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String register(MemberVO vo) {
//		memberService.signUp(vo);
		return "register";
	}
	
	// 회원가입
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String join(MemberVO vo, Model model, HttpServletRequest request) {
		Map<String, Boolean> errors = new HashMap<>();
		if(!StringUtils.hasText(vo.getName())) {
			errors.put("name", Boolean.TRUE);
		}
		if(!StringUtils.hasText(vo.getMemberId())) {
			errors.put("memberId", Boolean.TRUE);
		}
		if(!StringUtils.hasText(vo.getPassword())) {
			errors.put("password", Boolean.TRUE);
		}
		
		if(!request.getParameter("password").equals(request.getParameter("repassword"))) {
			errors.put("passwordValid", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			 model.addAttribute("errors", errors);
			 return "register";
		}
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
	
//	// 클라이언트에서 /login.do 요청이 오면 login() 메소드가 실행됨
//		// 실행되고 난 뒤 조건에 따라서 지정된 곳으로 포워딩됨
//		@RequestMapping(value = "/login.do", method=RequestMethod.POST)
//		public String login(MemberVO vo , MemberDAO memberDAO, HttpSession session) {
//			
//			System.out.println("로그인 인증 처리 ..");
//			
//			if(vo.getMemberId() == null || vo.getMemberId().equals("")) {
//				throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다!");
//			}
//			
//			if(memberDAO.getUser(vo) != null) {
//				session.setAttribute("userName",userDAO.getUser(vo).getName());
//				return "redirect:getBoardList.do";
//			} else {
//				return "login.jsp";
//			}
//		}
//		
//		@RequestMapping(value = "/login.do", method=RequestMethod.GET)
//		public String loginView(@ModelAttribute("user") UserVO vo) {
//			System.out.println("로그인 화면으로 이동");
//			vo.setId("test");
//			vo.setPassword("test123!");
//			return "login.jsp";
//		}
//		
}
