package com.hamit.orderservice.service.intf;

import com.hamit.orderservice.dao.model.Order;
import com.hamit.orderservice.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getOrders();
}
