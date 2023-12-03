package com.keybank.balance.dao;

import com.keybank.balance.model.BalanceDaoRequest;
import com.keybank.balance.model.BalanceDaoResp;

public interface IBalanceDao {
 
	BalanceDaoResp getBalance(BalanceDaoRequest daoRequest);

}
