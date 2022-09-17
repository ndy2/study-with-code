package lec04_operator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    internal fun `객체의 비교 연산자 에는 CompareTo 자동 적용`() {
        val money100 = Money_Java(100)
        val money200 = Money_Java(200)

        assertThat(money200 > money100).isTrue();
        assertThat(money200).isGreaterThan(money100)
    }

    @Test
    internal fun `identity ===`() {
        val money100_1 = Money_Java(100)

        assertThat(money100_1 === money100_1).isTrue();
    }

    @Test
    internal fun `equality ==`() {
        val money100_1 = Money_Java(100)
        val money100_2 = Money_Java(100)

        assertThat(money100_1 == money100_2).isTrue();
    }

    @Test
    internal fun `연산자 오버로딩 + -`() {
        val money100 = Money(100)
        val money200 = Money(200)

        assertThat(money100 + money200).isEqualTo(Money(300))
    }
}