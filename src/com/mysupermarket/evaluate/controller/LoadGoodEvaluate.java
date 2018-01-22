package com.mysupermarket.evaluate.controller;

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

import com.mysupermarket.evaluate.service.LoadEvaluateService;
import com.mysupermarket.pojo.GoodEvaluate;

import net.sf.json.JSONObject;

@Controller
public class LoadGoodEvaluate {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private LoadEvaluateService loadEvaluateService;
	
	@RequestMapping(value = "loadevaluate")
	public void LoadEvaluate(@RequestParam("evaluateload")String evaluateload, HttpServletResponse response){
		
		JSONObject evaluate_json = JSONObject.fromObject(evaluateload);
		int goodid = (Integer) evaluate_json.get("goodid");
		int loadnum = (Integer) evaluate_json.get("loadnum");
		int lastid = (Integer) evaluate_json.get("lastid");
		logger.info("获取到的goodid是 : " + goodid);
		logger.info("获取到的loadnum是 : " + loadnum);
		logger.info("获取到的lastid是 : " + lastid);
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<Map<String, Object>> good_evaluate = new ArrayList<Map<String, Object>>();
		
		List<GoodEvaluate> list = loadEvaluateService.GetEvaluateByLastId(goodid, lastid, loadnum);
		if(list != null){
			for(GoodEvaluate list_item : list){
				logger.info("获取到的评论内容是 : " + list_item.getGdlContent());
				Map<String, Object> evaluate_map = new HashMap<String, Object>();
				evaluate_map.put("evaluate_id", list_item.getGdlId());
				evaluate_map.put("username", list_item.getGdlUseraccount());
				evaluate_map.put("evaluate_date", list_item.getGdlDate());
				evaluate_map.put("evaluate_content", list_item.getGdlContent());				
				
				List<Map<String, Object>> good_choose = new ArrayList<Map<String, Object>>();
				String[] choose = list_item.getGdlChose().split(";");
				for(String choose_item : choose){
					Map<String, Object> choose_map = new HashMap<String, Object>();
					String choose_name = choose_item.split(":")[0];
					String choose_value = choose_item.split(":")[1];
					choose_map.put("choose_name", choose_name);
					choose_map.put("choose_value", choose_value);
					good_choose.add(choose_map);
				}
				evaluate_map.put("good_choose", good_choose);
				good_evaluate.add(evaluate_map);
			}
		}
		result.put("good_evaluate", good_evaluate);
		
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
