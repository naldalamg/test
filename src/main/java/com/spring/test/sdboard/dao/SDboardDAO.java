package com.spring.test.sdboard.dao;


import com.spring.test.sdboard.vo.SDboardVO;
import com.spring.test.suit_board.dao.AbstractDAO;
import com.spring.test.suit_board.vo.SearchCriteria;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("SDboardDAO")
public class SDboardDAO extends AbstractDAO {

    public int selectTotalNO(String queryId, SearchCriteria criteria) throws SQLException{
        return (int) selectOne(queryId, criteria);
    }

    public List selectListAll(String queryId, SearchCriteria criteria) throws SQLException{
        List<SDboardVO> allList = selectList(queryId, criteria);
        return  allList;
    }

    public SDboardVO selectInfo(String queryId, String sd_board_NO) throws SQLException{
        return (SDboardVO) selectOne(queryId, sd_board_NO);
    }
    public void insertSDboard(String queryId, SDboardVO sdboardVO) throws SQLException {
        insert(queryId,sdboardVO);
    }

    public void updateSDboard(String queryId, SDboardVO sdboardVO) throws SQLException{
        update(queryId, sdboardVO);
    }
    public void deleteSDboard(String queryId, String sd_board_NO) throws SQLException{
        delete(queryId, sd_board_NO);
    }
}
