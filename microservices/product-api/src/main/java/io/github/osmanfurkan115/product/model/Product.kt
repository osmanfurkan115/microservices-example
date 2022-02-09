package io.github.osmanfurkan115.product.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.validator.constraints.URL
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

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "category_id")
    @JsonBackReference
    var category: Category?,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "product")
    @JsonManagedReference
    var reviews: Set<Review> = HashSet(),

    @URL
    var imageLink: String,

    @NotNull
    var price: BigDecimal = BigDecimal.ZERO,

    var stockAmount: Int,

    @NotNull
    var ownerId: Long,

    @CreatedDate
    val createdDate: LocalDateTime,

    @LastModifiedDate
    var lastModifiedDate: LocalDateTime,
)
