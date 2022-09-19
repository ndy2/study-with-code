# 다양한 함수

### 1. 확장 함수
Kotlin 의 고민
- Java 코드 위에 자연스럽게 코틀린 코드를 추가하고 싶다!
- > Java 로 만들어진 라이브러리를 유지보수, 확장할 때 Kotlin 코드를 덧 붙이고 싶어!!!

```kotlin
// this : 수신 객체
// String : 수신 객체 타입
fun String.lastChar(): Char {

    return this[this.length - 1]
}

@Test
internal fun name() {
    val lastChar = "hello".lastChar()

    assertThat(lastChar).isEqualTo('o')
}
```

확장 함수는 원본 클래스의 private, protected 멤버 접근 분가

확장 함수가 멤버함수의 시그니처를 덮어쓰는 경우
-> 멤버 함수가 호출된다

확장함수가 override 된다면?
-> 선언 타입 기준으로 호출된다

### 2. infix 함수
중위 호출이 가능하게 해준다

```kotlin

    infix fun Int.mul(other: Int): Int {
        return this * other;
    }

    @Test
    internal fun name() {
        assertThat(2.mul(3)).isEqualTo(6)
        assertThat(2 mul 3).isEqualTo(6)
    }
```

### 3. inline 함수
함수가 호출되는 대신 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우!

```kotlin
    inline fun Int.add(other: Int): Int {
        return this + other
    }

    @Test
    internal fun name() {
        3.add(4)
    }
```

```java
   @Test
   public final void name$kotlin() {
      byte $this$add$iv = 3;
      int other$iv = 4;
      int $i$f$add = false;
      int var10000 = $this$add$iv + other$iv;
   }
```

### 지역함수
fun 안의 fun
- 잘 쓰지는 않는다.
- depth 가 깊어짐