package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Wallet;
import com.example.demo.service.WalletService;

@RestController
@RequestMapping(value="/wallet")
@CrossOrigin(origins = "http://localhost:3000")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@GetMapping(value="/searchByWalletId/{id}")
	public Wallet searchByWalletId(@PathVariable int id) {
		return walletService.searchByWalletId(id);
	}
	
	@GetMapping(value="/searchByCustomerId/{id}")
	public List<Wallet> searchByCustId(@PathVariable int id) {
		return walletService.showByCustomerId(id);
	}
	
	@GetMapping(value="/showWalletInfo/{id}/{type}")
	public Wallet showInfo(@PathVariable int id, @PathVariable String type) {
		return walletService.searchByCustomerIdAndWalletSource(id, type);
	}
}
