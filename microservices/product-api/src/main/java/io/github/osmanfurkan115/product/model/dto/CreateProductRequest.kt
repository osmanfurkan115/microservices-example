package io.github.osmanfurkan115.product.model.dto

import org.hibernate.validator.constraints.URL
import org.jetbrains.annotations.NotNull
import java.io.Serializable
import java.math.BigDecimal

data class CreateProductRequest(
    val id: Long,
    val productName: String,
    val categoryId: Int,
    @URL val imageLink: String,
    @field:NotNull val price: BigDecimal = BigDecimal.ZERO,
    val stockAmount: Int,
    @NotNull val ownerId: Long,
) : Serializable