package com.mysupermarket.order.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysupermarket.order.service.GetReceiveInfoService;
import com.mysupermarket.pojo.ReceiveInfo;

import net.sf.json.JSONObject;

@Controller
public class GetReceiveInfo {
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private GetReceiveInfoService getReceiveInfoService;
	
	@RequestMapping(value = "getreceiveinfo")
	public void GetReceive(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		int username = (Integer) session.getAttribute("username");
			
		ReceiveInfo receiveInfo = getReceiveInfoService.GetReceiveInfo(username);
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String> info = new HashMap<String, String>();
		
		if(receiveInfo != null){
			logger.info("获取到的收货人姓名是 : " + receiveInfo.getrName());
			logger.info("获取到的收货人的地址是 : " + receiveInfo.getrAddress());
			logger.info("获取到的收货人的电话是 : " + receiveInfo.getrPhone());
			info.put("name", receiveInfo.getrName());
			info.put("phone", String.valueOf(receiveInfo.getrPhone()));
			info.put("address", receiveInfo.getrAddress());			
		}
		result.put("info", info);
		
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
