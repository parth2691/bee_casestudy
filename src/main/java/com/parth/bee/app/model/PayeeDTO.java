package com.parth.bee.app.model;

import java.io.Serializable;

public class PayeeDTO implements Serializable {

	private int payeeId;
	
	private String benificiary;

	public PayeeDTO(Payee payee) {
		super();
		this.payeeId = payee.getPayeeId();
		this.benificiary = payee.getBenificiaryId().getUsername();
	}
	
	public PayeeDTO(int payeeId, String benificiary) {
		super();
		this.payeeId = payeeId;
		this.benificiary = benificiary;
	}

	public PayeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}

	public String getBenificiary() {
		return benificiary;
	}

	public void setBenificiary(String benificiary) {
		this.benificiary = benificiary;
	}
	
	
	
}
