package com.mysupermarket.order.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.PayAccountMapper;
import com.mysupermarket.pojo.PayAccount;

@Repository
public class PayAccountDao {
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private PayAccountMapper payAccountMapper;
	
	public PayAccount GetPayAcoount(int pay_account){
		
		PayAccount payAccount = payAccountMapper.verifyPayAcount(pay_account);
		if(payAccount != null){
			logger.info("获取到的pay_passowrd : " + payAccount.getpPaypassword());
			logger.info("获取到的pay_status : " + payAccount.getpStatus());
			return payAccount;
		}
		return null;		
	}
	
	public void  UpdatePayAccount(int payAccount, double pSumMoney){
		payAccountMapper.UpdatePayAccount(payAccount, pSumMoney);
	}
	
	public PayAccount GetByUsername(int username){
		
		List<PayAccount> list = payAccountMapper.getByUsername(username);
		if(list != null){
			if(list.size() > 0){
				return list.get(0);
			}
		}
		return null;
	}
	
}
