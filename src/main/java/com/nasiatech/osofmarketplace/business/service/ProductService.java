package com.nasiatech.osofmarketplace.business.service;

import com.nasiatech.osofmarketplace.api.dto.ProductDto;
import com.nasiatech.osofmarketplace.api.dto.ProductDto;
import com.nasiatech.osofmarketplace.business.mapper.ProductMapper;
import com.nasiatech.osofmarketplace.data.entity.Product;
import com.nasiatech.osofmarketplace.data.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream().map(productMapper::productToProductDto).toList();
    }

    public ProductDto getById(Integer id) {
        return productMapper.productToProductDto(getEntityById(id));
    }

    public Product getEntityById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
}
