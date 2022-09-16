package lec01_variable

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class Variable {

    @Test
    internal fun variable() {

        var number1 = 10L; //발 - 가변
        val number2 = 10L; //밸 - 불변

        var number3: Long = 10L; // 콜론 띄고 타입, long 은 안됨
        val number4: Long = 10L; // 콜론 띄고 타입, long 은 안됨

        // 초기값을 지정해 주지 않는 경우 -> 타입을 적어줘야함
        // 컴파일러가 추론을 할 수 없음
        var number5: Long
        val number6: Long

        //컴파일 에러 발생 Variable 'number5' must be initialized
        //println(number5)
    }

    @Test
    internal fun `val collection 에도 element 를 추가 할 수 있다`() {
        //given
        val valCollection = mutableListOf<Long>()
        val expected = 1L
        valCollection.add(expected);

        //when
        val actual = valCollection.get(0);
        val actual2 = valCollection[0];

        //then
        assertThat(actual).isEqualTo(expected);
        assertThat(actual2).isEqualTo(expected);
    }

    /**
     * Some types can have a special internal representation
     * for example - numbers, characters and booleans
     * can be represented as primitive values at runtime
     *
     * but to the user they look like ordinary classes
     *
     * 연산을 하는 경우 알아서 primitive 로 처리 해 준다
     */
    @Test
    internal fun primitive() {

        var number1 = 10L;
        var number3 = 1000L;
    }

    @Test
    internal fun nullable() {
        var number1 = 10L;
        var number3 = 1000L;

        //Null can not be a value of a non-null type Long
        //이럴 수가!
        //number3 = null;

        // null 가능 여부를 처음 부터 나타내야 함
        var number4: Long? = 1000L;
        number4 = null;
    }

    @Test
    internal fun ` 객체 인스턴스 화 `() {
        // 이럴 수가 이걸 쓸 수 있네...
        val person = Variable_Java.Person("남득윤");

        assertThat(person.name).isEqualTo("남득윤");
    }
}