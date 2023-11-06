package com.hamit.orderservice.controller;

import com.hamit.orderservice.dto.response.ResponseGetAllOrders;
import org.springframework.http.ResponseEntity;

public interface IOrderController {
    ResponseEntity<ResponseGetAllOrders> getOrders();
}
