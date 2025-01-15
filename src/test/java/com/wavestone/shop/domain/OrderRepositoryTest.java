package com.wavestone.shop.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import jakarta.persistence.EntityManager;

@DataJpaTest
class OrderRepositoryTest {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private EntityManager em;

	@Test
	void shouldCreateOrder() {
		// given
		Customer customer = Customer.builder()
				.email("test@email.com")
				.build();
		em.persist(customer);

		Product product = Product.builder()
				.name("test product")
				.build();
		em.persist(product);

		Order order = Order.builder()
				.customer(customer)
				.description("Test order")
				.status(OrderStatus.CREATED)
				.orderDate(LocalDateTime.of(2024, 1, 1, 0, 0))
				.build();

		Line line = Line.builder()
				.product(product)
				.quantity(10)
				.description("Test line")
				.build();

		order.addLine(line);

		// when
		orderRepository.saveAndFlush(order);

		// then
		Order actualOrder = em.createQuery("select o from Order o where o.id = :id", Order.class)
				.setParameter("id", order.getId())
				.getSingleResult();

		assertNotNull(actualOrder);
		assertNotNull(actualOrder.getCustomer());
		assertNotNull(actualOrder.getOrderLines());
		assertEquals(1, actualOrder.getOrderLines().size());
	}

}
