package com.mysupermarket.gooddata.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.gooddata.dao.GoodDao;
import com.mysupermarket.gooddata.service.LoadGoodDataService;

@Service
public class LoadGoodDataServiceImpl implements LoadGoodDataService{
	
	@Autowired
	private GoodDao goodDao;
	
	@Override
	public List<HashMap<String, Object>> GetGoodData(int id, int datanum) {
		// TODO Auto-generated method stub
		return goodDao.LoadGoodData(datanum, id);
	}
	
}
