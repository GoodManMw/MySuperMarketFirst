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

import com.mysupermarket.order.service.GetPayAccountService;
import com.mysupermarket.pojo.PayAccount;

import net.sf.json.JSONObject;

@Controller
public class GetPayAccount {

	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private GetPayAccountService getPayAccountService;
	
	@RequestMapping(value = "getpayaccount")
	public void GetByUserAccount(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession();
		int username = 0; 
		username = (Integer) session.getAttribute("username");
		PayAccount payAccount = null;
		
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, String> payaccount = new HashMap<String, String>();
		
		if(username != 0){
			payAccount = getPayAccountService.GetByUsername(username);
			if(payAccount != null){
//				logger.info("获取到的支付账户是 : " + payAccount.getpAccount());
				payaccount.put("pay_account", String.valueOf(payAccount.getpAccount()));
			}else{
				payaccount.put("pay_account", "noexist");
			}
		}else{
			payaccount.put("pay_account", "nologin");
		}
		result.put("payaccount", payaccount);
		
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
			logger.info("获取printwriter出异常了");
		}
		
	}
			
	
}
