package io.github.osmanfurkan115.product.model

import org.hibernate.Hibernate
import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var productName: String,

    var imageLink: String,

    @NotNull
    var price: BigDecimal = BigDecimal.ZERO,

    var stockAmount: Int,

    @CreatedDate
    val createdDate: LocalDateTime,

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime,


    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Product

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , productName = $productName , imageLink = $imageLink , price = $price , stockAmount = $stockAmount , createdDate = $createdDate , lastModifiedDate = $lastModifiedDate )"
    }
}
