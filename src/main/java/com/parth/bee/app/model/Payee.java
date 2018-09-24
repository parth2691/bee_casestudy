package com.parth.bee.app.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "payee")
public class Payee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5634821566297040105L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "payee_id")
	private int payeeId;
	
	
	@Column(name = "status")
	private boolean status;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
	private User userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "benificiary_id")
	private User benificiaryId;
	
	
	public Payee(int payeeId, boolean status, User userId, User benificiaryId) {
		super();
		this.payeeId = payeeId;
		this.status = status;
		this.userId = userId;
		this.benificiaryId = benificiaryId;
	}

	public Payee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPayeeId() {
		return payeeId;
	}

	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public User getBenificiaryId() {
		return benificiaryId;
	}

	public void setBenificiaryId(User benificiaryId) {
		this.benificiaryId = benificiaryId;
	}
	
}
