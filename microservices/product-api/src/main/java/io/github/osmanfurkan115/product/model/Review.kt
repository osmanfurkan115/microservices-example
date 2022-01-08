package io.github.osmanfurkan115.product.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.Hibernate
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "reviews")
data class Review constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @NotBlank
    var comment: String,

    @Size(min = 1, max = 5)
    var rate: Int,

    @NotNull
    var customerId: Long,

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "product_id")
    @JsonBackReference
    val product: Product,

    @CreatedDate
    val createdDate: LocalDateTime

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Review

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}

