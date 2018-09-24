package com.parth.bee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parth.bee.app.dao.AccountDAO;
import com.parth.bee.app.dao.BankTransactionDAO;
import com.parth.bee.app.dao.LoginDAO;
import com.parth.bee.app.dao.PayeeDAO;
import com.parth.bee.app.model.Account;
import com.parth.bee.app.model.AccountDetailsDTO;
import com.parth.bee.app.model.BankTransaction;
import com.parth.bee.app.model.User;

@Service
public class BankTransactionServiceImpl implements BankTransactionService {
	
	@Autowired
	LoginDAO loginDAO;
	
	@Autowired
	PayeeDAO payeeDAO;
	
	@Autowired
	AccountDAO accountDAO;
	
	@Autowired
	BankTransactionDAO bankTransactionDao;

	@Override
	@Transactional
	public AccountDetailsDTO transact(Integer userId, String receiverUserName, float amount) {
		User receiver = loginDAO.findByUserName(receiverUserName);
		User user = loginDAO.findByUserId(userId);
		AccountDetailsDTO accDetails = null;
		if(receiver==null) {
			accDetails = new AccountDetailsDTO();
			accDetails.setMessage("Payee Does not exists");
		} else {
			if(payeeDAO.checkPayeeExists(userId, receiver.getUserId())) {
				Account userAccount = accountDAO.findByUserId(userId);
				if(amount<=userAccount.getBalance()) {
					Account recieverAccount = accountDAO.findByUserId(receiver.getUserId());
					userAccount.setBalance(userAccount.getBalance()-amount);
					recieverAccount.setBalance(recieverAccount.getBalance()+amount);
					BankTransaction bkUser = new BankTransaction();
					bkUser.setPayerId(user);
					bkUser.setRecieverId(receiver);
					bkUser.setAmount(amount);
					bkUser.setType("CR");
					accountDAO.updateAccount(recieverAccount);
					accountDAO.updateAccount(userAccount);
					bankTransactionDao.saveTransaction(bkUser);
					accDetails = new AccountDetailsDTO(userAccount);
					accDetails.setMessage("Transaction Completed!");
					
				} else {
					accDetails = new AccountDetailsDTO();
					accDetails.setMessage("Insufficient funds");
				}
			} else {
				accDetails = new AccountDetailsDTO();
				accDetails.setMessage("Payee Does not exists");
			}
		}
		return accDetails;
	}

}
