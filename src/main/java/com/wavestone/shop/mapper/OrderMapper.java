package com.wavestone.shop.mapper;

import com.wavestone.shop.adapters.rest.order.OrderCreateDto;
import com.wavestone.shop.domain.CustomerRepository;
import com.wavestone.shop.domain.Order;
import com.wavestone.shop.dto.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CustomerRepository.class,LineMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class OrderMapper {

    @Autowired
    protected CustomerRepository customerRepository;

    @Mapping(target = "customer", expression = "java(customerRepository.findById(from.getCustomerId()).orElseThrow())")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "orderDate", expression = "java(LocalDateTime.now())")
    public abstract Order toEntity(OrderCreateDto from);

    public abstract List<OrderDto> toDtoList(List<Order> orders);


    @Mapping(target = "customerEmail", source = "customer.email")
    public abstract OrderDto toDto(Order order);
}
