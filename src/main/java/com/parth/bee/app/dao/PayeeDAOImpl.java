package com.parth.bee.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.parth.bee.app.model.Payee;

@Repository
public class PayeeDAOImpl implements PayeeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Payee> findAllPayees(Integer userId) {
		Query query = entityManager.createQuery("from Payee py where py.userId.userId=:userId").setParameter("userId",
				userId);
		List<Payee> list = query.getResultList();
		return list;
	}

	@Override
	public boolean checkPayeeExists(Integer userId, Integer payeeId) {
		Query query = entityManager
				.createQuery("from Payee py where py.userId.userId=:userId and py.benificiaryId.userId=:benId")
				.setParameter("userId", userId).setParameter("benId", payeeId);
		List<Payee> list = query.getResultList();
		if(list==null) {
			return false;
		} else if(list.size()==0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void deletePayee(Payee pay) {
		entityManager.remove(pay);
	}

	@Override
	public void savePayee(Payee pay) {
		entityManager.persist(pay);

	}

	@Override
	public Payee findPayee(Integer userId, Integer payeeId) {
		Query query = entityManager
				.createQuery("from Payee py where py.userId.userId=:userId and py.benificiaryId.userId=:benId")
				.setParameter("userId", userId).setParameter("benId", payeeId);
		Payee pay = (Payee) query.getSingleResult();
		return pay;
	}

}
