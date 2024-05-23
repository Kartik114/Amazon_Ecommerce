package com.example.demo.dto;

import java.util.ArrayList;


import com.example.demo.dmo.OrdersList;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderResponse {
	ArrayList<OrdersList> ordersList;

}
