package com.hamit.orderservice.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.hamit.orderservice.event.OrderCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Component
@ConditionalOnProperty(name = "switch.kafka", havingValue = "true")
@Slf4j
public class OrderCreatedEventListener {

    @KafkaListener(topics = "order-created", groupId = "${kafka.group-id}")
    public void handleOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("Received order created event: {}", event);
        
        // Process the order created event
        // This could include updating a database, calling other services, etc.
        processOrderCreatedEvent(event);
    }
    
    private void processOrderCreatedEvent(OrderCreatedEvent event) {
        // Implement your business logic here
        log.info("Processing order with ID: {}, for customer: {}, with amount: {}",
                event.getOrderId(), event.getCustomerName(), event.getTotalAmount());
    }
}