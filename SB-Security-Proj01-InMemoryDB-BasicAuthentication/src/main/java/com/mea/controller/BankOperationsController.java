package com.mea.controller;

import java.io.RandomAccessFile;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/balance")
	public String showBalancePage(Map<String, Object> map) {
		int amount=new Random().nextInt(10000);
		map.put("amount", amount);
		return "show_balance";
	}
	
	
	@GetMapping("/offers")
	public String showOffers() {
		return "offers";
	}
	
	@GetMapping("/loanApprove")
	public String approveLoan(Map<String, Object> map) {
		int amount=new Random().nextInt(10000);
		map.put("amount", amount);
		return "loanApprove";
	}
	
	@GetMapping("/denied")
	public String showAccessDeniedPage() {
		return "auth_failed";
	}
}
