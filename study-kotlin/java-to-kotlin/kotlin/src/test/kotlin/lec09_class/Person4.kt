package lec09_class

/**
 * 주 생성자는 항상 존재해야함
 * 부 생성자는 constructor 키워드를 직접 사용해서 this 와 함께 사용
 */
class Person4(
    val name: String,
    var age: Int
) {
    init {
        if (age <= 0) throw IllegalArgumentException("age is negative")
        println("person initialized with name : ${name}, age : ${age}")
    }

    constructor(name: String) : this(name, 26) {
        println("call constructor(${name}) -> this(${name}, 26)")
    }

    constructor() : this("하하") {
        println("call constructor() -> this(\"하하\")")
    }
}