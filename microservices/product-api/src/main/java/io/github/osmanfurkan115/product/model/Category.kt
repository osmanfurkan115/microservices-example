package io.github.osmanfurkan115.product.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "categories")
data class Category constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @NotBlank
    @Column(unique = true)
    var categoryName: String,

    @NotBlank
    var description: String,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY, mappedBy = "category")
    @JsonManagedReference
    val products: MutableList<Product> = mutableListOf(),
)