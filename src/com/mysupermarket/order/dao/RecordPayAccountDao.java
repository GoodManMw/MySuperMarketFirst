package com.mysupermarket.order.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.RecordPayAccountMapper;
import com.mysupermarket.pojo.RecordPayAccount;

@Repository
public class RecordPayAccountDao {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private RecordPayAccountMapper recordPayAccountMapper;
	
	public int SaveRecordPayAccount(RecordPayAccount recordPayAccount){
		return recordPayAccountMapper.saveRecordPayAccount(recordPayAccount);
	}
	
}
