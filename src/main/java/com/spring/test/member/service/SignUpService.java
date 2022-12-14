package com.spring.test.member.service;


import com.spring.test.member.dao.MemberDAO;
import com.spring.test.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("signUpService")
public class SignUpService {

	@Autowired
	private BCryptPasswordEncoder bPasswordEncoder;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//회원가입
	public boolean insertUserInfo(MemberVO memberVO) {
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		//비밀번호 암호화해서 db에 저장
		memberVO.setMember_pw(bPasswordEncoder.encode(memberVO.getMember_pw()));
//		System.out.println(memberVO.getMember_pw());
		if (memberVO != null) {
			dao.userSignUp(memberVO); //유저 등록
			return true;
		}
		else 
			return false;
		
	}

}
