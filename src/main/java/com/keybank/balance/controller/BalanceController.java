package com.keybank.balance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.keybank.balance.model.BalanceRequest;
import com.keybank.balance.model.BalanceResponse;
import com.keybank.balance.service.BalanceServiceImpl;
import com.keybank.balance.service.IBalanceService;
import com.keybank.balance.validator.BalanceRequestValidator;

@RestController
public class BalanceController {
	@Autowired
	BalanceRequestValidator balanceRequestValidator;
	
	@Autowired
	IBalanceService balanceService;
	
	@GetMapping("/v1/balance/{cardnumber}")
	@ResponseBody
	public BalanceResponse getBalance(@PathVariable("cardnumber") String cardnumber,
									  @RequestHeader("x-client-id") String clientId,
									  @RequestHeader("x-channel-id")String channelId,
									  @RequestHeader("x-correlation-id") String correlationId,
									  @RequestHeader("x-message-ts") String messagets){
		
		// 1.Get the Request from client/consumer
		BalanceRequest balancerequest=new BalanceRequest();
	
		// 2.Validate the Request
		balanceRequestValidator.validatorRequest(balancerequest);
		
		// 3.Prepare request for Service layer
		// 4.Call service layer and get the response
		BalanceResponse balanceResp=balanceService.getBalance(balancerequest);
		
		
		
		return null;
	}
}
