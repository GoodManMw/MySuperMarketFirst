package com.mysupermarket.gooddata.service;

import java.util.HashMap;
import java.util.List;

public interface LoadGoodDataService {
	public List<HashMap<String, Object>> GetGoodData(int id, int datanum);
}
