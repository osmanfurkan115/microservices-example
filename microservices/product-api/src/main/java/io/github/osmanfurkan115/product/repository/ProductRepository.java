package io.github.osmanfurkan115.product.repository;

import io.github.osmanfurkan115.product.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %:productName%")
    Optional<Page<Product>> findAllByProductNameIsLike(@Param("productName") String productName, Pageable pageable);

    Optional<Page<Product>> findAllByCategoryId(int categoryId, Pageable pageable);

}