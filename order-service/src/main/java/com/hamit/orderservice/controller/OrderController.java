package com.hamit.orderservice.controller;

import com.hamit.orderservice.dto.response.ResponseGetAllOrders;
import com.hamit.orderservice.mapper.OrderMapper;
import com.hamit.orderservice.service.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController implements IOrderController {

    private final OrderServiceImpl orderService;

    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/book")
    public ResponseEntity<ResponseGetAllOrders> getOrders() {
        ResponseGetAllOrders body = new ResponseGetAllOrders();
        body.setDtos(orderService.getOrders().stream().map(OrderMapper.INSTANCE::orderToOrderDto).toList());
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
