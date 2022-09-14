package com.spring.test.common.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class CommonController {

	@RequestMapping("/main.html")
	public String main(Model model) {
		return "main";
	}


	@RequestMapping("/login.html")
	public String login(HttpServletRequest request, Model model, Authentication authentication) {
		String uri = request.getHeader("Referer"); // 이전 경로

		// 이미 인증된 사용자의 로그인 페이지 접근 방지
		if (authentication != null)
			return "duplicate";

		// 이전 경로가 로그인 관련 페이지가 아닐 경우에만 저장, 속성값이 null이 되면 오류가 발생하므로 이 경우도 처리한다.
		if (uri != null && !(uri.contains("/login.html") || uri.contains("/login_check")))
			request.getSession().setAttribute("prevPage", uri);
		return "login";
	}

}
