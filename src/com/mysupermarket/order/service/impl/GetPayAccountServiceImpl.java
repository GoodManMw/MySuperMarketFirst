package com.mysupermarket.order.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.order.dao.PayAccountDao;
import com.mysupermarket.order.service.GetPayAccountService;
import com.mysupermarket.pojo.PayAccount;

@Service
public class GetPayAccountServiceImpl implements GetPayAccountService{
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private PayAccountDao payAccountDao;
	
	@Override
	public PayAccount GetByUsername(int username) {
		// TODO Auto-generated method stub
		return payAccountDao.GetByUsername(username);
	}
	
}
