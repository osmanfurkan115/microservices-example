package io.github.osmanfurkan115.customer.model.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


class CreateAddressRequest(
    @NotNull val id: Int,
    @NotBlank val addressName: String,
    @NotBlank val address: String,
    @NotNull val customerId: Long
)