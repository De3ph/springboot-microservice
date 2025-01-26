package com.hamit.bookservice.service.external.order.intf;

import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<String> getOrders();
}
