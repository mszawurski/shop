package com.wavestone.shop.dto;

import com.wavestone.shop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindOrderDto {
    OrderStatus orderStatus;
    Long orderId;
    String customerEmail;
    String productName;
}
