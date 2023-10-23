package com.hamit.orderservice.mapper;

import com.hamit.orderservice.dto.OrderDto;
import com.hamit.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDto orderToOrderDto(Order order);
    Order orderDtoToOrder(OrderDto orderDto);
}
