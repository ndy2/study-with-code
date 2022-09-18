package lec12_object

import org.junit.jupiter.api.Test

class 익명클래스테스트 {

    @Test
    internal fun name() {
        moveSomething(object : Movable {
            override fun move() {
                println("move")
            }

            override fun movemove() {
                println("move move")
            }
        })
    }

    fun moveSomething(movable: Movable) {
        movable.move()
        movable.movemove()
    }

    interface Movable {
        fun move()
        fun movemove()
    }
}