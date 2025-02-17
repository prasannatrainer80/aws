package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Wallet;
import com.example.demo.repo.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Wallet searchByWalletId(int walId) {
		return walletRepository.findById(walId).get();
	}
	
	public List<Wallet> showByCustomerId(int cusId) {
		return walletRepository.findByCusId(cusId);
	}
	
	public Wallet searchByCustomerIdAndWalletSource(int cusId,String walSource) {
		return walletRepository.findByCusIdAndWalSource(cusId, walSource);
	}
	
	public String updateWallet(int custId, String walType, double walAmount) {
		String cmd = "Update Wallet set WAL_AMOUNT=WAL_AMOUNT-? "
				+ " WHERE CUS_ID=? AND WAL_SOURCE=?";
		jdbcTemplate.update(cmd, new Object[] {walAmount,custId,walType});
		return "Amount Debited from Wallet...";
	}
}
