package com.mysupermarket.gooddata.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysupermarket.gooddata.service.LoadGoodDataService;

import net.sf.json.JSONObject;

@Controller
public class LoadGoodData {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	LoadGoodDataService loadGoodDataService;
	
	@RequestMapping(value = "loadgooddata")
	public void LoadData(@RequestParam("dataload")String dataload, HttpServletResponse response){
		
		JSONObject json_dataload = JSONObject.fromObject(dataload);
		int datanum = (Integer) json_dataload.get("datanum");
		int lastid = (Integer) json_dataload.get("lastid");
		++lastid;//先++获得当前开始加载的id
		logger.info("获取到的datanum : " + datanum + " 获取到的lastid : " + lastid);
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map> data = new ArrayList<Map>();
		
		//调用service层出来加载商品数据业务
		List<HashMap<String, Object>> list = loadGoodDataService.GetGoodData(lastid, datanum);
		if(list != null){
			for(HashMap<String, Object> list_item : list){
				Map<String, Object> data_map = new HashMap<String, Object>();
				data_map.put("good_id", list_item.get("g_id"));
				data_map.put("good_kind", list_item.get("g_kind"));
				data_map.put("good_url", list_item.get("g_url"));
				data_map.put("good_name", list_item.get("g_name"));								
				data_map.put("good_price", list_item.get("g_price"));
				data_map.put("good_sales", list_item.get("g_sales"));
				data.add(data_map);
			}
		}
		result.put("data", data);
		
		response.setContentType("text/json;charset=utf-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSONObject.fromObject(result));
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("获取PrintWriter出错");
		}
		
	}
	
}
