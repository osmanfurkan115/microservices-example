package io.github.osmanfurkan115.customer.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
@Table(name = "baskets")
data class Basket(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    var customer: Customer,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "basket")
    val basketItems: List<BasketItem> = mutableListOf(),
)
