package io.github.osmanfurkan115.customer.service;

import io.github.osmanfurkan115.customer.model.Basket;
import io.github.osmanfurkan115.customer.model.BasketItem;
import io.github.osmanfurkan115.customer.repository.BasketItemRepository;
import io.github.osmanfurkan115.customer.repository.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;

    public BasketService(BasketRepository basketRepository, BasketItemRepository basketItemRepository) {
        this.basketRepository = basketRepository;
        this.basketItemRepository = basketItemRepository;
    }

    public Basket addProduct(long customerId, long productId, int quantity) {
        final Basket basket = getBasketByCustomerId(customerId);
        final BasketItem basketItem = basketItemRepository.save(new BasketItem(null, productId, quantity, basket));
        basket.getBasketItems().add(basketItem);
        return basketRepository.save(basket);
    }

    public Basket getBasketByCustomerId(long customerId) {
        return basketRepository.findByCustomerId(customerId);
    }
}