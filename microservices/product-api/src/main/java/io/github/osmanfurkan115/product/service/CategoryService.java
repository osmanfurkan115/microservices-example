package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Category;
import io.github.osmanfurkan115.product.model.dto.UpdateCategoryRequest;
import io.github.osmanfurkan115.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Category updateCategory(int id, UpdateCategoryRequest categoryRequest) {
        final Category category = getCategoryById(id);
        Optional.ofNullable(categoryRequest.getCategoryName()).ifPresent(category::setCategoryName);
        Optional.ofNullable(categoryRequest.getDescription()).ifPresent(category::setDescription);
        return categoryRepository.save(category);
    }
}
