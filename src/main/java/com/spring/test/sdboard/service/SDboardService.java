package com.spring.test.sdboard.service;

import com.spring.test.sdboard.vo.SDboardVO;
import com.spring.test.suit_board.vo.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface SDboardService {

    public int selectTotalNO(String queryId, SearchCriteria criteria) throws SQLException;
    public List selectListAll(String queryId, SearchCriteria criteria) throws SQLException;
    public SDboardVO selectInfo(String queryId, String sd_board_NO) throws SQLException;
    public void insertSDboard(String queryId, SDboardVO sdboardVO) throws SQLException;
    public void updateSDboard(String queryId, SDboardVO sdboardVO) throws SQLException;
    public void deleteSDboard(String queryId, String sd_board_NO) throws SQLException;
}
