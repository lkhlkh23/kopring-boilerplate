package practice.kopring.infra

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "coupon")
data class CouponEntity(
    @Id @Column(name = "id") val id: String,
    @Column(name = "discount") val discount: Long,
) {
    constructor() : this("", 0L)
}
