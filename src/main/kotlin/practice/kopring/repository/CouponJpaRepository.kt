package practice.kopring.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import practice.kopring.infra.CouponEntity

@Repository
interface CouponJpaRepository : CrudRepository<CouponEntity, String>
