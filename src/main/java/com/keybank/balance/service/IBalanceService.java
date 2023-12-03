package com.keybank.balance.service;

import com.keybank.balance.model.BalanceRequest;
import com.keybank.balance.model.BalanceResponse;

public interface IBalanceService {
 
	BalanceResponse getBalance(BalanceRequest balanceRequest);
}
