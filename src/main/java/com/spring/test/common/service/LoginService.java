package com.spring.test.common.service;


import com.spring.test.common.dao.SecurityDAO;
import com.spring.test.common.vo.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("loginService")
public class LoginService implements UserDetailsService{

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ArrayList<String> authList = new ArrayList<String>();
		SecurityDAO dao = sqlSession.getMapper(SecurityDAO.class);
		
		UserVO userVO = dao.selectUser(username);
		authList = dao.getAuthList(username);
		
		if (userVO == null) { //User을 찾지 못했을 경우
			throw new UsernameNotFoundException(username);
		}
		else {
			userVO.setAuthority(authList);
		}
		
		return userVO; //완전한 vo 객체
	}
	
	
}
