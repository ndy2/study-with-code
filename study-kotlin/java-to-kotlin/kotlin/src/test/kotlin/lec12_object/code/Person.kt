package lec12_object.code

class Person private constructor(
    var name: String,
    var age: Int
) {

    companion object Factory : Log {
        const val MIN_AGE = 1 // const -> 변수가 compile 시에 할당 된다, 기본 타입과 String 에만 붙일 수 있다
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("hello companion object")
        }
    }
}