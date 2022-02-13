package io.github.osmanfurkan115.customer.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "basket_items")
data class BasketItem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    val productId: Long,
    val quantity: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    @JsonBackReference
    val basket: Basket
)
