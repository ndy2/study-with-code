package hello.core.discount

import hello.core.member.domain.Member

class RateDiscountPolicy : DiscountPolicy {

    override fun discount(member: Member, price: Int): Int {
        TODO("Not yet implemented")
    }
}