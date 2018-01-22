package com.mysupermarket.login.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.login.dao.UpdateUserAccountDao;
import com.mysupermarket.login.service.ForgetPasswordService;

@Service
public class ForgetPasswordServiceImpl implements ForgetPasswordService{
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private UpdateUserAccountDao updateUserAccount;
	
	@Override
	public boolean IsCorrectEmail(int username, String email) {
		// TODO Auto-generated method stub
		return updateUserAccount.CheckEmail(username, email);
	}
	
	@Override
	public boolean UpdateNewPassword(int username, String newpassword, String email) {
		// TODO Auto-generated method stub
		
		if(this.IsCorrectEmail(username, email)){
			updateUserAccount.UpdateNewPassword(username, newpassword);
			return true;
		}else{
			return false;
		}		
	}
	
}
