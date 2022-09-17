package lec09_class

class Human(
    name: String,
    var age: Int
) {

    val name = name
        get() = field.toUpperCase() // 무한 루프를 막기 위한 예약어, 자기 자신을 가리킨다

    fun isAdult1(): Boolean {
        return this.age >= 20
    }

    val isAdult2: Boolean
        get() = this.age >= 20


    val isAdult3: Boolean
        get() {
            return this.age >= 20
        }


}