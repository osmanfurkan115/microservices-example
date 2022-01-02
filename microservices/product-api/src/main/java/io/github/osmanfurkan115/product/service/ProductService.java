package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Product;
import io.github.osmanfurkan115.product.model.dto.ProductDto;
import io.github.osmanfurkan115.product.model.dto.mapper.ProductMapper;
import io.github.osmanfurkan115.product.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Page<ProductDto> getAll(int page, int size) {
        final Pageable pageable = PageRequest.of(page,size, Sort.by("price").ascending());
        return productRepository.findAll(pageable).map(productMapper::productToProductDto);
    }

    public ProductDto getProductById(long id) {
        return productMapper.productToProductDto(productRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public Page<ProductDto> getProductsByName(String productName, int page, int size) {
        final Pageable pageable = PageRequest.of(page,size, Sort.by("productName").ascending());
        return productRepository.findAllByProductNameIsLike(productName, pageable)
                .orElseThrow(EntityNotFoundException::new).map(productMapper::productToProductDto);
    }

    public ProductDto saveProduct(ProductDto productDto) {
        final Product product = new Product(productDto.getId(), productDto.getProductName(),
                productDto.getImageLink(), productDto.getPrice(),
                productDto.getStockAmount(), productDto.getOwnerId(),
                productDto.getCreatedDate(), productDto.getLastModifiedDate());
        return productMapper.productToProductDto(productRepository.save(product));
    }
}
