package com.hamit.orderservice.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.hamit.orderservice.dao.model.Order;
import com.hamit.orderservice.dto.OrderDto;
import com.hamit.orderservice.event.OrderCreatedEvent;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    uses = {OrderItemMapper.class, AddressMapper.class}
)
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto orderToOrderDto(Order order);
    
    Order orderDtoToOrder(OrderDto orderDto);
    
    /**
     * Maps an Order entity to OrderCreatedEvent
     * @param order the order entity to map from
     * @param customerName the customer name to include in the event
     * @return the resulting OrderCreatedEvent
     */
    @Mapping(target = "orderId", expression = "java(generateOrderUUID(order))")
    @Mapping(target = "customerName", source = "customerName")
    @Mapping(target = "totalAmount", ignore = true)  // Implement custom mapping logic in implementation if needed
    @Mapping(target = "createdAt", source = "order.createdAt")
    OrderCreatedEvent orderToOrderCreatedEvent(Order order, String customerName);
    
    /**
     * Updates an existing Order entity from an OrderDto
     * @param orderDto the source DTO with updated values
     * @param order the target entity to update
     * @return the updated Order entity
     */
    Order updateOrderFromDto(OrderDto orderDto, @MappingTarget Order order);
    
    /**
     * Helper method to generate a UUID from an Order
     */
    default UUID generateOrderUUID(Order order) {
        if (order == null || order.getId() == null) {
            return UUID.randomUUID();
        }
        return UUID.nameUUIDFromBytes(order.getId().toString().getBytes());
    }
}
