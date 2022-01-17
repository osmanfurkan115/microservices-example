package io.github.osmanfurkan115.product.model.dto

import io.github.osmanfurkan115.product.model.Product
import java.io.Serializable
import java.time.LocalDateTime

data class ReviewDto(
    val id: Int,
    val comment: String,
    val rate: Int,
    val customerId: Long,
    val product: Product,
    val active: Boolean = false,
    val createdDate: LocalDateTime,
) : Serializable
