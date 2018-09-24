package com.parth.bee.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parth.bee.app.model.PayeeDTO;
import com.parth.bee.app.service.PayeeService;

@RestController
public class PayeeController {

	@Autowired
	PayeeService payeeService;
	
	@RequestMapping("/getPayees")
	public ResponseEntity<List<PayeeDTO>> customerInformation(HttpSession session) {
		Integer userId = (Integer) session.getAttribute("id");
		List<PayeeDTO> payees = null;
		if(userId==null) {
			payees = new ArrayList<>();
		} else {
			payees = payeeService.findAllPayees(userId);
		}
		ResponseEntity<List<PayeeDTO>> op = new ResponseEntity<List<PayeeDTO>>(payees, HttpStatus.OK);
		return op;
	}
	
	@GetMapping("/savePayee/{username}")
	public ResponseEntity<String> savePayee(@PathVariable("username") String username,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("id");
		String result = null;
		if(userId==null) {
			result = "Please login";
		} else {
			result = payeeService.savePayee(userId, username);
		}
		ResponseEntity<String> op = new ResponseEntity<String>(result, HttpStatus.OK);
		return op;
	}
	
	@GetMapping("/deletePayee/{username}")
	public ResponseEntity<String> deletePayee(@PathVariable("username") String username,HttpSession session) {
		Integer userId = (Integer) session.getAttribute("id");
		String result = null;
		if(userId==null) {
			result = "Please login";
		} else {
			result = payeeService.deletePayee(userId, username);
		}
		ResponseEntity<String> op = new ResponseEntity<String>(result, HttpStatus.OK);
		return op;
	}
	
}
