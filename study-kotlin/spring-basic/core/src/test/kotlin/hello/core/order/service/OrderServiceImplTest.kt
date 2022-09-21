package hello.core.order.service

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import hello.core.member.service.MemberServiceImpl
import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class OrderServiceImplTest {

    private val memberService = MemberServiceImpl()
    private val orderService = OrderServiceImpl()


    @Test
    fun `create order`() {
        //given
        val member1 = Member(1L, "haha", Grade.VIP)
        val member2 = Member(2L, "papa", Grade.BASIC)

        memberService.join(member1)
        memberService.join(member2)

        //when
        val order = orderService.createOrder(1L, "클랜 애자일", 10000)
        println("order = ${order}")
        println("calculate price = ${order.calculatePrice}")

        //then
        then(order.calculatePrice).isEqualTo(9000)
    }
}