package com.example.demo.dto;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import com.example.demo.dmo.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component

public class CartRequest {
	String userId;
	CartItem item;
}
