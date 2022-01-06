package io.github.osmanfurkan115.product.model

import com.fasterxml.jackson.annotation.JsonManagedReference
import org.hibernate.Hibernate
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
    var products: MutableList<Product>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Category

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , categoryName = $categoryName , description = $description )"
    }
}
