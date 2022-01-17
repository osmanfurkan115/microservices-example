package io.github.osmanfurkan115.product.repository;

import io.github.osmanfurkan115.product.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("select r from Review r where r.product.id = ?1 and r.active = true")
    Optional<List<Review>> findByProductId(long productId);

    Optional<List<Review>> findByActiveFalse();

}
