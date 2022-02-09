package io.github.osmanfurkan115.customer.model

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "coupons")
data class Coupon constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @NotBlank
    var couponName: String,

    @NotBlank
    var percentage: Double,
)

