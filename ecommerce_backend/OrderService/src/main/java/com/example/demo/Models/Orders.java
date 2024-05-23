package com.example.demo.Models;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import com.example.demo.dmo.OrderDetails;
import com.example.demo.dmo.OrdersList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document("orders")
public class Orders {
	String userId;
	ArrayList<OrdersList> ordersList;
	


}
