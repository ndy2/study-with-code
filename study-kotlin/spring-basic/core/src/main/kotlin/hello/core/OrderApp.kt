package hello.core

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import hello.core.member.service.MemberServiceImpl
import hello.core.order.service.OrderServiceImpl

fun main() {

    val memberService = AppConfig().memberService()
    val orderService = AppConfig().orderService()


    val member1 = Member(1L, "haha", Grade.VIP)
    val member2 = Member(2L, "papa", Grade.BASIC)

    memberService.join(member1)
    memberService.join(member2)

    val order = orderService.createOrder(1L, "클랜 애자일", 10000)
    println("order = ${order}")
    println("calculate price = ${order.calculatePrice}")
}