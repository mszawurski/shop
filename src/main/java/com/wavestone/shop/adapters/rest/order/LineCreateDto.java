package com.wavestone.shop.adapters.rest.order;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LineCreateDto {
    String description;
    Integer quantity;
    Long productId;
}
