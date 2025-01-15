package com.wavestone.shop.adapters.rest.order;

import com.wavestone.shop.service.order.FindOrderService;
import com.wavestone.shop.service.order.ManageOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class OrderController {

	private final FindOrderService findOrderService;
	private final ManageOrderService manageOrderService;

//	@GetMapping(path = "/orders")
//	@ResponseStatus(HttpStatus.OK)
//	public List<OrderDto> getOrders() {
//		return findOrderService.findAllOrders();
//	}

	@PostMapping(path = "/orders")
	public ResponseEntity<Long> createOrder(@RequestBody OrderCreateDto orderCreateDto) {
		Long orderId = manageOrderService.storeOrder(orderCreateDto);

		return ResponseEntity.created(
				ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(orderId)
						.toUri()
		).body(orderId);
	}

//	@GetMapping(path = "/orders/{orderId}")
//	@ResponseStatus(HttpStatus.OK)
//	public OrderDto getOrderById(@PathVariable Long orderId) {
//		return findOrderService.getOrderById(orderId);
//	}

}
