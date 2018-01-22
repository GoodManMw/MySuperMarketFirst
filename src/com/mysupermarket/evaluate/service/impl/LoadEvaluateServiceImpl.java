package com.mysupermarket.evaluate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.evaluate.dao.GoodEvaluateDao;
import com.mysupermarket.evaluate.service.LoadEvaluateService;
import com.mysupermarket.pojo.GoodEvaluate;

@Service
public class LoadEvaluateServiceImpl implements LoadEvaluateService{
	
	@Autowired
	private GoodEvaluateDao goodEvaluateDao;
	
	@Override
	public List<GoodEvaluate> GetEvaluateByLastId(int goodid, int lastid, int loadnum) {
		// TODO Auto-generated method stub
		return goodEvaluateDao.GetEvaluateByLastId(goodid, lastid, loadnum);
	}
	
}
