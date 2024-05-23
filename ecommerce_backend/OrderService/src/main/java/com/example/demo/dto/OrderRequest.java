package com.example.demo.dto;

import java.util.ArrayList;

import com.example.demo.dmo.OrdersList;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderRequest {
	String userId;
	OrdersList ordersList;
}
