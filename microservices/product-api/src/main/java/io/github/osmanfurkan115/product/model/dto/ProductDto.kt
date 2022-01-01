package io.github.osmanfurkan115.product.model.dto

import org.jetbrains.annotations.NotNull
import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime

data class ProductDto(
    val id: Long,
    val productName: String,
    val imageLink: String,
    @field:NotNull val price: BigDecimal = BigDecimal.ZERO,
    val stockAmount: Int,
    @NotNull val ownerId: Long,
    val createdDate: LocalDateTime,
    val lastModifiedDate: LocalDateTime,
) : Serializable
