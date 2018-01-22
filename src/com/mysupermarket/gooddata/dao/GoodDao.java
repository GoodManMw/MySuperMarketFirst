package com.mysupermarket.gooddata.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mysupermarket.mapper.GoodMapper;

@Repository
public class GoodDao {
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private GoodMapper goodMapper;
	
	public List<HashMap<String, Object>> LoadGoodData(int datanum, int id){
		List<HashMap<String, Object>> list = goodMapper.SelectByLoadId(id, id + datanum);
		if(list != null)
			return list;
		else
			return null;
	}
	
}
