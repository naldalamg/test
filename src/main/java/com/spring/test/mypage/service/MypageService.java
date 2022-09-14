package com.spring.test.mypage.service;


import com.spring.test.member.vo.MemberVO;

import java.sql.SQLException;

public interface MypageService {

	public MemberVO selectMemberInfo(String queryId, String member_id) throws SQLException;

	public String selectPwd(String queryId, String member_id)throws SQLException;
	
	public void updateMemberInfo(String queryId, MemberVO memberVO) throws SQLException;


}
