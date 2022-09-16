## 타입 캐스팅
### is, !is 연산자
- java 의  instanceof 과 유사하다

```kotlin
val value: Type
val str: String

assertThat(value is Type).isTrue()
assertThat(str is Type).isFalse()
assertThat(value !is Type).isFalse()
assertThat(str !is Type).isTrue()
```

### as, as? 연산자
- java 의 (Casting) 과 유사하다

```kotlin
value as Type
```
- value 가 Type 이면 casting
- value 가 Type 이 아니면 ClassCastException 발생

<br>

```kotlin
value as? Type
```
- value 가 Type 이면 Type? 로 casting
- value 가 Type 이 아니면 null
- value 가 null 이면 null



## Kotlin 의 특이한 타입 세가지
Any, Unit, Nothing

### Any
- Java 의 Object 역할 (모든 객체의 최상위 타입)
- 모든 Primitive Type 의 최상위 타입도 Any 다
- Any 자체로는 null 을 포함할 수 없다
  - null 을 포함하고 싶다면 Any? 로 표현
- Any 에 equals, hashCode, toString 있다

### Unit
- Java 의 void 역할
- void 와 달리 그 자체로 타입 인자로 사용 가능하다
- fp 에서 Unit 은 단 하나의 인스턴스 만을 가지는 타입을 의미
  - i.e. 코틀린의 Unit 은 실제 존재하는 타입이라는 것을 표현

### Nothing
- Nothing 은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할
- 무조건 예외를 반환하는 함수/ 무한 루프 함수 등
```kotlin
fun fail(message: String): Nothing{
    throw IllegalArgumentException(message)
}
```