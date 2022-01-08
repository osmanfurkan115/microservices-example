package io.github.osmanfurkan115.product.model.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class ReviewRequest(
    val id: Int,
    @NotBlank val comment: String,
    @Size(min = 1, max = 5) val rate: Int,
    @NotNull val customerId: Long,
)