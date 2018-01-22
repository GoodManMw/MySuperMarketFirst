package com.mysupermarket.evaluate.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.GoodEvaluateMapper;
import com.mysupermarket.pojo.GoodEvaluate;

@Repository
public class GoodEvaluateDao {
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private GoodEvaluateMapper goodEvaluateMapper;
	
	public List<GoodEvaluate> GetEvaluateByLastId(int goodid, int lastid, int loadnum){
		return goodEvaluateMapper.getEvaluateByLastId(goodid, lastid, loadnum);
	}
	
}
