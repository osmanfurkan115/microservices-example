package io.github.osmanfurkan115.product.api;

import io.github.osmanfurkan115.product.model.Category;
import io.github.osmanfurkan115.product.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }


    @PostMapping
    public ResponseEntity<Category> saveProduct(@RequestBody @Valid Category category) {
        return ResponseEntity.ok(categoryService.save(category));
    }
}
