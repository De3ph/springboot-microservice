package com.hamit.orderservice.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hamit.orderservice.dao.model.Order;
import com.hamit.orderservice.dao.repository.OrderRepository;
import com.hamit.orderservice.dto.OrderDto;
import com.hamit.orderservice.mapper.OrderMapper;
import com.hamit.orderservice.service.intf.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;
    
    @Override
    @Transactional(readOnly = true)
    public Page<OrderDto> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable)
                .map(orderMapper::orderToOrderDto);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<OrderDto> getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::orderToOrderDto);
    }
    
    @Override
    @Transactional
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.orderDtoToOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.orderToOrderDto(savedOrder);
    }
    
    @Override
    @Transactional
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    Order updatedOrder = orderMapper.orderDtoToOrder(orderDto);
                    updatedOrder.setId(id);
                    return orderRepository.save(updatedOrder);
                })
                .map(orderMapper::orderToOrderDto)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
    
    @Override
    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
