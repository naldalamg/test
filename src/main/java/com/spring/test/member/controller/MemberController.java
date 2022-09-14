package com.spring.test.member.controller;


import com.spring.test.member.service.MemberService;
import com.spring.test.member.service.SignUpService;
import com.spring.test.member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller("memberController")

public class MemberController {


	@Autowired
	SignUpService signUpService;
	@Autowired
	MemberService memberService;

	@RequestMapping("/signForm.html")
	public String signForm(Model model) {
		return "signForm";
	}

	@RequestMapping(value = "/signUp.do", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("memberVO") MemberVO memberVO, Model model) throws Exception {
		// 사용자가 입력한 정보를 파라미터로 넘김
		boolean isInserted = signUpService.insertUserInfo(memberVO);

		model.addAttribute("member", memberVO);

		if (isInserted)
			return "login";
		else
			return "signForm";
		
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/duplicateID.do", method = RequestMethod.POST)
	public String duplicateID(@RequestParam("member_id") String member_id, HttpServletRequest request) {
		//사용자가 입력한 정보를 파라미터로 넘김
		System.out.println(memberService.duplicateID(member_id));
		return memberService.duplicateID(member_id);
	}

				
	@RequestMapping(value="/deleteID.do")			
	public String deleteID(HttpServletRequest request, RedirectAttributes redirectAttr) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String member_id=(String)principal;
		
		String result = memberService.deleteID(member_id);
		
		if("0".equals(result)) {
			SecurityContextHolder.clearContext();
			redirectAttr.addFlashAttribute("result", result);
			return "redirect:/main.html";
		}else {
			redirectAttr.addFlashAttribute("result", result);
			return "redirect:/modMemberInfo.html";
		}
		
	}

}
