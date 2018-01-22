package com.mysupermarket.login.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.UserAccountMapper;
import com.mysupermarket.pojo.UserAccount;

@Repository
public class SaveUserAccountDao {

	@Autowired
	private UserAccountMapper userAccountMapper;
	
	public void Save(UserAccount userAccount){
		userAccountMapper.insert(userAccount);
	}
	
}
