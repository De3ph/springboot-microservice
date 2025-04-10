package com.hamit.orderservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hamit.orderservice.dao.model.Address;
import com.hamit.orderservice.dto.AddressDto;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    
    AddressDto addressToAddressDto(Address address);
    Address addressDtoToAddress(AddressDto addressDto);
}