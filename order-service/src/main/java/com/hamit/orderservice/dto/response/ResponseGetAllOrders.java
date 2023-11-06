package com.hamit.orderservice.dto.response;

import com.hamit.orderservice.dto.OrderDto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseGetAllOrders {
    List<OrderDto> dtos;
}
