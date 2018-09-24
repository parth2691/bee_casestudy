package com.parth.bee.app.model;

import java.io.Serializable;

import javax.persistence.Column;

public class AccountDetailsDTO implements Serializable {

	private String holderName;
		
	private float balance;

	private String accountNumber;
	
	private String message;
	
	public AccountDetailsDTO(Account acc) {
		super();
		this.holderName = acc.getHolderName();
		this.balance = acc.getBalance();
		this.accountNumber = acc.getAccountNumber();
	}

	public AccountDetailsDTO(String holderName, float balance, String accountNumber, String message) {
		super();
		this.holderName = holderName;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.message = message;
	}

	public AccountDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
