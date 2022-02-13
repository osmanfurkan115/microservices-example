package io.github.osmanfurkan115.customer.model.dto

import io.github.osmanfurkan115.customer.model.Gender
import io.github.osmanfurkan115.customer.validation.annotation.PhoneNumber
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.Email
import javax.validation.constraints.Size


data class CreateCustomerRequest(
    val id: Int,
    @Size(min = 3, max = 32) val username: String,
    val name: String,
    @Enumerated(EnumType.STRING) val gender: Gender,
    @Email val email: String,
    val password: String,
    @PhoneNumber val phoneNumber: String,
)
