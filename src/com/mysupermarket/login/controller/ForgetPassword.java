package com.mysupermarket.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysupermarket.login.service.ForgetPasswordService;

import net.sf.json.JSONObject;

@Controller
public class ForgetPassword {
	
	Log logger = LogFactory.getLog(getClass());
	@Autowired
	private ForgetPasswordService forgetPasswordService;
	
	@RequestMapping(value = "forgetpassword")
	public void ChangePassword(@RequestParam("info")String info, HttpServletResponse response){
		
		JSONObject json_info = JSONObject.fromObject(info);
		int username = (Integer)json_info.get("username");
		String email = (String)json_info.get("email");
		String newpassword = (String)json_info.get("newpassword");
		logger.info("获取到的额username是 : " + username + " 获取到的email是 : " + email + " 获取到的newpassword是 : " + newpassword);
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String> info_map = new HashMap<String, String>();
		
		if(forgetPasswordService.UpdateNewPassword(username, newpassword, email)){
			info_map.put("status", "success");
		}else{
			info_map.put("status", "erroremail");
		}
		result.put("info", info_map);
		
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
