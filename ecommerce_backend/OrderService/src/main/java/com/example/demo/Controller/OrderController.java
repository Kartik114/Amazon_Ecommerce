package com.example.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.OrderService;
import com.example.demo.dto.OrderRequest;
import com.example.demo.dto.OrderResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderservice;

	@GetMapping("/")
	public String get()
	{
		return "Hi from Orders";
	}
	
	@GetMapping("/{userId}")
	public OrderResponse returnOrders(@PathVariable String userId)
	{
		return orderservice.returnOrders(userId);
	}
	
	@PostMapping("/createOrder")
	public void createOrder(@RequestBody OrderRequest orderrequest )
	{
		orderservice.createOrder(orderrequest);
	}
	
	@PutMapping("/updateOrder")
	public void updateOrder(@RequestBody OrderRequest orderrequest )
	{
		orderservice.updateOrder(orderrequest);
	}
}
