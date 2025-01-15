package com.wavestone.shop.mapper;

import com.wavestone.shop.domain.Product;
import com.wavestone.shop.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductDto toDto(Product from);

	List<ProductDto> toDtoList(List<Product> from);

	Product toEntity(@MappingTarget Product entity, ProductDto from);

}
