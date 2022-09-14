package com.spring.test.hrList.service;



import com.spring.test.hrList.vo.HRListVO;
import com.spring.test.suit_board.vo.SearchCriteria;

import java.sql.SQLException;
import java.util.List;

public interface HRListService {

    public int selectTotalNO(String queryId, SearchCriteria scri) throws SQLException;
    public List<HRListVO> selectListAll(String queryId, SearchCriteria scri) throws SQLException;

}
