package com.spring.test.mypage.dao;

import com.spring.test.member.vo.MemberVO;
import com.spring.test.suit_board.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository("mypageDAO")
public class MypageDAO extends AbstractDAO {

	public MemberVO selectMemberInfo(String queryId, String member_id) throws SQLException{
		return (MemberVO) selectOne(queryId, member_id);
	}
	
	public String selectPwd(String queryId, String member_id)throws SQLException{
		return (String) selectOne(queryId, member_id);
	}
	
	public void updateMemberInfo(String queryId, MemberVO memberVO) throws SQLException{
		update(queryId, memberVO);
	}
}
