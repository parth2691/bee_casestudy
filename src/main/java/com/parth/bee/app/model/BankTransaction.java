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
@Table(name = "transactions")
public class BankTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2660681194780505954L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trans_id")
	private int transId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user1_id")
	private User payerId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user2_id")
	private User recieverId;
	
	
	@Column(name = "amount")
	private float amount;
	
	
	@Column(name = "type")
	private String type;


	public BankTransaction(int transId, User payerId, User recieverId, float amount, String type) {
		super();
		this.transId = transId;
		this.payerId = payerId;
		this.recieverId = recieverId;
		this.amount = amount;
		this.type = type;
	}


	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getTransId() {
		return transId;
	}


	public void setTransId(int transId) {
		this.transId = transId;
	}


	public User getPayerId() {
		return payerId;
	}


	public void setPayerId(User payerId) {
		this.payerId = payerId;
	}


	public User getRecieverId() {
		return recieverId;
	}


	public void setRecieverId(User recieverId) {
		this.recieverId = recieverId;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}

}
