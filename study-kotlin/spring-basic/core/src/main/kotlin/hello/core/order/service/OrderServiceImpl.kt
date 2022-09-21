package hello.core.order.service

import hello.core.discount.FixDiscountPolicy
import hello.core.member.infra.persistence.HashMapMemberRepository
import hello.core.order.domain.Order

class OrderServiceImpl : OrderService {

    private val memberRepository = HashMapMemberRepository()
    private val discountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {

        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(
            memberId,
            itemName,
            itemPrice,
            discountPrice,
        )
    }
}