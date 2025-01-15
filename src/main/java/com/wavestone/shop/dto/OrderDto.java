package com.wavestone.shop.dto;

import com.wavestone.shop.domain.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(Long id, LocalDateTime orderDate, OrderStatus status,
                       String customerEmail, List<LineDto> lines) {
}
