package com.mysupermarket.order.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.IndentMapper;
import com.mysupermarket.pojo.Indent;

@Repository
public class IndentDao {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private IndentMapper indentMapper;
	
	public int SaveIndent(Indent indent){
		
		return indentMapper.saveIndent(indent);
		
	}
	
}
