package com.parth.bee.app.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parth.bee.app.model.AccountDetailsDTO;
import com.parth.bee.app.model.TransRequestDTO;
import com.parth.bee.app.model.UserDTO;
import com.parth.bee.app.service.AccountService;
import com.parth.bee.app.service.BankTransactionService;

@RestController
public class BankTransactionController {

	@Autowired
	AccountService accountService;
	
	@Autowired
	BankTransactionService bankTranService;

	@RequestMapping("/getAccountDetails")
	public ResponseEntity<AccountDetailsDTO> getAccountDetails(HttpSession session) {
		AccountDetailsDTO acc = null;
		try {
			Integer userId = (Integer) session.getAttribute("id");
			if (userId == null) {
				acc = new AccountDetailsDTO();
				acc.setMessage("Session Expired please login");
			} else {
				acc = accountService.findByUserId(userId);
			}
		} catch (Exception e) {
			acc = new AccountDetailsDTO();
			acc.setMessage("Some Error occured at the server");
			e.printStackTrace();
		}
		ResponseEntity<AccountDetailsDTO> op = new ResponseEntity<AccountDetailsDTO>(acc, HttpStatus.OK);
		return op;
	}

	@GetMapping("/calculateBalance/{date}")
	public ResponseEntity<AccountDetailsDTO> calculateBalance(@PathVariable("date") String date, HttpSession session) {
		AccountDetailsDTO acc = null;
		try {
			Integer userId = (Integer) session.getAttribute("id");
			if (userId == null) {
				acc = new AccountDetailsDTO();
				acc.setMessage("Session Expired please login");
			} else {
				acc = accountService.findByUserId(userId);
				try {
					LocalDate currentDate = LocalDate.now();
					LocalDate dateFu = LocalDate.parse(date);
					long days = currentDate.until(dateFu, ChronoUnit.DAYS);
					if(days>0) {
						acc.setBalance(calFutureBalance(days, acc.getBalance()));
						acc.setMessage("Balance updated");
					} else {
						acc.setMessage("Please enter appropriate date in yyyy-MM-dd format");
					}
				} catch(Exception e) {
					acc.setMessage("Please enter appropriate date in yyyy-MM-dd format");
					e.printStackTrace();
				}
				
			}
		} catch (Exception e) {
			acc = new AccountDetailsDTO();
			acc.setMessage("Some Error occured at the server");
			e.printStackTrace();
		}
		ResponseEntity<AccountDetailsDTO> op = new ResponseEntity<AccountDetailsDTO>(acc, HttpStatus.OK);
		return op;
	}

	private float calFutureBalance(long days, float currentBal) {
		
		currentBal = currentBal + (currentBal * 4 * days) / (100 * 365);
		return currentBal;
	}

	@RequestMapping(value = "/transcat", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AccountDetailsDTO> transcat(@RequestBody TransRequestDTO transDto, HttpSession session) {
		AccountDetailsDTO acc = null;
		try {
			Integer userId = (Integer) session.getAttribute("id");
			if (userId == null) {
				acc = new AccountDetailsDTO();
				acc.setMessage("Session Expired please login");
			} else {
				acc = bankTranService.transact(userId, transDto.getPayeeName(), transDto.getAmount());
			}
		} catch (Exception e) {
			acc = new AccountDetailsDTO();
			acc.setMessage("Some Error occured at the server");
			e.printStackTrace();
		}
		ResponseEntity<AccountDetailsDTO> op = new ResponseEntity<AccountDetailsDTO>(acc, HttpStatus.OK);
		return op;
	}
}
