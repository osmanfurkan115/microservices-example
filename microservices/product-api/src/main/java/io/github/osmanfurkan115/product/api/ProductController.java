package io.github.osmanfurkan115.product.api;

import io.github.osmanfurkan115.product.model.dto.CreateProductRequest;
import io.github.osmanfurkan115.product.model.dto.ProductDto;
import io.github.osmanfurkan115.product.model.dto.ReviewRequest;
import io.github.osmanfurkan115.product.model.dto.UpdateProductRequest;
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

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<Page<ProductDto>> getProductByCategory(@PathVariable int categoryId, @RequestParam int page,
                                                             @RequestParam int size) {
        return ResponseEntity.ok(productService.getProductsByCategoryId(categoryId, page, size));
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody @Valid CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productService.saveProduct(createProductRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id, @RequestBody UpdateProductRequest productRequest) {
        return ResponseEntity.ok(productService.updateProduct(id, productRequest));
    }

    @PutMapping("/{id}/review")
    public ResponseEntity<ProductDto> addReview(@PathVariable long id, @RequestBody @Valid ReviewRequest review) {
        return ResponseEntity.ok(productService.addReview(id, review));
    }
}
