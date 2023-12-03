package com.keybank.balance.builder;

import com.keybank.balance.model.BalanceDaoRequest;
import com.keybank.balance.model.BalanceRequest;
import com.keybank.balance.model.FinanceServiceRequest;

public class BalanceRequestBuilder {

	public FinanceServiceRequest buildFinanceRequest(BalanceRequest balanceRequest) {
		// TODO Auto-generated method stub
		
		FinanceServiceRequest request=new FinanceServiceRequest();
		request.setCardnumber(balanceRequest.getCardnumber());
		request.setClientId(balanceRequest.getClientId());
		request.setRequestId(balanceRequest.getCorrelationId());
		
		return request;
	}

	public BalanceDaoRequest buildDaoRequest(BalanceRequest balanceRequest) {
		// TODO Auto-generated method stub

		BalanceDaoRequest daoRequest=new BalanceDaoRequest();
		daoRequest.setCardnumber(balanceRequest.getCardnumber());
		daoRequest.setClientId(balanceRequest.getClientId());
		daoRequest.setRequestId(balanceRequest.getCorrelationId());
		
		
		return daoRequest;
	}

}
