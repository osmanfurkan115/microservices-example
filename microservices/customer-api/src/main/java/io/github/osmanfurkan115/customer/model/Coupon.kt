package io.github.osmanfurkan115.customer.model

import org.hibernate.Hibernate
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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Coupon

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}

