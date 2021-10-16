package com.project.mini;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorTestController {

	@RequestMapping(value = "/error-404.do", method = RequestMethod.GET)
	public void error404(HttpServletResponse response) throws IOException {
		response.sendError(404, "404 오류!");
		System.out.println("에러 발생");
	}

	@RequestMapping(value = "/error-500" , method = RequestMethod.GET)
		public void error500(HttpServletResponse response) throws IOException {
		 response.sendError(500);
	}

}
