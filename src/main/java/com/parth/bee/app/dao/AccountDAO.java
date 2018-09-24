package com.parth.bee.app.dao;

import com.parth.bee.app.model.Account;

public interface AccountDAO {
	public Account findByUserId(Integer userId);
	
	public Account findByAccountId(Integer userId);
	
	public Account findByAccountNumber(String accNumber);
	
	public void updateAccount(Account acc);

}
