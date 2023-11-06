package com.hamit.orderservice.service;

import com.hamit.orderservice.dao.model.Order;
import com.hamit.orderservice.dao.repository.OrderRepository;
import com.hamit.orderservice.service.intf.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    public OrderServiceImpl(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;
    }
    public String getBookName() {
        return "Spring Boot Microservices";
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
