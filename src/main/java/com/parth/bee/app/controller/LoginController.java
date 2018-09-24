package com.parth.bee.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parth.bee.app.model.UserDTO;
import com.parth.bee.app.service.LoginService;

@RestController
@EnableAutoConfiguration
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/check")
	public void getOrignalUrl() {
		System.out.println("check Url");
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,consumes="application/json")
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto,HttpSession session) {
		UserDTO user = null;
		try {
			user = loginService.findByUserName(userDto.getUsername());
			if(user==null) {
				user = new UserDTO();
				user.setMessage("User does not exists");
			} else {
				if(userDto.getPassword().equals(user.getPassword())) {
					session.setAttribute("id", user.getUserId());
					user.setMessage("User Logged In successfully");
				} else {
					user.setMessage("Password is incorrect");
				}
			}
		} catch(Exception e) {
			user = new UserDTO();
			user.setMessage("Some Error occured at the server");
			e.printStackTrace();
		}
		ResponseEntity<UserDTO> op = new ResponseEntity<UserDTO>(user, HttpStatus.OK);
		return op;
		
	}
	
	
	@RequestMapping("/")
	public void test() {
		System.out.println("check Url");
	}
	
	@RequestMapping("/logout")
	public void logout(HttpSession session) {
		System.out.println("Inside logout");
		session.invalidate();
		session = null;
	}
	
	
	
	@RequestMapping("/checkSession")
	public void testSession(HttpSession session) {
		System.out.println("check session:-"+session.getAttribute("id"));
	}
	
	@RequestMapping("/getUsers")
	public ResponseEntity<List<UserDTO>> customerInformation(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("id");
		List<UserDTO> users = null;
		if(userId==null) {
			users = new ArrayList<>();
		} else {
			users = loginService.findUsers();
		}
		ResponseEntity<List<UserDTO>> op = new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
		return op;
	}
	
	
	
	
	

}
