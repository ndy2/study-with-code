package hello.core.order.domain

class Order(
    val memberId: Long,
    val itemName: String,
    val itemPrice: Int,
    val discountPrice: Int,
) {

    val calculatePrice
        get() = itemPrice - discountPrice

    override fun toString(): String {
        return "Order(memberId=$memberId, itemName='$itemName', itemPrice=$itemPrice, discountPrice=$discountPrice)"
    }
}