package com.mysupermarket.order.service;

import com.mysupermarket.pojo.PayAccount;

public interface GetPayAccountService {
	public PayAccount GetByUsername(int username);
}
