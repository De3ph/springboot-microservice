package com.hamit.orderservice.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService{
    public String getBookName() {
        return "Spring Boot Microservices";
    }
}
