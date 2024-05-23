package com.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import dmo.Ratings;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ProductResponse {
    private String id;
    private String name;
//    private String description;
    private int price;
    private int quantity;
    private String imageUrl;
    private Ratings ratings;
}
