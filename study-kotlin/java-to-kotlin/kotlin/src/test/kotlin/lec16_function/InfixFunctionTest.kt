package lec16_function

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InfixFunctionTest {

    fun Int.add(other: Int): Int {
        return this + other;
    }

    infix fun Int.mul(other: Int): Int {
        return this * other;
    }

    @Test
    internal fun name() {
        assertThat(2.mul(3)).isEqualTo(6)
        assertThat(2 mul 3).isEqualTo(6)
    }
}