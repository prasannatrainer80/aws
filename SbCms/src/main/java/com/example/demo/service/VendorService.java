package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Vendor;
import com.example.demo.repo.VendorRepository;

@Service
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;
	
	public String authenticate(String user,String pwd) {
		long count = vendorRepository.countByVenUsernameAndVenPassword(user, pwd);
		String res="";
		res+=count;
		return res;
	}
	
	public Vendor search(int venId) {
		return vendorRepository.findById(venId).get();
	}
	public List<Vendor> showVendor() {
		return vendorRepository.findAll();
	}
	
	public Vendor seachByUserName(String userName) {
		return vendorRepository.findByVenUsername(userName);
	}

}
