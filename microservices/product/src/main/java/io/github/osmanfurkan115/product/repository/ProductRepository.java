package io.github.osmanfurkan115.product.repository;

import io.github.osmanfurkan115.product.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}