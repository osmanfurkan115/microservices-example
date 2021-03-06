package io.github.osmanfurkan115.product.model.dto

import java.io.Serializable
import java.math.BigDecimal
import javax.validation.constraints.NotNull

class CreateProductRequest(
    @NotNull val id: Long,
    productName: String,
    categoryId: Int,
    imageLink: String,
    price: BigDecimal = BigDecimal.ZERO,
    stockAmount: Int,
    ownerId: Long,
) : Serializable, ProductRequest(productName, categoryId, imageLink, price, stockAmount, ownerId)