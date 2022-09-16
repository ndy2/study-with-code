package lec02_null

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class Null {

    /**
     * safecall (?.)
     * 연산 결과가 null 이면 null 반환
     */
    @Test
    internal fun safecall() {

        var str: String? = "ABC"

        // compile error
        // assertThat(str.length).isEqualTo(3);
        Assertions.assertThat(str?.length).isEqualTo(3);

        str = null;
        Assertions.assertThat(str?.length).isNull();
    }

    /**
     * Elvis 연산자 (?:)
     * 앞의 연산 결과가 null 이면 뒤의 값을 사용
     */
    @Test
    internal fun elvis() {
        var str: String? = "ABC"
        Assertions.assertThat(str?.length ?: -1).isEqualTo(3)

        str = null;
        Assertions.assertThat(str?.length ?: -1).isEqualTo(-1)
    }

    fun starsWithA1(s: String?): Boolean {
        return s?.startsWith("A") ?: throw IllegalArgumentException("null 이 들어 있습니다.")
    }

    fun starsWithA2(s: String?): Boolean? {
        return s?.startsWith("A")
    }

    fun starsWithA3(s: String?): Boolean {
        return s?.startsWith("A") ?: false
    }

    @Test
    internal fun a1() {
        assertThat(starsWithA1("ABC")).isTrue()
        assertThat(starsWithA1("CBA")).isFalse()
        assertThatIllegalArgumentException().isThrownBy { starsWithA1(null) }
    }

    @Test
    internal fun a2() {
        assertThat(starsWithA1("ABC")).isTrue()
        assertThat(starsWithA1("CBA")).isFalse()
        assertThat(starsWithA2(null)).isNull()
    }

    @Test
    internal fun a3() {
        assertThat(starsWithA3("ABC")).isTrue()
        assertThat(starsWithA3("CBA")).isFalse()
        assertThat(starsWithA3(null)).isFalse()
    }

    fun addOneIfNotNull(number: Long?): Long {
        number ?: return 0
        return number + 1
    }


    // 안되네?
    /*fun addOneIfNotNull_3항_연산자(number: Long?): Long {
        return number == null ? 0 : number+1
    }*/

    // null 아님 단언
    fun startsWithAB(str: String?): Boolean {
        return str!!.startsWith("AB")
    }

    @Test
    internal fun `null 아님 단언`() {

        assertThat(startsWithAB("ABC")).isTrue()
        assertThat(startsWithAB("CBA")).isFalse()
        assertThatNullPointerException().isThrownBy { startsWithAB(null) }
    }
}