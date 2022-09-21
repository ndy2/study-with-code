package hello.core.discount

import hello.core.member.domain.Grade
import hello.core.member.domain.Member

class RateDiscountPolicy : DiscountPolicy {

    companion object {
        const val VIP_DISCOUNT_RATE = 10
    }

    override fun discount(member: Member, price: Int): Int {

        return if(member.grade == Grade.VIP) price * VIP_DISCOUNT_RATE / 100 else 0
    }
}