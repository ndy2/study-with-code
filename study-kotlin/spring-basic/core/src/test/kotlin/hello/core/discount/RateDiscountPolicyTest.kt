package hello.core.discount

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class RateDiscountPolicyTest {

    val rateDiscountPolicy = RateDiscountPolicy()

    @Test
    fun discount() {
        //given
        val member1 = Member(1L, "haha", Grade.VIP)
        val member2 = Member(2L, "haha", Grade.BASIC)

        //when
        val actual1 = rateDiscountPolicy.discount(member1, 10000)
        val actual2 = rateDiscountPolicy.discount(member2, 10000)

        then(actual1).isEqualTo(1000)
        then(actual2).isEqualTo(0)
    }
}