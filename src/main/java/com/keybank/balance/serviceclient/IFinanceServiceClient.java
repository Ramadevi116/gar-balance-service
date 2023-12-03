package com.keybank.balance.serviceclient;

import com.keybank.balance.model.FinanceServiceRequest;
import com.keybank.balance.model.FinanceServiceResponse;

public interface IFinanceServiceClient {

	FinanceServiceResponse getRegionInfo(FinanceServiceRequest request);
}
