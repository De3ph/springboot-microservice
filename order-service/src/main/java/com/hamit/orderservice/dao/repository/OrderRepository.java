package com.hamit.orderservice.dao.repository;

import com.hamit.orderservice.dao.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
