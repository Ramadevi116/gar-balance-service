package com.keybank.balance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keybank.balance.builder.BalanceRequestBuilder;
import com.keybank.balance.builder.BalanceResponseBuilder;
import com.keybank.balance.dao.IBalanceDao;
import com.keybank.balance.model.BalanceDaoRequest;
import com.keybank.balance.model.BalanceDaoResp;
import com.keybank.balance.model.BalanceRequest;
import com.keybank.balance.model.BalanceResponse;
import com.keybank.balance.model.FinanceServiceRequest;
import com.keybank.balance.model.FinanceServiceResponse;
import com.keybank.balance.serviceclient.IFinanceServiceClient;

@Component
public class BalanceServiceImpl implements IBalanceService {
	@Autowired
	private IFinanceServiceClient financeServiceClient;
	
	@Autowired
	 IBalanceDao balanceDomesticDao;
	
	@Autowired
	IBalanceDao balanceIntlDao;
	
	@Autowired
	BalanceRequestBuilder balanceRequestBuilder;
	
	@Autowired
	BalanceResponseBuilder balanceResponseBuilder;
	@Override
	public BalanceResponse getBalance(BalanceRequest balanceRequest) {
		BalanceDaoResp daoResponse=null;
		BalanceResponse balanceResp=null;
		//1. Get request from controller layer
		
		//2. Prepare request for financeServiceClient layer
		// i.e. with the help of balance request
		
		FinanceServiceRequest request=balanceRequestBuilder.buildFinanceRequest(balanceRequest);
		
		//3. call the financeServiceClient and get the response
		
		FinanceServiceResponse financeResp=financeServiceClient.getRegionInfo(request);
		
		//4. Apply Business logic on financeServiceClient response.
		//  i.e.decide domestic card or International card
		
		//5. Prepare the Request for Intl layer-2 i.e. BalanceDomesticDaoRequest
		
		//6. Call Domesticdao and get the response else call IntlDao and get the response
		
		BalanceDaoRequest daoRequest = balanceRequestBuilder.buildDaoRequest(balanceRequest);
		
		if("domestic".equals(financeResp.getRegion())) {
			
			 daoResponse=balanceDomesticDao.getBalance(daoRequest);
			
		}else if("intl".equals(financeResp.getRegion())){
			
			 daoResponse=balanceIntlDao.getBalance(daoRequest);
			
		}else {
			
			//Todo : Throw the user defined exception invalid region id or region not found.
			
		}
		
		
		//7. prepare the balance response with the help of service resp and dao resp
		
		balanceResp=balanceResponseBuilder.buildBalanceResponse(daoResponse,financeResp);
		
		//8. Send balance resp to controller
		
		
		
		return balanceResp;
	}

}
