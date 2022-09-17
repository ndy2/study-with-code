## Class

### 1. class & property

### java
```java

public class JavaPerson {

	private final String name;
	private int age;

	public JavaPerson(final String name, final int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(final int age) {
		this.age = age;
	}
}

```

### kotlin
```kotlin
class Person constructor(
    name: String,
    age: Int
) {

    val name: String = name
    var age: Int = age
}
```
```kotlin
class Person2 (
    val name: String,
    var age: Int
)
```


### 2. constructor & init
```kotlin
/**
 * 주 생성자는 항상 존재해야함
 * 부 생성자는 constructor 키워드를 직접 사용해서 this 와 함께 사용
 */
class Person4(
    val name: String,
    var age: Int
) {
    init {
        if (age <= 0) throw IllegalArgumentException("age is negative")
    }

    constructor(name: String) : this(name, 1)
}
```
- 부 생성자는 최종적으로 primaray constructor 를 호출 해야 한다
- 부 생성자는 block 을 가질 수 있다

---
```kotlin
class Person4(
    val name: String,
    var age: Int
) {
    init {
        if (age <= 0) throw IllegalArgumentException("age is negative")
        println("person initialized with name : ${name}, age : ${age}")
    }

    constructor(name: String) : this(name, 26) {
        println("call constructor(${name}) -> this(${name}, 26)")
    }

    constructor() : this("하하") {
        println("call constructor() -> this(\"하하\")")
    }
}
```

```kotlin
    @Test
    internal fun `constructor 와 init 의 호출 순서를 확인하자`() {
        val haha = Person4()

        assertThat(haha.name).isEqualTo("하하")
        assertThat(haha.age).isEqualTo(26)
    }
```
->
```text
person initialized with name : 하하, age : 26
call constructor(하하) -> this(하하, 26)
call constructor() -> this("하하")
```

- note 
  - kotlin 은 부 생성자 보다 default parameter 를 권장함
  - Converting 과 같은 경우 사용 할 수 있음
  - 사실 그보다도 정적 팩토리 메소드를 추천

### 3. custom getter & setter

### custom getter
```kotlin

class Human(
    val name: String,
    var age: Int
) {
    fun isAdult1(): Boolean {
        return this.age >= 20
    }

    val isAdult2: Boolean
        get() = this.age >= 20


    val isAdult3: Boolean
        get() {
            return this.age >= 20
        }
}
```
### 4. backing field

```kotlin
val name = name
    get() = field.toUpperCase() // 무한 루프를 막기 위한 예약어, 자기 자신을 가리킨다
```