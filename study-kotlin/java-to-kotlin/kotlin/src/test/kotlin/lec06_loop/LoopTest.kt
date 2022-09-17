package lec06_loop

import org.junit.jupiter.api.Test

class LoopTest {


    @Test
    internal fun forEachTest() {
        val numbers = listOf(1L, 2L, 3L)

        for (number in numbers) {
            println(number)
        }
    }

    @Test
    internal fun foriTest() {
        for (i in 1..3) {
            println(i)
        }
    }

    @Test
    internal fun `fori douwnTo 1`() {
        for (i in 3 downTo 1) {
            println(i)
        }
    }

    @Test
    internal fun `fori step 2`() {
        for (i in 1..5 step 2) {
            println(i)
        }
    }
}