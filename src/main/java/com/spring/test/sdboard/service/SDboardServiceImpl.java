package com.spring.test.sdboard.service;


import com.spring.test.sdboard.dao.SDboardDAO;
import com.spring.test.sdboard.vo.SDboardVO;
import com.spring.test.suit_board.vo.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SDboardServiceImpl implements SDboardService{

    @Autowired
    private SDboardDAO sdboardDAO;

    @Override
    public int selectTotalNO(String queryId, SearchCriteria criteria) throws SQLException {
        return sdboardDAO.selectTotalNO(queryId, criteria);
    }

    @Override
    public List selectListAll(String queryId, SearchCriteria criteria) throws SQLException {
        List<SDboardVO> allList = sdboardDAO.selectListAll(queryId, criteria);
        return allList;
    }

    @Override
    public SDboardVO selectInfo(String queryId, String sd_board_NO) throws SQLException {
        return sdboardDAO.selectInfo(queryId, sd_board_NO);
    }

    @Override
    public void insertSDboard(String queryId, SDboardVO sdboardVO) throws SQLException {
        sdboardDAO.insertSDboard(queryId, sdboardVO);
    }

    public void updateSDboard(String queryId, SDboardVO sdboardVO) throws SQLException{
        sdboardDAO.updateSDboard(queryId, sdboardVO);
    }
    @Override
    public void deleteSDboard(String queryId, String sd_board_NO) throws SQLException {
        sdboardDAO.deleteSDboard(queryId, sd_board_NO);
    }
}
