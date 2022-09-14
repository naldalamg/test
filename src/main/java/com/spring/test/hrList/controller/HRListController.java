package com.spring.test.hrList.controller;


import com.spring.test.hrList.service.HRListService;
import com.spring.test.hrList.vo.HRListVO;
import com.spring.test.suit_board.vo.PageMaker;
import com.spring.test.suit_board.vo.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HRListController {

    @Autowired
    private HRListService hrListService;

    @RequestMapping(value="/mainHRList.html")
    public String mainHRList(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
        List<HRListVO> hrList = hrListService.selectListAll("hrList.selectListAll", scri);
        model.addAttribute("hrList",hrList);

        //board paging
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCri(scri);
        pageMaker.setTotalCount(hrListService.selectTotalNO("hrList.selectTotalNO", scri));
        model.addAttribute("pageMaker", pageMaker);

        return "HRListForm";
    }

}
