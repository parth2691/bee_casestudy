package com.parth.bee.app.model;

import java.io.Serializable;

public class LoginDTO implements Serializable {

	public LoginDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	private String username;
	
	
	private String password;


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
	
	
}
