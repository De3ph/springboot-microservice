package com.hamit.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hamit.orderservice.dto.OrderDto;
import com.hamit.orderservice.service.intf.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Override
    public List<OrderDto> getOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

}
