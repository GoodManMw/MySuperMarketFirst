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

import com.mysupermarket.gooddata.service.LoadGoodDetailService;
import com.mysupermarket.pojo.GoodDetailLoadEntity;
import com.mysupermarket.pojo.GoodEvaluate;

import net.sf.json.JSONObject;

@Controller
public class LoadGoodDetail {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private LoadGoodDetailService loadGoodDetailService;
	
	@RequestMapping(value = "loadgooddetail")
	public void LoadDetail(@RequestParam("infoLoad")String infoLoad, HttpServletResponse response){
		
		JSONObject json_infoLoad = JSONObject.fromObject(infoLoad);
		int good_id = (Integer) json_infoLoad.get("good_id");
		logger.info("获取到的 good_id : " + good_id);
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> infodata = new HashMap<String, Object>();
		List<Map<String,String>> good_url = new ArrayList<Map<String, String>>();
		List<Map<String, Object>> good_choose = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> good_evaluate = new ArrayList<Map<String, Object>>();
		
		List<GoodDetailLoadEntity> list = loadGoodDetailService.LoadDetail(good_id);
		if(list != null){
			GoodDetailLoadEntity gdle = list.get(0);
			
			//添加good_url
			String[] url_array = gdle.getGdUrl().split(";");
			for(String url_item : url_array){
				logger.info("URL 的值为 : " + url_item);
				Map<String, String> url_map = new HashMap<String, String>();
				url_map.put("url", url_item);
				good_url.add(url_map);
			}
			
			//添加good_choose
			String[] choose_array = gdle.getGdChoose().split(";");
			for(String choose_item : choose_array){
				String[] array_item  = choose_item.split(":");
				String choose_name = array_item[0];//取得choose_name
				String[] choose_value = array_item[1].split(",");//取得choose_value				
				Map<String, Object> map_choose_item = new HashMap<String, Object>();
				
				map_choose_item.put("choose_name", choose_name);
				logger.info("取到的类型名字是 : " + choose_name);
				
				List<Map<String, String>> choose_kind = new ArrayList<Map<String, String>>();
				for(String item_choose_value : choose_value){
					Map<String, String> value = new HashMap<String, String>();
					value.put("value", item_choose_value);
					choose_kind.add(value);
					//logger.info("取到的类型的值是 : " + item_choose_value);
				}
				map_choose_item.put("choose_kind", choose_kind);
				
				good_choose.add(map_choose_item);
			}
			
			//添加good_evaluate
			List<GoodEvaluate> evaluate_list = gdle.getGdEvaluate();
			for(GoodEvaluate evaluate_item : evaluate_list){
				Map<String, Object> evaluate_item_map = new HashMap<String, Object>();
				evaluate_item_map.put("username", evaluate_item.getGdlUseraccount());
				evaluate_item_map.put("evaluate_date", evaluate_item.getGdlDate());
				evaluate_item_map.put("evaluate_content", evaluate_item.getGdlContent());
				
				String[] choose_evaluate_array = evaluate_item.getGdlChose().split(";");
				List<Object> choose_evaluate_list = new ArrayList<Object>();
				for(String item_evaluate : choose_evaluate_array){
					String choose_name = item_evaluate.split(":")[0];
					String choose_value = item_evaluate.split(":")[1];					
					Map<String, String> choose_evaluate_map = new HashMap<String, String>();
					choose_evaluate_map.put("choose_name", choose_name);
					choose_evaluate_map.put("choose_value", choose_value);					
					choose_evaluate_list.add(choose_evaluate_map);
					evaluate_item_map.put("good_choose", choose_evaluate_list);
				}
				good_evaluate.add(evaluate_item_map);
			}
			
			//添加infodata
			infodata.put("good_url", good_url);
			infodata.put("good_id", gdle.getGdGood().getgId());
			infodata.put("shop_id", gdle.getGdShop().getSpAccount());
			infodata.put("shop_name", gdle.getGdShop().getSpName());
			infodata.put("good_name", gdle.getGdGood().getgName());
			infodata.put("good_price", gdle.getGdGood().getgPrice());
			infodata.put("good_primeprice", gdle.getGdPrimeprice());
			infodata.put("good_freight", gdle.getGdFreight());
			infodata.put("good_sales", gdle.getGdGood().getgSales());
			infodata.put("good_from", gdle.getGdShop().getSpFrom());
			infodata.put("good_choose", good_choose);
			infodata.put("good_evaluate", good_evaluate);
			
			//添加result
			result.put("infodata", infodata);
			
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
	
}
