package com.spring.test.member.service;


import com.spring.test.member.dao.MemberDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//아이디 중복확인
	public String duplicateID(String member_id) {
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		return dao.duplicateID(member_id);
	}
	
	//회원탈퇴
	public String deleteID(String member_id) {
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		dao.deleteID(member_id);
		String result = dao.selectEnabled(member_id);
		return result;
	}
	

	}

	

