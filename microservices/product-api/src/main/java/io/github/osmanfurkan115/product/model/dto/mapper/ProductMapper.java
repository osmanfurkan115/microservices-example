package io.github.osmanfurkan115.product.model.dto.mapper;

import io.github.osmanfurkan115.product.model.Category;
import io.github.osmanfurkan115.product.model.Product;
import io.github.osmanfurkan115.product.model.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto productToProductDto(Product product) {
        final Category category = product.getCategory();
        final String categoryName = category != null ? category.getCategoryName() : "Category not found";
        return new ProductDto(product.getId(), product.getProductName(),
                categoryName, product.getImageLink(), product.getPrice(),
                product.getStockAmount(), product.getOwnerId(),
                product.getCreatedDate(), product.getLastModifiedDate());
    }
}
