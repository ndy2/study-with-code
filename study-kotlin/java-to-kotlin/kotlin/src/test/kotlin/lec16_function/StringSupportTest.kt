package lec16_function

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringSupportTest {

    @Test
    internal fun name() {
        val lastChar = "hello".lastChar()

        assertThat(lastChar).isEqualTo('o')
    }
}