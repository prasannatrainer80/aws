package com.example.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

@RestController
@RequestMapping(value="/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping(value="/showVendor")
	public List<Vendor> showVendor() {
		return vendorService.showVendor();
	}
	
	@GetMapping(value="/vendorLogin/{user}/{pwd}")
	public String login(@PathVariable String user,@PathVariable String pwd) {
		return vendorService.authenticate(user, pwd);
	}
	
	@GetMapping(value="/searchByVendorUserName/{user}")
	public ResponseEntity<Vendor> getByUser(@PathVariable String user) {
		try {
		Vendor vendor = vendorService.seachByUserName(user);
		return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/searchVendor/{id}")
	public ResponseEntity<Vendor> get(@PathVariable int id) {
		try {
		Vendor vendor = vendorService.search(id);
		return new ResponseEntity<Vendor>(vendor,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		}
	}
}
