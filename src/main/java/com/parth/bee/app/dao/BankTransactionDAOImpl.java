package com.parth.bee.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.parth.bee.app.model.BankTransaction;


@Repository
public class BankTransactionDAOImpl implements BankTransactionDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void saveTransaction(BankTransaction bt) {
		entityManager.persist(bt);
		
	}

}
