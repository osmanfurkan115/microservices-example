package io.github.osmanfurkan115.product.api;

import io.github.osmanfurkan115.product.model.dto.ProductDto;
import io.github.osmanfurkan115.product.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getProducts(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok(productService.getAll(page,size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping("/filter/{productName}")
    public ResponseEntity<Page<ProductDto>> getProductByName(@PathVariable String productName, @RequestParam int page,
                                                             @RequestParam int size) {
        return ResponseEntity.ok(productService.getProductsByName(productName, page, size));
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }
}
