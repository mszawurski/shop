package com.wavestone.shop.service.product;

import com.wavestone.shop.domain.Product;
import com.wavestone.shop.domain.ProductRepository;
import com.wavestone.shop.dto.ProductDto;
import com.wavestone.shop.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Transactional(readOnly = true)
	public List<ProductDto> findAllProducts() {
		List<Product> products = productRepository.findAll();
		return productMapper.toDtoList(products);
	}

	@Transactional(readOnly = true)
	public ProductDto getProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Product not found"));
		return productMapper.toDto(product);
	}

}
