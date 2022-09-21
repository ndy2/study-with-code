package hello.core.order.domain

class Order(
    private val memberId: Long,
    private val itemName: String,
    private val itemPrice: Int,
    private val discountPrice: Int,
) {

    val calculatePrice
        get() = itemPrice - discountPrice

    override fun toString(): String {
        return "Order(memberId=$memberId, itemName='$itemName', itemPrice=$itemPrice, discountPrice=$discountPrice)"
    }
}