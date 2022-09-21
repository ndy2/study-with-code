package hello.core.discount

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import org.springframework.stereotype.Component

@Component
class FixDiscountPolicy : DiscountPolicy {

    companion object {
        const val VIP_DISCOUNT_AMOUNT = 1000
    }

    override fun discount(member: Member, price: Int): Int {
        return if (member.grade == Grade.VIP) VIP_DISCOUNT_AMOUNT else 0
    }
}