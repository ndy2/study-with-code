package lec09_class

class Person3(
    val name: String,
    var age: Int
) {
    init {
        if(age <=0) throw IllegalArgumentException("age is negative")
    }
}