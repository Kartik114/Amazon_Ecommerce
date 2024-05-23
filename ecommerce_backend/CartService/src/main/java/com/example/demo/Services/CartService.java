package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.json.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repositories.CartRepo;
import com.example.demo.dmo.CartItem;
import com.example.demo.dto.CartRequest;
import com.example.demo.dto.CartResponse;
import com.example.demo.models.Cart;
import com.fasterxml.jackson.core.JsonParser;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CartService {
	
	@Autowired
	private CartRequest cartrequest;
	@Autowired
	private CartResponse cartresponse;
	@Autowired
	private CartRepo cartrepository;
	
	public List<CartResponse> getCartByUserId(String userId)
	{
		return cartrepository.findByUserId(userId)
				             .stream()
				             .map(cart->{
				             return CartResponse.builder()
				            		 .cts(cart.getCts())
				            		 .build();
				             }).toList();
				
	}
	
	public void createCart(CartRequest cartrequest)
	{
		Cart cart=Cart.builder()
				.userId(cartrequest.getUserId())
				.cts(new ArrayList<CartItem> ())
				.build();
		
		cart.addItem(cartrequest.getItem());
		
		cartrepository.save(cart);
				
	}
	
	public void updateCartByUserId(String userId,CartItem item)
	{
		Cart cart=(cartrepository.findByUserId(userId)).get(0);
		ArrayList<CartItem> items=cart.getCts();
		Iterator<CartItem> iterator=items.iterator();
		while(iterator.hasNext())
		{
			
			CartItem item1=iterator.next();
			
			if(item1.getProductId().equals(item.getProductId()))
			{
				System.out.println("before the remove line");
				item1.setQuantity(item1.getQuantity()+item.getQuantity());
				cartrepository.save(cart);
				return;
			}
		}
		
		cart.addItem(item);
		
		cartrepository.save(cart);
		
	}
	
	public void deleteItem(String userId,String productId)
	{
		 System.out.println("___________________________function working");
		Cart cart=(cartrepository.findByUserId(userId)).get(0);
		ArrayList<CartItem> items=cart.getCts();
		Iterator<CartItem> iterator=items.iterator();
		while(iterator.hasNext())
		{
			
			CartItem item=iterator.next();
			System.out.println("product id is "+ item.getProductId()+" while param is " + productId);
			if(item.getProductId().equals(productId))
			{
				System.out.println("before the remove line");
				iterator.remove();
			}
		}
		cartrepository.save(cart);
	}
	public void deleteCart(String userId)
	{
		System.out.println("Running inside deletecart");
		cartrepository.deleteByUserId(userId);
	}

}
