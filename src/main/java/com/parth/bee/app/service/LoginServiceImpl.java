package com.parth.bee.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parth.bee.app.dao.LoginDAO;
import com.parth.bee.app.model.User;
import com.parth.bee.app.model.UserDTO;



@Service
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	LoginDAO loginDao;
	
	
	@Transactional
	public UserDTO findByUserName(String userName) {
		User user = loginDao.findByUserName(userName);
		UserDTO userDTO = null;
		if(user!=null) {
			userDTO = new UserDTO(user);
		}
		return userDTO;
	}

	@Transactional
	public UserDTO findByUserId(Integer userId) {
		User user = loginDao.findByUserId(userId);
		UserDTO userDTO = null;
		if(user!=null) {
			userDTO = new UserDTO(user);
		}
		return userDTO;
	}

	
	@Transactional
	public List<UserDTO> findUsers() {
		List<User> users = loginDao.findAllActiveUsers();
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		for(User obj:users) {
			userDTOs.add(new UserDTO(obj));
		}
		return userDTOs;
	}
	
	@Transactional
	public UserDTO performLogin(String userName) {
		User user = loginDao.findByUserName(userName);
		UserDTO userDTO = null;
		if(user!=null) {
			userDTO = new UserDTO(user);
		}
		return userDTO;
	}

}
