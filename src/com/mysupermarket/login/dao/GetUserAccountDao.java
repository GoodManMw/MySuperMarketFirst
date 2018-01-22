package com.mysupermarket.login.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.UserAccountMapper;
import com.mysupermarket.pojo.UserAccount;

@Repository
public class GetUserAccountDao {
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	public UserAccount Get(int username){		
		
		List<UserAccount> list = userAccountMapper.getUserAccount(username);
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
		
	}
	
}
