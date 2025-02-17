package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> showCustomer() {
		return customerRepository.findAll();
	}
	
	public String login(String cusUserName, String cusPassword) {
		long count= customerRepository.countByCusUserNameAndCusPassword(cusUserName, cusPassword);
		String res ="";
		res+=count;
		return res;
	}
	
	public Customer seachByUserName(String userName) {
		return customerRepository.findByCusUserName(userName);
	}
	public Customer searchById(int id) {
		return customerRepository.findById(id).get();
	}
}
