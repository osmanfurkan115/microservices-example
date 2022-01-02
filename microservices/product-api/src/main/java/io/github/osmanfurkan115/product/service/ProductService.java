package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Product;
import io.github.osmanfurkan115.product.model.dto.CreateProductRequest;
import io.github.osmanfurkan115.product.model.dto.ProductDto;
import io.github.osmanfurkan115.product.model.dto.mapper.ProductMapper;
import io.github.osmanfurkan115.product.repository.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper,
                          CategoryService categoryService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
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

    public Page<ProductDto> getProductsByCategoryId(int categoryId, int page, int size) {
        final Pageable pageable = PageRequest.of(page,size, Sort.by("productName").ascending());
        return productRepository.findAllByCategory_Id(categoryId, pageable)
                .orElseThrow(EntityNotFoundException::new).map(productMapper::productToProductDto);
    }

    public ProductDto saveProduct(CreateProductRequest productRequest) {
        final Product product = new Product(productRequest.getId(), productRequest.getProductName(),
                categoryService.getCategoryById(productRequest.getCategoryId()), productRequest.getImageLink(),
                productRequest.getPrice(), productRequest.getStockAmount(),
                productRequest.getOwnerId(), LocalDateTime.now(), LocalDateTime.now());
        return productMapper.productToProductDto(productRepository.save(product));
    }
}
