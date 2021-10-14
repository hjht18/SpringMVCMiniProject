package com.project.mini;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class LoginController {
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("login", "로그인 상태 테스트");
		return "login";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "logout";
	}
	
	@RequestMapping("/register.do")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/unregister.do")
	public String unregister() {
		return "unregister";
	}
	
	@RequestMapping("/modify.do")
	public String modify() {
		return "modify";
	}
}
