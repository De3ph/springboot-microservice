package com.hamit.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDto {
    private Long id;
    
    // Add other necessary fields based on your business requirements
    // For example: product information, quantity, price, etc.
    private String productName;
    private Integer quantity;
    private Double price;
}