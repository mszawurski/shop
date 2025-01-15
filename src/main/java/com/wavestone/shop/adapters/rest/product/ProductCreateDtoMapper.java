package com.wavestone.shop.adapters.rest.product;

import com.wavestone.shop.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductCreateDtoMapper {

	ProductDto toProductDto(ProductCreateDto from);

}
