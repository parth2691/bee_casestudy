package com.parth.bee.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.parth.bee.app.model.Account;


@Repository
public class AccountDAOImpl implements AccountDAO {

	@PersistenceContext	
	private EntityManager entityManager;
	
	
	
	
	@Override
	public Account findByUserId(Integer userId) {
		
		Query query = entityManager.createQuery("from Account ac where ac.userId.userId=:userId").setParameter("userId", userId);
		 return (Account) query.getSingleResult();
	}

	@Override
	public Account findByAccountId(Integer accId) {
		return entityManager.find(Account.class, accId);
	}

	@Override
	public Account findByAccountNumber(String accNumber) {
		 Query query = entityManager.createQuery("from Account ac where ac.accountNumber=:accountNumber").setParameter("accountNumber", accNumber);
		 return (Account) query.getSingleResult();
	}

	@Override
	public void updateAccount(Account acc) {
		entityManager.merge(acc);
		entityManager.flush();
	}

}
