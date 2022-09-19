package lec15_array_and_collection

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CollectionTest {

    @Nested
    class listTest {


        @Test
        internal fun name() {

            val intList = listOf(100, 200)
            val emptyList = emptyList<Int>()

            printNumbers(intList)
            printNumbers(emptyList()) // <- type 추론
        }

        fun printNumbers(number: List<Int>) {
            number.forEach(::println)
        }


        @Test
        internal fun name2() {

            val intList = listOf(100, 200)
            println(intList[0])

            for (i in intList) {
                println("value = ${i}")
            }

            for ((idx, value) in intList.withIndex()) {
                println("idx = ${idx} value = ${value}")
            }
        }

        @Test
        internal fun name3() {
            val mutableListOf = mutableListOf(100, 200)
            mutableListOf.add(300)

            assertThat(mutableListOf[2]).isEqualTo(300)
        }
    }

    @Nested
    class mapTest {

        @Test
        internal fun name() {

            val oldMap = mutableMapOf<Int, String>()
            oldMap.put(1, "Monday")
            oldMap[2] = "Tuesday"

            mapOf(1 to "Monday", 2 to "Tuesday")

            oldMap.keys
            oldMap.entries
            oldMap.values
        }

    }
}