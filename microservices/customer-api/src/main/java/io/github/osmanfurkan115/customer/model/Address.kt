package io.github.osmanfurkan115.customer.model

import com.fasterxml.jackson.annotation.JsonBackReference
import org.hibernate.Hibernate
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
@Table(name = "addresses")
data class Address constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @NotBlank
    var addressName: String,

    @NotBlank
    var address: String,

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = [CascadeType.PERSIST])
    @JoinColumn(name = "owner_id")
    @JsonBackReference
    val owner: Customer
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Address

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}

