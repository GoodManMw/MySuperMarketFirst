package com.mysupermarket.login.controller;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysupermarket.login.service.CheckUserAccountService;

import net.sf.json.JSONObject;

@Controller
@Transactional
public class Login {
	
	private final Log logger = LogFactory.getLog(getClass());
	@Autowired
	private CheckUserAccountService checkUserAccountService;
	
	/*
	 * 作用 : 
	 * 		从请求中获取到账号密码进行验证, 返回结果
	 * param : account
	 * return : json
	 * */
	@RequestMapping(value = "login")
	public void CheckUserAccount(@RequestParam("account")String account, HttpServletRequest request, HttpServletResponse response){
		
		JSONObject json_account = JSONObject.fromObject(account);//从请求中获取账号信息
		int username = (Integer)json_account.get("username");
		String password = json_account.getString("password");
		logger.info("username = " + username + " password = " + password);
		
		int status;
		status = checkUserAccountService.IsCorrect(username, password);//验证账号密码
		
		//封装返回结果的json数据
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String> info_json = new HashMap<String, String>();
		
		HttpSession session = request.getSession();
		
		if(status == 1){
			info_json.put("status", "success");
			session.setAttribute("username", username);
		}else if(status == 0){
			info_json.put("status", "errorpassword");
		}else{
			info_json.put("status", "noexitaccount");
		}
		result.put("info", info_json);
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
