package com.mysupermarket.gooddata.service;

import java.util.List;
import java.util.Map;

import com.mysupermarket.pojo.GoodDetailLoadEntity;

public interface LoadGoodDetailService {
	public List<GoodDetailLoadEntity> LoadDetail(int goodid);
}
