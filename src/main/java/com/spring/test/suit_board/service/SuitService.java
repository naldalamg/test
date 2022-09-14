package com.spring.test.suit_board.service;


import com.spring.test.suit_board.vo.SearchCriteria;
import com.spring.test.suit_board.vo.SuitVO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface SuitService {

	public int selectTotalNO(String queryId, SearchCriteria scri) throws SQLException;
	
	public List selectListAll(String queryId, SearchCriteria scri) throws SQLException;
	
	public SuitVO selectInfo(String queryId, String req_no) throws SQLException;
	
	public List selectFileInfo(String queryId, String req_no) throws SQLException;

	public List selectCode(String queryId) throws SQLException;
	
	public String selectNO(String queryId, String member_id) throws SQLException;
	
	public void insertSuit(String queryId, SuitVO suitVO) throws SQLException;

	public void insertIC(String queryId, SuitVO suitVO) throws SQLException;

	public void insertFile(String queryId, Map fileMap) throws SQLException;
	public List insertFile(String queryId, String req_no, MultipartHttpServletRequest request) throws Exception;
	
	public void updateSuit(String queryId, SuitVO suitVO) throws SQLException;
	
	public void updateIC(String queryId, SuitVO suitVO) throws SQLException;

	public void deleteFileAll(String queryId, String req_no) throws SQLException;
	public void deleteFile(String queryId, String req_no, List deleteList) throws SQLException;

	public void deleteAll(String queryId, String req_no) throws SQLException;


}
