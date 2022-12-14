package com.spring.test.suit_board.controller;

import com.spring.test.suit_board.service.SuitService;
import com.spring.test.suit_board.vo.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller("suitController")
public class SuitController {

	private static final String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";

	@Autowired
	SuitService suitService;
	
	
	@RequestMapping(value="/listSuitAll.do")
	public String listSuitAll(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
		//board list
		List<SuitVO> allList = new ArrayList<SuitVO>();
		allList = suitService.selectListAll("suit.selectListAll", scri);
		model.addAttribute("allList", allList);
		
		//board paging
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(suitService.selectTotalNO("suit.selectTotalNO", scri));
		model.addAttribute("pageMaker", pageMaker);
		
		return "listSuit";
	}
	
	@RequestMapping(value="/suitForm.html", method= {RequestMethod.POST,RequestMethod.GET})
	public String suitForm(Model model, HttpServletRequest request ) throws Exception{
		
		List<CodeVO> codeList = new ArrayList();
		codeList = suitService.selectCode("suit.selectCode");
		model.addAttribute("codeList", codeList);
		
		String req_no = request.getParameter("req_no");
		
		if(req_no != null) {
			SuitVO suitVO = suitService.selectInfo("suit.selectInfo", req_no);
			List<AttachVO> fileList = suitService.selectFileInfo("suit.selectFileInfo", req_no);
			model.addAttribute("fileList", fileList);
			model.addAttribute("suitVO", suitVO);
		}
		
		return "suitForm";
	}
	
	
	@RequestMapping(value = "/addRentSuit.do", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView insertForm(MultipartHttpServletRequest multipartRequest, @ModelAttribute("suitVO")SuitVO suitVO
			 ) throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String member_id=(String)principal;
		suitVO.setMember_id(member_id);
		
		ModelAndView mav = new ModelAndView();
		
		String req_no = multipartRequest.getParameter("req_no");
		
		//insert Form
		if (req_no == null) {
			suitService.insertSuit("suit.insertSuit", suitVO);
			req_no = suitService.selectNO("suit.selectNO", member_id);
			suitVO.setReq_no(req_no);
			suitService.insertIC("suit.insertIC", suitVO);
		}
		
		//update
		if(req_no != null) {
			suitService.updateSuit("updateSuit", suitVO);
			suitService.updateIC("updateIC", suitVO);
			
			List deleteList = new ArrayList();
			for(int i=1; i<5; i++) {
				String deleteFileName = multipartRequest.getParameter("deleteFile"+i);
				if(deleteFileName != null) {
					deleteList.add(deleteFileName);
				}
			}
			suitService.deleteFile("suit.deleteFile", req_no, deleteList);
		}
		
		//insert file
		suitService.insertFile("suit.insertFile", req_no, multipartRequest);

		List<AttachVO> fileList = suitService.selectFileInfo("suit.selectFileInfo", req_no);
		
		mav.addObject("fileList", fileList);
		mav.setViewName("suitForm2");
		return mav;
			
	}
	
	
	@RequestMapping(value="/deleteSuit.do")
	public String deleteSuit(@RequestParam("req_no") String req_no) throws Exception{
		suitService.deleteAll("suit.deleteAll", req_no);
		
		//???????????? ??????
		File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + req_no);
		FileUtils.deleteDirectory(destDir);
		
		return "redirect:/listSuitAll.do";
	}
	@RequestMapping("/suitIntroduce.html")
	public String djn(Model model) {
		return "suitIntro";
	}}
