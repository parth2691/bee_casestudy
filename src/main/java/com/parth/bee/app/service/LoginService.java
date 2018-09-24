package com.parth.bee.app.service;

import java.util.List;

import com.parth.bee.app.model.UserDTO;

public interface LoginService {

	
	public UserDTO findByUserName(String userName);
	
	public UserDTO findByUserId(Integer userId);
	
	public UserDTO performLogin(String userName);
	
	public List<UserDTO> findUsers();
	
	
}
