package com.wavestone.shop.mapper;

import com.wavestone.shop.domain.Order;
import com.wavestone.shop.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order from);

    List<OrderDto> toDtoList(List<Order> from);

    Order toEntity(@MappingTarget Order entity, OrderDto from);

}
