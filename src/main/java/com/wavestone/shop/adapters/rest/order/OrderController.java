package com.wavestone.shop.adapters.rest.order;

import com.wavestone.shop.dto.OrderDto;
import com.wavestone.shop.service.order.FindOrderService;
import com.wavestone.shop.service.order.ManageOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class OrderController {

	private final FindOrderService findOrderService;
	private final ManageOrderService manageOrderService;
	private final OrderCreateDtoMapper orderCreateDtoMapper;

	@GetMapping(path = "/orders")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDto> getOrders() {
		return findOrderService.findAllOrders();
	}

	@PostMapping(path = "/orders")
	public ResponseEntity<Long> createOrder(@RequestBody OrderCreateDto order) {
		OrderDto orderDto = orderCreateDtoMapper.toOrderDto(order);
		Long orderId = manageOrderService.storeOrder(orderDto);

		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(orderId)
						.toUri()
		).body(orderId);
	}

	@GetMapping(path = "/orders/{orderId}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDto getOrderById(@PathVariable Long orderId) {
		return findOrderService.getOrderById(orderId);
	}

}
