package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping(value="/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/showCustomer")
	public List<Customer> showCustomer() {
		return customerService.showCustomer();
	}
	
	@GetMapping(value="/customerLogin/{user}/{pwd}")
	public String login(@PathVariable String user,@PathVariable String pwd) {
		return customerService.login(user, pwd);
	}
	
	@GetMapping(value="/searchByCustomerUserName/{user}")
	public ResponseEntity<Customer> getByUser(@PathVariable String user) {
		try {
		Customer customer = customerService.seachByUserName(user);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/searchCustomer/{id}")
	public ResponseEntity<Customer> get(@PathVariable int id) {
		try {
		Customer customer = customerService.searchById(id);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
	}
}
