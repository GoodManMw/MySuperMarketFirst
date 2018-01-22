package com.mysupermarket.order.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.ReceiveInfoMapper;
import com.mysupermarket.pojo.ReceiveInfo;

@Repository
public class ReceiveInfoDao {
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ReceiveInfoMapper  receiveInfoMapper;
	
	public ReceiveInfo Get(int username){
		return receiveInfoMapper.SelectByUseraccount(username);
	}
	
	public ReceiveInfo Get(String name, int phone, String address){
		ReceiveInfo getReceiveInfo = receiveInfoMapper.get(name, phone, address);
		if(getReceiveInfo != null){
			logger.info("获取到的收货信息的id : " + getReceiveInfo.getrId() + " 收货人是 : " + getReceiveInfo.getrName());
			return getReceiveInfo;
		}
		return null;
	}
	
}
