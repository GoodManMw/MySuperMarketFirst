package com.mysupermarket.login.service;

import com.mysupermarket.pojo.UserAccount;

public interface CheckUserAccountService {
	public UserAccount CheckOut(int userAccount);
	public int IsCorrect(int userAccount, String password);
}
