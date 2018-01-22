package com.mysupermarket.gooddata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysupermarket.gooddata.dao.GoodDetailDao;
import com.mysupermarket.gooddata.service.LoadGoodDetailService;
import com.mysupermarket.pojo.GoodDetailLoadEntity;

@Service
public class LoadGoodDetailServiceImpl implements LoadGoodDetailService{
	
	@Autowired
	private GoodDetailDao goodDetailDao;
	
	@Override
	public List<GoodDetailLoadEntity> LoadDetail(int goodid) {
		// TODO Auto-generated method stub
		return goodDetailDao.GetGoodDetail(goodid);
	}
	
}
