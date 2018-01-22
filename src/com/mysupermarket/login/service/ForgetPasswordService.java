package com.mysupermarket.login.service;

public interface ForgetPasswordService {
	public boolean IsCorrectEmail(int username, String email);
	public boolean UpdateNewPassword(int username, String newpassword, String email);
}
