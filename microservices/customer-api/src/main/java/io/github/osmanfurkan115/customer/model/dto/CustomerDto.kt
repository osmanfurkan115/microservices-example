package io.github.osmanfurkan115.customer.model.dto

import io.github.osmanfurkan115.customer.validation.annotation.PhoneNumber
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CustomerDto(
    val id: Long,
    @field:Size(min = 3, max = 32) val userName: String,
    @field:NotBlank val name: String,
    @field:Email val email: String,
    @PhoneNumber val phoneNumber: String,
) : Serializable
