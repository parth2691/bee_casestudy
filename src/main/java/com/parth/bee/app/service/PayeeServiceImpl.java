package com.parth.bee.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parth.bee.app.dao.LoginDAO;
import com.parth.bee.app.dao.PayeeDAO;
import com.parth.bee.app.model.Payee;
import com.parth.bee.app.model.PayeeDTO;
import com.parth.bee.app.model.User;


@Service
public class PayeeServiceImpl implements PayeeService {

	
	@Autowired
	PayeeDAO payeeDao;
	
	@Autowired
	LoginDAO loginDao;
	
	@Override
	@Transactional
	public List<PayeeDTO> findAllPayees(Integer userId) {
		List<PayeeDTO> payees = new ArrayList<>();
		List<Payee> payeList  = payeeDao.findAllPayees(userId);
		for(Payee obj:payeList) {
			payees.add(new PayeeDTO(obj));
		}
		return payees;
	}

	@Override
	@Transactional
	public boolean checkPayeeExists(Integer userId, Integer payeeId) {
		return payeeDao.checkPayeeExists(userId, payeeId);
	}

	@Override
	@Transactional
	public String savePayee(Integer userId, String payeeUserName) {
		User payee = loginDao.findByUserName(payeeUserName);
		if(payee!=null) {
			if(payeeDao.checkPayeeExists(userId, payee.getUserId())) {
				return "Payee exists";
			} else {
				User user = loginDao.findByUserId(userId);
				Payee newPayee = new Payee();
				newPayee.setBenificiaryId(payee);
				newPayee.setUserId(user);
				payeeDao.savePayee(newPayee);
				return "Payee Added";
			}
		} else {
			return "User does not exists";
		}
	}

	@Override
	@Transactional
	public String deletePayee(Integer userId, String payeeUserName) {
		User payee = loginDao.findByUserName(payeeUserName);
		if(payee!=null) {
			if(!payeeDao.checkPayeeExists(userId, payee.getUserId())) {
				return "Payee does not exists";
			} else {
				Payee delPayee = payeeDao.findPayee(userId, payee.getUserId());
				payeeDao.deletePayee(delPayee);
				return "Payee Deleted";
			}
		} else {
			return "User does not exists";
		}
		
	}

	

}
