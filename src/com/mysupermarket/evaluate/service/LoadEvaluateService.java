package com.mysupermarket.evaluate.service;

import java.util.List;

import com.mysupermarket.pojo.GoodEvaluate;

public interface LoadEvaluateService {
	public List<GoodEvaluate> GetEvaluateByLastId(int goodid, int lastid, int loadnum);
}
