package com.parth.bee.app.service;

import com.parth.bee.app.model.AccountDetailsDTO;


public interface BankTransactionService {

	AccountDetailsDTO transact(Integer userId,String payeeUserName,float amount);
	
	
}
