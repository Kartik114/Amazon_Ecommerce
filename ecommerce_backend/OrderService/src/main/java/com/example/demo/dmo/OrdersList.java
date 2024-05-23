package com.example.demo.dmo;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrdersList {
	String orderId;
	String datePlaced;
	ArrayList<OrderDetails> orderDetails;
}
