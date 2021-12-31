package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductMailServiceTest {

    private ProductMailService productMailService;


    @Autowired
    private JavaMailSender javaMailSender;


    @BeforeEach
    void setUp() {
        productMailService = new ProductMailService(javaMailSender);
    }

    @Test
    void sendProductPurchaseMail() {
        final Product product = new Product();
        product.setProductName("Test product");
        assertDoesNotThrow(() -> productMailService.sendProductPurchaseMail(product));
    }
}