package com.mysupermarket.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.order.dao.ReceiveInfoDao;
import com.mysupermarket.order.service.GetReceiveInfoService;
import com.mysupermarket.pojo.ReceiveInfo;

@Service
public class GetReceiveInfoServiceImpl implements GetReceiveInfoService{
	
	@Autowired
	private ReceiveInfoDao receiveInfoDao;
	
	@Override
	public ReceiveInfo GetReceiveInfo(int username) {
		// TODO Auto-generated method stub
		return receiveInfoDao.Get(username);
	}
	
	
}
