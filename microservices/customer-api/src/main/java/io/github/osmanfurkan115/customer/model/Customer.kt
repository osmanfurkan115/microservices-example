package io.github.osmanfurkan115.customer.model

import com.fasterxml.jackson.annotation.JsonBackReference
import io.github.osmanfurkan115.customer.validation.annotation.PhoneNumber
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "customers")
data class Customer constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Size(min = 3, max = 32)
    var userName: String,

    @NotBlank
    var name: String,

    @Enumerated(EnumType.STRING)
    var gender: Gender,

    @Email
    @Column(unique = true)
    var email: String,

    @Size(min = 6)
    var password: String,

    @PhoneNumber
    @Column(unique = true)
    var phoneNumber: String,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "owner")
    @JsonBackReference
    var address: Set<Address> = HashSet(),

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "customer")
    @JoinColumn(name = "basket_id")
    @JsonBackReference
    var basket: Basket,

    @ManyToMany
    @JoinTable(name = "customer_coupons",
        joinColumns = [JoinColumn(name = "customer_id")],
        inverseJoinColumns = [JoinColumn(name = "coupon_id")]
    )
    var coupons: Set<Coupon> = HashSet(),

    @CreatedDate
    val createdDate: LocalDateTime,
)

