package hello.core

import hello.core.discount.DiscountPolicy
import hello.core.discount.FixDiscountPolicy
import hello.core.member.domain.MemberRepository
import hello.core.member.infra.persistence.HashMapMemberRepository
import hello.core.member.service.MemberService
import hello.core.member.service.MemberServiceImpl
import hello.core.order.service.OrderService
import hello.core.order.service.OrderServiceImpl

class AppConfig {

    fun memberService(): MemberService {
        return MemberServiceImpl(memberRepository())
    }

    fun memberRepository(): MemberRepository {
        return HashMapMemberRepository()
    }

    fun orderService(): OrderService {
        return OrderServiceImpl(memberRepository(), discountPolicy())
    }

    fun discountPolicy(): DiscountPolicy {
        return FixDiscountPolicy()
    }
}