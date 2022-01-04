package io.github.osmanfurkan115.product.model.dto

import org.hibernate.validator.constraints.URL
import java.math.BigDecimal
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

open class ProductRequest constructor(
    @field:NotBlank val productName: String,
    @field:NotNull val categoryId: Int,
    @URL @field:NotBlank val imageLink: String,
    @field:NotNull val price: BigDecimal = BigDecimal.ZERO,
    @field:NotNull val stockAmount: Int,
    @field:NotNull val ownerId: Long,
)