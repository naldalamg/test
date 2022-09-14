package com.spring.test.hrList.service;


import com.spring.test.hrList.dao.HRListDAO;
import com.spring.test.hrList.vo.HRListVO;
import com.spring.test.suit_board.vo.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class HRListServiceImpl implements HRListService{

    @Autowired
    private HRListDAO hrListDAO;

    @Override
    public int selectTotalNO(String queryId, SearchCriteria scri) throws SQLException {
        return hrListDAO.selectTotalNO(queryId, scri);
    }

    @Override
    public List<HRListVO> selectListAll(String queryId, SearchCriteria scri) throws SQLException {
        List<HRListVO> hrList = hrListDAO.selectListAll(queryId, scri);
        return hrList;
    }

}
