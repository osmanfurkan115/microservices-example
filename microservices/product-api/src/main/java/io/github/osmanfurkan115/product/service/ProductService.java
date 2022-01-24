package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Product;
import io.github.osmanfurkan115.product.model.Review;
import io.github.osmanfurkan115.product.model.dto.*;
import io.github.osmanfurkan115.product.model.dto.mapper.ProductMapper;
import io.github.osmanfurkan115.product.model.dto.mapper.ReviewMapper;
import io.github.osmanfurkan115.product.repository.ProductRepository;
import io.github.osmanfurkan115.product.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;
    private final ProductMapper productMapper;
    private final ReviewMapper reviewMapper;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, ReviewRepository reviewRepository,
                          ProductMapper productMapper, ReviewMapper reviewMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
        this.productMapper = productMapper;
        this.reviewMapper = reviewMapper;
        this.categoryService = categoryService;
    }

    public Page<ProductDto> getAll(int page, int size) {
        final Pageable pageable = PageRequest.of(page, size, Sort.by("price").ascending());
        return productRepository.findAll(pageable).map(productMapper::productToProductDto);
    }

    public ProductDto getProductById(long id) {
        return productMapper.productToProductDto(findProductById(id));
    }

    private Product findProductById(long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Page<ProductDto> getProductsByName(String productName, int page, int size) {
        final Pageable pageable = PageRequest.of(page, size, Sort.by("productName").ascending());
        return productRepository.findAllByProductNameIsLike(productName, pageable)
                .orElseThrow(EntityNotFoundException::new).map(productMapper::productToProductDto);
    }

    public Page<ProductDto> getProductsByCategoryId(int categoryId, int page, int size) {
        final Pageable pageable = PageRequest.of(page, size, Sort.by("productName").ascending());
        return productRepository.findAllByCategoryId(categoryId, pageable)
                .orElseThrow(EntityNotFoundException::new).map(productMapper::productToProductDto);
    }

    public ProductDto saveProduct(CreateProductRequest productRequest) {
        final Product product = new Product(productRequest.getId(), productRequest.getProductName(),
                categoryService.getCategoryById(productRequest.getCategoryId()), new HashSet<>(),
                productRequest.getImageLink(), productRequest.getPrice(),
                productRequest.getStockAmount(), productRequest.getOwnerId(),
                LocalDateTime.now(), LocalDateTime.now());
        return productMapper.productToProductDto(productRepository.save(product));
    }

    public ProductDto updateProduct(long id, UpdateProductRequest productRequest) {
        final Product product = findProductById(id);

        product.setProductName(productRequest.getProductName());
        product.setImageLink(productRequest.getImageLink());
        product.setPrice(productRequest.getPrice());
        product.setStockAmount(productRequest.getStockAmount());
        product.setCategory(categoryService.getCategoryById(productRequest.getCategoryId()));
        product.setLastModifiedDate(LocalDateTime.now());
        product.setOwnerId(productRequest.getOwnerId());

        return productMapper.productToProductDto(productRepository.save(product));
    }

    public ProductDto addReview(long productId, ReviewRequest reviewRequest) {
        final Product product = findProductById(productId);
        final Review review = new Review(reviewRequest.getId(), reviewRequest.getComment(),
                reviewRequest.getRate(), reviewRequest.getCustomerId(),
                product, false,
                LocalDateTime.now()
        );
        product.getReviews().add(review);
        return productMapper.productToProductDto(productRepository.save(product));
    }

    public List<ReviewDto> getReviews(long productId) {
        final Optional<List<Review>> reviews = reviewRepository.findByProductId(productId);
        return reviews.orElseThrow(EntityNotFoundException::new)
                .stream().map(reviewMapper::reviewToReviewDto).collect(Collectors.toList());
    }
}
