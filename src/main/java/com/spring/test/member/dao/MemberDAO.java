package com.spring.test.member.dao;


import com.spring.test.member.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {


	public void giveAuth(String username, String authority);

	//회원가입
	public void userSignUp(MemberVO memberVO);

	//아이디 중복확인
	public String duplicateID(String member_id);
	
	//회원탈퇴
	public void deleteID(String member_id);

	public String selectEnabled(String member_id);
}
