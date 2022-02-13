package io.github.osmanfurkan115.customer.repository;

import io.github.osmanfurkan115.customer.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
}
