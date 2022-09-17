package lec05_conditionalstatement

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class conditionalStatementTest {

    fun validateScoreIsNotNegative(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException("score is negative. score : ${score}")
        }
    }

    fun validateScore(score: Int) {
        if (score !in 0..100) {
            throw IllegalArgumentException("score is not in 0 .. 100. score : ${score}")
        }
    }

    @Test
    internal fun ifTest() {
        assertThatNoException()
            .isThrownBy { validateScoreIsNotNegative(1) }

        assertThatIllegalArgumentException()
            .isThrownBy { validateScoreIsNotNegative(-1) }
            .withMessage("score is negative. score : -1")
    }


    /**
     * kotlin 의 if 는 expression 이다.
     */
    fun getPassOrFail(score: Int): String {
        return if (score > 50) "P" else "F"
    }

    @Test
    internal fun ifElseTest() {
        assertThat(getPassOrFail(51)).isEqualTo("P")
        assertThat(getPassOrFail(50)).isEqualTo("F")
    }

    fun getGrateWithWhen(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }
    }

    fun getGrateWithWhen2(score: Int): String {
        return when (score) {
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "D"
        }
    }

    fun startsWithA(target: Any): Boolean {
        return when (target) {
            is String -> target.startsWith("A")
            else -> false
        }
    }

    fun judgeNumber(number: Int) {
        when (number) {
            1, 0, -1 -> println("어디서 많이 본 숫자 입니다")
            else -> println("몰라용")
        }
    }

    fun judgeNumber2(number: Int) {
        when{
            number == 0 -> println("주어진 숫자는 0 입니다")
            number %2 == 0 -> println("주어진 숫자는 짝수입니다")
            else -> println("주어진 숫자는 홀수입니다")
        }
    }
}