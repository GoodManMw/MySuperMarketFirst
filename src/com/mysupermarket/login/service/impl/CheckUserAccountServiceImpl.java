package com.mysupermarket.login.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.login.dao.GetUserAccountDao;
import com.mysupermarket.login.service.CheckUserAccountService;
import com.mysupermarket.pojo.UserAccount;

@Service
public class CheckUserAccountServiceImpl implements CheckUserAccountService{
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private GetUserAccountDao getUserAccount;
	
	@Override
	public UserAccount CheckOut(int userAccount) {
		// TODO Auto-generated method stub
		return getUserAccount.Get(userAccount);
	}
	
	@Override
	public int IsCorrect(int userAccount, String password) {
		// TODO Auto-generated method stub
		UserAccount user = this.CheckOut(userAccount);
		if(user == null){
			return -1;//查无此账号
		}else{
			if(password.equals(user.getUaPassword())){
				logger.info("获取到的密码为" + user.getUaPassword());
				return 1;//密码正确
			}else{
				return 0;//密码错误
			}
		}
	}
}
