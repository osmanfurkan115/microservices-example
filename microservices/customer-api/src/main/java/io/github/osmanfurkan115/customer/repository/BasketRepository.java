package io.github.osmanfurkan115.customer.repository;

import io.github.osmanfurkan115.customer.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Integer> {
    Basket findByCustomerId(long customerId);
}
