package com.hamit.orderservice.kafka;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.hamit.orderservice.event.OrderCreatedEvent;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@ConditionalOnProperty(name = "switch.kafka", havingValue = "true")
@RequiredArgsConstructor
@Slf4j
public class OrderEventProducer {
    
    private final KafkaTemplate<String, Object> kafkaTemplate;
    
    public void sendOrderCreatedEvent(OrderCreatedEvent event) {
        log.info("Sending order created event: {}", event);
        
        Message<OrderCreatedEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, "order-created")
                .setHeader(KafkaHeaders.KEY, event.getOrderId().toString())
                .build();
                
        kafkaTemplate.send(message);
        
        log.info("Order created event sent successfully");
    }
}