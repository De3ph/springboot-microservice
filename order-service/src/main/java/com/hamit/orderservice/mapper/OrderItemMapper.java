package com.hamit.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hamit.orderservice.dao.model.OrderItem;
import com.hamit.orderservice.dto.OrderItemDto;

@Mapper
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);
    
    @Mapping(target = "price", source = "price")
    @Mapping(target = "productName", source = "productName")
    @Mapping(target = "quantity", source = "quantity")
    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);
    
    @Mapping(target = "order", ignore = true)
    OrderItem orderItemDtoToOrderItem(OrderItemDto orderItemDto);
}