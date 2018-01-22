package com.mysupermarket.login.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.UserAccountMapper;
import com.mysupermarket.pojo.UserAccount;

@Repository
public class UpdateUserAccountDao {
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	public boolean CheckEmail(int username, String email){
		logger.info("username = " + username);
		List<UserAccount> list = userAccountMapper.getUserAccountByEmail(username, email);
		if(list.size() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public void UpdateNewPassword(int username, String newpassword){
		userAccountMapper.updatePassword(username, newpassword);
	}
	
}
