package com.parth.bee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parth.bee.app.dao.AccountDAO;
import com.parth.bee.app.model.Account;
import com.parth.bee.app.model.AccountDetailsDTO;


@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountDAO accountDAO;

	@Override
	@Transactional
	public AccountDetailsDTO findByUserId(Integer userId) {
		Account acc = accountDAO.findByUserId(userId);
		AccountDetailsDTO accDetails = null;
		if(acc == null) {
			accDetails = new AccountDetailsDTO();
			accDetails.setMessage("Account does not exists");
		} else {
			accDetails = new AccountDetailsDTO(acc);
		}
		return accDetails;
	}

	@Override
	@Transactional
	public AccountDetailsDTO findByAccountId(Integer accId) {
		Account acc = accountDAO.findByAccountId(accId);
		AccountDetailsDTO accDetails = null;
		if(acc == null) {
			accDetails = new AccountDetailsDTO();
			accDetails.setMessage("Account does not exists");
		} else {
			accDetails = new AccountDetailsDTO(acc);
		}
		return accDetails;
	}

	@Override
	@Transactional
	public AccountDetailsDTO findByAccountNumber(String accNumber) {
		Account acc = accountDAO.findByAccountNumber(accNumber);
		AccountDetailsDTO accDetails = null;
		if(acc == null) {
			accDetails = new AccountDetailsDTO();
			accDetails.setMessage("Account does not exists");
		} else {
			accDetails = new AccountDetailsDTO(acc);
		}
		return accDetails;
	}

}
