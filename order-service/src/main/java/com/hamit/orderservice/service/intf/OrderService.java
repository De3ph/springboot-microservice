package com.hamit.orderservice.service.intf;

import com.hamit.orderservice.dao.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
}
