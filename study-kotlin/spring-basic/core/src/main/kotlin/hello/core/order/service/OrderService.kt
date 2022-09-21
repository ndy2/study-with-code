package hello.core.order.service

import hello.core.order.domain.Order

interface OrderService {

    fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order
}