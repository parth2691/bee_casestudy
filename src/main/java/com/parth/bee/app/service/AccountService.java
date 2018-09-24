package com.parth.bee.app.service;

import com.parth.bee.app.model.AccountDetailsDTO;

public interface AccountService {
	
	public AccountDetailsDTO findByUserId(Integer userId);
	
	public AccountDetailsDTO findByAccountId(Integer userId);
	
	public AccountDetailsDTO findByAccountNumber(String accNumber);

}
