package com.wavestone.shop.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order_header")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	@Column(nullable = false)
	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
	private List<Line> lines;

	public void addLine(Line line) {
		if (lines == null) {
			lines = new ArrayList<>();
		}
		lines.add(line);
		line.setOrder(this);
	}

}
