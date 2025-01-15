package com.wavestone.shop.mapper;

import com.wavestone.shop.adapters.rest.order.LineCreateDto;
import com.wavestone.shop.domain.Line;
import com.wavestone.shop.domain.ProductRepository;
import com.wavestone.shop.dto.LineDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = ProductRepository.class, unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class LineMapper {

    @Autowired
    protected ProductRepository productRepository;

    @Mapping(target = "product", expression = "java(productRepository.findById(from.getProductId()).orElseThrow())")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "order", ignore = true)
    public abstract Line toEntity(LineCreateDto from);

    @Mapping(target = "productName", source = "line.product.name")
    public abstract LineDto toDto(Line line);
}
