package practice.kopring.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import practice.kopring.controller.dto.CouponResponse
import practice.kopring.service.CouponService

@RestController
@RequestMapping("/coupons")
class CouponController {
    @Autowired
    lateinit var couponJpaService: CouponService

    @GetMapping("/{id}")
    fun getCoupon(
        @PathVariable id: String,
    ): CouponResponse {
        val coupon = couponJpaService.getCoupon(id)
        return CouponResponse(coupon.id, coupon.discount)
    }
}
