package com.wavestone.shop.adapters.rest.order;

import com.wavestone.shop.domain.Line;
import com.wavestone.shop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderCreateDto {
	private String name;
	private String description;
	private OrderStatus status;
	private Long customerId;
	List<LineCreateDto> lines;
}
