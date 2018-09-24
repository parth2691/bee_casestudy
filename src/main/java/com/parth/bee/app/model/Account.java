package com.parth.bee.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "accounts")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5763015414892452149L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	private int accountId;
	
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "holder_name")
	private String holderName;
	
	@Column(name = "balance")
	private float balance;
	
	
	@Column(name = "account_number")
	private String accountNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User userId;

	public Account(int accountId, boolean status, String holderName, float balance, String accountNumber, User userId) {
		super();
		this.accountId = accountId;
		this.status = status;
		this.holderName = holderName;
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.userId = userId;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}
