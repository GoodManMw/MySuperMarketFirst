package com.mysupermarket.order.service;

import com.mysupermarket.pojo.Indent;
import com.mysupermarket.pojo.PayAccount;
import com.mysupermarket.pojo.ReceiveInfo;

public interface PostOrderService {
	public int VerifyPayAccount(PayAccount payAccount);
	public int GetReceiveInfo(ReceiveInfo receiveInfo);
	public int UpdatePayAccount(PayAccount payAccount, double take);
	public int PostOrder(Indent indent, PayAccount payAccount, ReceiveInfo receiveInfo);
}
