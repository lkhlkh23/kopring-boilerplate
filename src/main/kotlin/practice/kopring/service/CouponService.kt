package practice.kopring.service

import practice.kopring.domain.Coupon

interface CouponService {
    fun getCoupon(id: String): Coupon
}
