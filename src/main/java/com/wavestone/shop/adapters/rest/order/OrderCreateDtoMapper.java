package com.wavestone.shop.adapters.rest.order;

import com.wavestone.shop.dto.OrderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface OrderCreateDtoMapper {

	OrderDto toOrderDto(OrderCreateDto from);

}
