package com.spring.test.common.dao;


import com.spring.test.common.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface SecurityDAO {
	 
	public UserVO selectUser(String username);
	public ArrayList<String> getAuthList(String username);

}
