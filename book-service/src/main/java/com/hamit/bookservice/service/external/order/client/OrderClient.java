package com.hamit.bookservice.service.external.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-service", url = "http://localhost:8081/order-service")
public interface OrderClient {
    @GetMapping("orders/book")
    public ResponseEntity<String> getOrders();
}
