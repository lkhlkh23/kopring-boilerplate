package practice.kopring.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import practice.kopring.controller.dto.CouponResponse

@RestController
@RequestMapping("/coupons")
class CouponController {
    @GetMapping("/{id}")
    fun getCoupon(
        @PathVariable id: String,
    ): CouponResponse {
        return CouponResponse("id-1", 100)
    }
}
