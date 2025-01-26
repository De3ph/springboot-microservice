package com.hamit.bookservice.service.external.order;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hamit.bookservice.service.external.order.intf.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Override
    public ResponseEntity<String> getOrders() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

}