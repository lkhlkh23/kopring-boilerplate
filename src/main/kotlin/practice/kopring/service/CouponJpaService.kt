package practice.kopring.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import practice.kopring.domain.Coupon
import practice.kopring.exception.CouponNotFoundException
import practice.kopring.infra.CouponEntity
import practice.kopring.repository.CouponJpaRepository
import java.util.*

@Service("CouponJpaService")
class CouponJpaService : CouponService {
    @Autowired
    lateinit var repository: CouponJpaRepository

    override fun getCoupon(id: String): Coupon {
        val coupon: Optional<CouponEntity> = repository.findById(id)
        if (coupon.isEmpty) {
            throw CouponNotFoundException("Not Exist Coupon")
        }

        return Coupon(coupon.get().id, coupon.get().discount)
    }
}
