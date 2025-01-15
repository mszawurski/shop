package com.wavestone.shop.service.order;

import com.wavestone.shop.domain.Order;
import com.wavestone.shop.domain.OrderRepository;
import com.wavestone.shop.dto.OrderDto;
import com.wavestone.shop.mapper.OrderMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindOrderService {

	private final OrderRepository orderRepository;
	private final OrderMapper orderMapper;

	@Transactional(readOnly = true)
	public List<OrderDto> findAllOrders() {
		List<Order> orders = orderRepository.findAll();
		return orderMapper.toDtoList(orders);
	}

	@Transactional(readOnly = true)
	public OrderDto getOrderById(Long id) {
		Order order = orderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Order not found"));
		return orderMapper.toDto(order);
	}

}
