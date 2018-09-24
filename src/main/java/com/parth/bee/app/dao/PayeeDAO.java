package com.parth.bee.app.dao;

import java.util.List;

import com.parth.bee.app.model.Payee;

public interface PayeeDAO {
	
	
	public List<Payee> findAllPayees(Integer userId);
	
	public boolean checkPayeeExists(Integer userId,Integer payeeId);
	
	public Payee findPayee(Integer userId,Integer payeeId);
	
	public void savePayee(Payee pay);

	void deletePayee(Payee pay);
	

}
