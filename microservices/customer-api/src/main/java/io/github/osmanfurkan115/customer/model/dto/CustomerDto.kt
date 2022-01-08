package io.github.osmanfurkan115.customer.model.dto

import io.github.osmanfurkan115.customer.model.Address
import io.github.osmanfurkan115.customer.model.Coupon
import io.github.osmanfurkan115.customer.model.Gender
import io.github.osmanfurkan115.customer.validation.annotation.PhoneNumber
import java.io.Serializable
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CustomerDto(
    val id: Long,
    @field:Size(min = 3, max = 32) val userName: String,
    @field:NotBlank val name: String,
    @Enumerated(EnumType.STRING) var gender: Gender,
    @field:Email val email: String,
    @field:Size(min = 6) val password: String,
    @PhoneNumber val phoneNumber: String,
    val address: Set<Address>,
    val coupons: Set<Coupon>
) : Serializable
