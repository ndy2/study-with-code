package hello.core.order.service

import hello.core.discount.DiscountPolicy
import hello.core.discount.FixDiscountPolicy
import hello.core.member.domain.MemberRepository
import hello.core.member.infra.persistence.HashMapMemberRepository
import hello.core.order.domain.Order
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    val memberRepository: MemberRepository,
    private val discountPolicy : DiscountPolicy,
) : OrderService {


    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {

        val member = memberRepository.findById(memberId)
        val discountPrice = discountPolicy.discount(member, itemPrice)

        return Order(
            memberId,
            itemName,
            itemPrice,
            discountPrice
        )
    }
}