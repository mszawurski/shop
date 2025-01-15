package com.wavestone.shop.service.order;

import com.wavestone.shop.domain.Order;
import com.wavestone.shop.domain.OrderRepository;
import com.wavestone.shop.dto.OrderDto;
import com.wavestone.shop.mapper.OrderMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManageOrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public Long storeOrder(OrderDto order) {
        Order entity = Optional.ofNullable(order.id())
                .map(id -> orderRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Order not found")))
                .orElseGet(Order::new);

        orderMapper.toEntity(entity, order);
        orderRepository.save(entity);

        log.info("Saved order {}", entity.getId());
        return entity.getId();
    }

}