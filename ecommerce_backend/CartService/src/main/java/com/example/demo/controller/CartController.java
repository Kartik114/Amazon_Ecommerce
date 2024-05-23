package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.CartService;
import com.example.demo.dmo.CartItem;
import com.example.demo.dto.CartRequest;
import com.example.demo.dto.CartResponse;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired CartService cartservice;
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CartController.class);
	
//	Testing API
	@GetMapping("/Welcome")
	public String Welcome()
	{
		return "Welcome to cart";
	}
	
//	Fetch cart by userid, defined in cart repo
	@GetMapping("/{userId}")
	public List<CartResponse> getCartByUserId(@PathVariable String userId)
	{
		return cartservice.getCartByUserId(userId);
	}
	
//	create a new cart and add a new item to it
//    @CrossOrigin(origins = "*")
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCart(@RequestBody CartRequest cartrequest )
	{
		try {
			
			System.out.print("here");
            cartservice.createCart(cartrequest);
            
            logger.info("Cart created successfully");
        } catch (Exception e) {
            logger.error("Error occurred while creating cart", e);
            throw e;
        }
	}
	
	@DeleteMapping("/delete/{userId}")
	public void deleteItem(@PathVariable String userId,@RequestBody CartItem item)
	{
		System.out.println(item);
		String tmp = item.getProductId();
		cartservice.deleteItem(userId,tmp);
	}

	@DeleteMapping("/delete/cart/{userId}")
	public void deleteCart(@PathVariable String userId)
	{
		cartservice.deleteCart(userId);
	}
	
//	add new item to existing cart found by userid
    @PutMapping("update/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCart(@PathVariable String userId, @RequestBody CartItem item) {
        // Call the service method to update the cart by user ID and add an item
        cartservice.updateCartByUserId(userId, item);
    }

}
