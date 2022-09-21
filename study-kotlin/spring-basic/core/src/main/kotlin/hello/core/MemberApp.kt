package hello.core

import hello.core.member.domain.Grade
import hello.core.member.domain.Member
import hello.core.member.service.MemberService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = ac.getBean(MemberService::class.java)

    val member1 = Member(1L, "하하", Grade.BASIC)
    val member2 = Member(2L, "파파", Grade.BASIC)
    val member3 = Member(3L, "나나", Grade.VIP)

    memberService.join(member1)
    memberService.join(member2)

    val actual1 = memberService.findMember(1L)
    val actual2 = memberService.findMember(2L)

    println(member1 == actual1)
    println(member2 == actual2)
}