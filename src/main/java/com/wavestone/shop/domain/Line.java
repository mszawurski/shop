package com.wavestone.shop.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="order_line")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	@Column(nullable = false)
	private Integer quantity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Product product;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Order order;

}
