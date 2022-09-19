package lec16_function

import org.junit.jupiter.api.Test

class InlineFunctionTest {

    inline fun Int.add(other: Int): Int {
        return this + other
    }

    @Test
    internal fun name() {
        3.add(4)
    }
}