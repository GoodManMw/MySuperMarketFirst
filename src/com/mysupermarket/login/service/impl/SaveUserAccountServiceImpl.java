package com.mysupermarket.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.login.dao.SaveUserAccountDao;
import com.mysupermarket.login.service.CheckUserAccountService;
import com.mysupermarket.login.service.SaveUserAccountService;
import com.mysupermarket.pojo.UserAccount;

@Service
public class SaveUserAccountServiceImpl implements SaveUserAccountService{

	@Autowired
	private CheckUserAccountService checkUserAccountService;
	@Autowired
	private SaveUserAccountDao saveUserAccount;
	
	/*
	 * 作用 :
	 * 		先查询个人账户表该手机号码是否已经被注册过
	 * 		被注册过直接返回
	 * 		未被注册保存该记录
	 * 
	 * param :
	 * 		UserAccount
	 * 
	 * return :
	 * 		0 : 被注册过
	 * 		1 : 注册成功
	 * 
	 * */
	@Override
	public int Save(UserAccount userAccount) {
		// TODO Auto-generated method stub
		
		UserAccount check = checkUserAccountService.CheckOut(userAccount.getUaUsername());
		if(check != null){
			return 0;
		}else{
			saveUserAccount.Save(userAccount);
			return 1;
		}
	}
	
}
