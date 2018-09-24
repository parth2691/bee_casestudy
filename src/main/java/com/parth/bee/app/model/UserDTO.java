package com.parth.bee.app.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2748059160441592563L;
	
	
	private int userId;
	
	
	private String username;
	
	
	private String password;
	
	
	private String message;
	
	
	private boolean status;


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public UserDTO(int userId, String username, String password, boolean status) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.status = status;
	}


	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(User us) {
		super();
		this.userId = us.getUserId();
		this.username = us.getUsername();
		this.password = us.getPassword();
		this.status = us.getStatus();
		
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
