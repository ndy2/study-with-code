package lec03_type

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class TypeTest {

    @Test
    internal fun type() {
        val number1 = 3
        val number2: Long = number1.toLong()

        assertThat(number2).isEqualTo(3L)
    }

    @Test
    internal fun `type with safe-call`() {
        val number1: Int? = 3
        val number2: Long? = number1?.toLong()

        assertThat(number2).isEqualTo(3L)
    }


    fun getAgeIfHaha_V1(target: Any): Int {
        if (target is Haha) {
            // smart cast
            return target.age
        }
        throw IllegalArgumentException("no haha")
    }

    fun getAgeIfHaha_V2(target: Any): Int {
        return if (target is Haha) target.age else throw IllegalArgumentException("no haha")
    }

    @Test
    internal fun `type casting`() {
        val haha = Haha()
        val noHaha = "noHaha"

        assertThat(getAgeIfHaha_V1(haha)).isEqualTo(26)
        assertThatIllegalArgumentException().isThrownBy { getAgeIfHaha_V1(noHaha) }
        assertThat(getAgeIfHaha_V2(haha)).isEqualTo(26)
        assertThatIllegalArgumentException().isThrownBy { getAgeIfHaha_V2(noHaha) }
    }
}