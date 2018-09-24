package com.parth.bee.app.service;

import java.util.List;

import com.parth.bee.app.model.PayeeDTO;

public interface PayeeService {
	
	public List<PayeeDTO> findAllPayees(Integer userId);
	
	public boolean checkPayeeExists(Integer userId,Integer payeeId);
	
	public String savePayee(Integer userId,String payeeUserName);

	String deletePayee(Integer userId,String payeeUserName);

}
