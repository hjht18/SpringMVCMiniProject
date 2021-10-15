package com.project.mini.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@ModelAttribute("memberList")
	public List<MemberVO> memberList() {
		MemberVO vo = new MemberVO();
		return memberService.memberList(vo);
	}
	
	// 회원가입 폼
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public String registerForm(MemberVO vo) {
		return "register";
	}
	
	// 회원가입
	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public String register(MemberVO vo, Model model, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		Map<String, Boolean> errors = new HashMap<>();
		
		// 에러 조건 추가
		if(memberService.checkDuplicate(vo)) {
			errors.put("duplicateId", Boolean.TRUE);
		}
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
		// 에러가 발생하면 attribute 등록
		if (!errors.isEmpty()) {
			 model.addAttribute("errors", errors);
			 return "register";
		}
		redirectAttributes.addAttribute("regStatus", true);
		// 회원가입 로직 실행 후 가입성공 폼으로 리턴
		memberService.signUp(vo);
		return "redirect:/index.jsp";
	}
	
	// 회원 수정 폼
	@RequestMapping(value = "/modify.do", method = RequestMethod.GET)
	public String modifyForm(MemberVO vo) {
		return "modify";
	}
	
	@RequestMapping(value = "/modify.do", method = RequestMethod.POST)
	public String modify(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginMember");
		memberService.updateMember(member);
		session.setAttribute("loginMember", member);
		return "redirect:/";
	}
	
	
	// 탈퇴 폼
	@RequestMapping(value = "/unregister.do", method = RequestMethod.GET)
	public String unregisterForm() {
		return "unregister";
	}
	
	// 탈퇴 로직
	@RequestMapping(value = "/unregister.do", method = RequestMethod.POST)
	public String unregister(HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginMember");
		memberService.deleteMember(member);
		session.invalidate();
		return "redirect:/";
	}
	

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping("/addressAPI.do")
	public String address() {
		return "addressAPIPopup";
	}
	
	// =================================== // 
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String login(@RequestParam("memberId") String memberId
                       , @RequestParam("password") String password, HttpServletRequest request) throws Exception {

        String path = "";

        MemberVO vo = new MemberVO();

        vo.setMemberId(memberId);
        vo.setPassword(password);

        MemberVO loginMember = memberService.login(vo);

        if(loginMember != null) {
            path = "redirect:/index.jsp";
        } else {
            path = "loginForm";
        }
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", loginMember);
        return path;

    }
}
