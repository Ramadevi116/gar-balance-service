package com.keybank.balance.dao;

import com.keybank.balance.model.BalanceDaoRequest;
import com.keybank.balance.model.BalanceDaoResp;

public class BalanceDomesticDaoImpl implements IBalanceDao {

	@Override
	public BalanceDaoResp getBalance(BalanceDaoRequest daoRequest) {
		// TODO Connect to international database to get the balance details
		return null;
	}

}
