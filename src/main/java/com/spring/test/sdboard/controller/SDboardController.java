package com.spring.test.sdboard.controller;

import com.spring.test.sdboard.service.SDboardService;
import com.spring.test.sdboard.vo.SDboardVO;
import com.spring.test.suit_board.vo.PageMaker;
import com.spring.test.suit_board.vo.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SDboardController {

    @Autowired
    private SDboardService sdboardService;

    @RequestMapping(value="/listSDboard.do", method=RequestMethod.GET)
    public String listSDboard(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
        List<SDboardVO> allList =new ArrayList();
        allList = sdboardService.selectListAll("sdboard.selectListAll",scri);
        model.addAttribute("allList",allList);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(scri);
        pageMaker.setTotalCount(sdboardService.selectTotalNO("sdboard.selectTotalNO", scri));
        model.addAttribute("pageMaker", pageMaker);
        return "listSoda";
    }

    @RequestMapping(value="/sdboardForm.html", method=RequestMethod.GET)
    public String sdboardForm(Model model, HttpServletRequest request) throws Exception{
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String member_id=(String)principal;
        SDboardVO sdboardVO = new SDboardVO();

        String sd_board_NO = request.getParameter("sd_board_NO");

        //등록화면
        if(sd_board_NO == null){
            System.out.print(sdboardVO.getSd_board_NO());
            sdboardVO.setMember_id(member_id);
            model.addAttribute("sdboardVO", sdboardVO);
        }

        //수정화면
        if(sd_board_NO != null){
            sdboardVO = sdboardService.selectInfo("sdboard.selectInfo", sd_board_NO);
            model.addAttribute("sdboardVO", sdboardVO);
        }

        return "sdboardForm";
    }

    @RequestMapping(value="/regBoard.do" , method= RequestMethod.POST)
    public String regBoard(@ModelAttribute("sdboardVO")SDboardVO sdboardVO, MultipartHttpServletRequest request) throws Exception{

        String sd_board_NO = request.getParameter("sd_board_NO");

        //등록
        if(sd_board_NO.isEmpty()) {
            sdboardService.insertSDboard("sdboard.insertSDboard", sdboardVO);
        }
        //수정
        if(sd_board_NO != null){
            sdboardService.updateSDboard("sdboard.updateSDboard", sdboardVO);
        }

        return "redirect:/listSDboard.do";
    }

    @RequestMapping(value="/deleteSDboard.do")
    public String deleteSDboard(@RequestParam("sd_board_NO")String sd_board_NO ) throws Exception{
         System.out.print(sd_board_NO);
        sdboardService.deleteSDboard("sdboard.deleteSDboard",sd_board_NO);

        return "redirect:/listSDboard.do";
    }
}
