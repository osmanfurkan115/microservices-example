package io.github.osmanfurkan115.product.model.dto.mapper;

import io.github.osmanfurkan115.product.model.Product;
import io.github.osmanfurkan115.product.model.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDto productToProductDto(Product product) {
        return new ProductDto(product.getId(), product.getProductName(),
                product.getImageLink(), product.getPrice(),
                product.getStockAmount(), product.getCreatedDate(),
                product.getLastModifiedDate());
    }

    public Product productDtoToProduct(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getProductName(),
                productDto.getImageLink(), productDto.getPrice(),
                productDto.getStockAmount(), productDto.getCreatedDate(),
                productDto.getLastModifiedDate());
    }
}