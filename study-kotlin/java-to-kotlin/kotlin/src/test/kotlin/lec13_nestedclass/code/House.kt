package lec13_nestedclass.code

class House constructor(
    val address: String,
) {
    val livingRoom: LivingRoom = LivingRoom(10.0)

    /*inner */class LivingRoom(
        val area: Double
    ) {
        /*val address: String
            get() = this@House.address*/
    }
}