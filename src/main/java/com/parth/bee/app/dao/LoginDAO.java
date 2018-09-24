package com.parth.bee.app.dao;

import java.util.List;

import com.parth.bee.app.model.User;

public interface LoginDAO {
	
	public User findByUserName(String userName);
	
	public User findByUserId(Integer userId);
	
	public List<User> findAllActiveUsers();

}
