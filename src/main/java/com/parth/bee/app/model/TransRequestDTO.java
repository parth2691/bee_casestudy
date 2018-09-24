package com.parth.bee.app.model;

import java.io.Serializable;

public class TransRequestDTO implements Serializable {
	
	private String payeeName;
	
	private float amount;
	
	
	
	public TransRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransRequestDTO(String payeeName, float amount) {
		super();
		this.payeeName = payeeName;
		this.amount = amount;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	

}
