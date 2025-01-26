package com.hamit.orderservice.dto;

import com.hamit.orderservice.dao.model.Address;
import com.hamit.orderservice.dao.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private List<OrderItem> orderItems;
    private Address address;
}
