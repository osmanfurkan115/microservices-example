package io.github.osmanfurkan115.product.service;

import io.github.osmanfurkan115.product.model.Category;
import io.github.osmanfurkan115.product.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
