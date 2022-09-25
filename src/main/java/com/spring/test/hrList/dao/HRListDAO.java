package com.spring.test.hrList.dao;


import com.spring.test.hrList.vo.HRListVO;
import com.spring.test.suit_board.dao.AbstractDAO;
import com.spring.test.suit_board.vo.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class HRListDAO extends AbstractDAO {

    public int selectTotalNO(String queryId, SearchCriteria scri) throws  SQLException{
        int result = (Integer) selectOne(queryId, scri);
        return result;
    }

    public List selectListAll(String queryId, SearchCriteria scri) throws SQLException{
        List<HRListVO> hrList = selectList(queryId, scri);
        return hrList;
    }
}
