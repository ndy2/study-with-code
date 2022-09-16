package lec03_type

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    internal fun `String InterPolation`() {
        val name = "haha"
        val age = 26

        assertThat("이름 : ${name}, 나이 : $age").isEqualTo("이름 : haha, 나이 : 26")
    }

    @Test
    internal fun `String Box`() {
        val str = """
            ABC
            DEF
        """.trimIndent()

        assertThat(str).isEqualTo("ABC\nDEF")

    }

    @Test
    internal fun `String Indexing`() {
        val str = "ABCDEF"
        assertThat(str[0]).isEqualTo('A')
    }
}