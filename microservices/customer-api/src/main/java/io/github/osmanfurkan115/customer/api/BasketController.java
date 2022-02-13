package io.github.osmanfurkan115.customer.api;

import io.github.osmanfurkan115.customer.model.Basket;
import io.github.osmanfurkan115.customer.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/basket")
public class BasketController {
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping(path = "/{customerId}")
    public ResponseEntity<Basket> getBasketById(@PathVariable Long customerId) {
        return ResponseEntity.ok(basketService.getBasketByCustomerId(customerId));
    }


    @PostMapping("/item")
    public ResponseEntity<Basket> addProductToBasket(@RequestParam("customerId") long customerId,
                                                     @RequestParam("productId") long productId,
                                                     @RequestParam("quantity") int quantity) {
        return ResponseEntity.ok(basketService.addProduct(customerId, productId, quantity));
    }

}