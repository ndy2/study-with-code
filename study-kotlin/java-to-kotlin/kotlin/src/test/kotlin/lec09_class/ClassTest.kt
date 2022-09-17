package lec09_class

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ClassTest {

    @Test
    internal fun `getter 와 setter 는 dot field 로 사용 할 수 있다`() {
        val haha = Person2("하하", 26)

        assertThat(haha.name).isEqualTo("하하")
        assertThat(haha.age).isEqualTo(26)

        //java 클래스도 dot 으로 접근 가능
        val hoho = JavaPerson("호호", 30)

        assertThat(hoho.name).isEqualTo("호호")
        assertThat(hoho.age).isEqualTo(30)
    }

    /**
     * 역순 호출
     * person initialized with name : 하하, age : 26
     * call constructor(하하) -> this(하하, 26)
     * call constructor() -> this("하하")
     */
    @Test
    internal fun `constructor 와 init 의 호출 순서를 확인하자`() {
        val haha = Person4()

        assertThat(haha.name).isEqualTo("하하")
        assertThat(haha.age).isEqualTo(26)
    }
}