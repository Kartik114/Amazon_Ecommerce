package com.example.demo.models;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.example.demo.dmo.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("carts")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Component
public class Cart {
	
	@Id
	private ObjectId cartId;
	private String userId;
	private ArrayList <CartItem> cts;
	

	
	public void addItem(CartItem item)
	{
		this.cts.add(item);
	}

}

