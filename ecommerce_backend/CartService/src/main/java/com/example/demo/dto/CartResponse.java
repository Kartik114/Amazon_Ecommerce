package com.example.demo.dto;

import java.util.ArrayList;

import com.example.demo.dmo.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component

public class CartResponse {
	private ArrayList<CartItem> cts;
}
