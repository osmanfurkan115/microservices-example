package io.github.osmanfurkan115.product.model

import com.fasterxml.jackson.annotation.JsonBackReference
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

    @NotNull
    var active: Boolean = false,

    @CreatedDate
    val createdDate: LocalDateTime,
)

