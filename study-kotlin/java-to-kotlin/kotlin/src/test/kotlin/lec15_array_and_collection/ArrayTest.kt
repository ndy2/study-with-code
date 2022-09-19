package lec15_array_and_collection

import org.junit.jupiter.api.Test

class ArrayTest {

    @Test
    internal fun arrayTest() {
        val array = arrayOf<Int>(100, 200)

        for (value in array) {
            println("val : ${value}")
        }

        for (i in array.indices) {
            println("i : ${i}, val : ${array[i]}")
        }

        for ((idx, value) in array.withIndex()) {
            println("i : ${idx}, val : ${value}")
        }

        val arrayWith300 = array.plus(300)

        for ((idx, value) in arrayWith300.withIndex()) {
            println("i : ${idx}, val : ${value}")
        }
    }
}