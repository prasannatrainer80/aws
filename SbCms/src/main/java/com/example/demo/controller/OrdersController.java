package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Orders;
import com.example.demo.service.OrdersService;

@RestController
@RequestMapping(value="/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	
	@GetMapping(value="/searchByOrderId/{id}")
	public Orders searchByOrderId(@PathVariable int id) {
		return ordersService.searchByOrderId(id);
	}
	
	@GetMapping(value="/showCustomerPendingOrders/{custId}")
	public List<Orders> showCustomerPendingOrders(@PathVariable int custId) {
		List<Orders> result = ordersService.showCustomerOrders(custId);
		return result.stream().filter(x -> x.getOrdStatus().equals("PENDING")).toList();
	}
	
	@GetMapping(value="/showCustomerOrders/{custId}")
	public List<Orders> showCustomerOrders(@PathVariable int custId) {
		return ordersService.showCustomerOrders(custId);
	}
	
	@PostMapping(value="/placeOrder")
	public String placeOrder(@RequestBody Orders orders) {
		return ordersService.placeOrder(orders);
	}
}
