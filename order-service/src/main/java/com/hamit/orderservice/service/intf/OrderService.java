package com.hamit.orderservice.service.intf;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hamit.orderservice.dto.OrderDto;

public interface OrderService {
    Page<OrderDto> getOrders(Pageable pageable);
    Optional<OrderDto> getOrderById(Long id);
    OrderDto createOrder(OrderDto orderDto);
    OrderDto updateOrder(Long id, OrderDto orderDto);
    void deleteOrder(Long id);
}
