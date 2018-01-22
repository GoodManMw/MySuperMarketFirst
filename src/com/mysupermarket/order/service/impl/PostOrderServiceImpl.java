package com.mysupermarket.order.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mysupermarket.order.dao.IndentDao;
import com.mysupermarket.order.dao.PayAccountDao;
import com.mysupermarket.order.dao.ReceiveInfoDao;
import com.mysupermarket.order.dao.RecordPayAccountDao;
import com.mysupermarket.order.service.PostOrderService;
import com.mysupermarket.pojo.Indent;
import com.mysupermarket.pojo.PayAccount;
import com.mysupermarket.pojo.ReceiveInfo;
import com.mysupermarket.pojo.RecordPayAccount;

@Service
public class PostOrderServiceImpl implements PostOrderService{
	
	private Log logger = LogFactory.getLog(getClass());
	@Autowired
	private PayAccountDao payAccountDao;
	@Autowired
	private ReceiveInfoDao receiveInfoDao;
	@Autowired
	private RecordPayAccountDao recordPayAccountDao;
	@Autowired
	private IndentDao indentDao;
	
	@Override
	public int VerifyPayAccount(PayAccount verifiedPayAccount) {
		// TODO Auto-generated method stub
		PayAccount payAccount = payAccountDao.GetPayAcoount(verifiedPayAccount.getpAccount());
		if(payAccount != null){
			if(payAccount.getpStatus().equals("冻结")){
				return 0;
			}else{
				if(payAccount.getpPaypassword().equals(verifiedPayAccount.getpPaypassword())){
					return 1;
				}
				return -1;
			}
		}
		return -2;
	}
	
	@Override
	public int GetReceiveInfo(ReceiveInfo receiveInfo) {
		// TODO Auto-generated method stub
		ReceiveInfo getReceiveInfo = receiveInfoDao.Get(receiveInfo.getrName(), receiveInfo.getrPhone(), receiveInfo.getrAddress());
		if(getReceiveInfo != null)
			return getReceiveInfo.getrId();
		return 0;
	}
	
	@Override
	public int UpdatePayAccount(PayAccount payAccount, double take) {
		// TODO Auto-generated method stub
		PayAccount getPSumMoney = payAccountDao.GetPayAcoount(payAccount.getpAccount());
		if(getPSumMoney != null){
			double pSumMoney = getPSumMoney.getpSumMoney() - take;
			if(pSumMoney > 0){
				payAccountDao.UpdatePayAccount(payAccount.getpAccount(), pSumMoney);
				return 1;//正常状态
			}
			return 0;//余额不足
		}
		return -1;//异常状态
	}
	
	@Transactional
	@Override
	public int PostOrder(Indent indent, PayAccount payAccount, ReceiveInfo receiveInfo) {
		// TODO Auto-generated method stub
		int receiveInfoId = this.GetReceiveInfo(receiveInfo);
		if(receiveInfoId != 0){
			
			//更新账户余额
			indent.setiReceive(receiveInfoId);
			int updatePayAccountStatus = this.UpdatePayAccount(payAccount, indent.getiTake());
			
			//保存消费记录
			RecordPayAccount recordPayAccount = new RecordPayAccount();
			recordPayAccount.setRpaMoney(indent.getiTake());
			recordPayAccount.setRpaKind("consume");
			recordPayAccount.setRpaDate(indent.getiDate());
			recordPayAccount.setRpaPayaccount(payAccount.getpAccount());
			recordPayAccountDao.SaveRecordPayAccount(recordPayAccount);
			if(recordPayAccount.getRpaId() <= 0){
				throw new RuntimeException();//插入消费记录出错, 主动抛出异常
			}			
			
			if(updatePayAccountStatus == 1){//支付账户余额更新正常
				//提交订单
				int recordNum = indentDao.SaveIndent(indent);
				logger.info("插入Indent记录数为 : " + recordNum);
				logger.info("插入的Indent的主键为 : " + indent.getiId());
				if(indent.getiId() > 0){
					return 1;
				}
				throw new RuntimeException();//插入订单出错, 自动抛出异常
			}else if(updatePayAccountStatus == 0){//支付账户余额不足
				return 0;
			}else{//支付账户状态异常
				return -2;
			}
		}else{
			return -1;//获取收货信息id出错
		}
	}
	
}
