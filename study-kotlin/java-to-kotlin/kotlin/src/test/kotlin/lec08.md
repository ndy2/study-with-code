## Function

1. 함수 선언 문법

- 두 정수를 받아 더 큰 정수를 반환

```kotlin
fun max(a: Int, b: Int): Int {
    if (a > b) {
        return a
    }
    return b
}
```

```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}
```

```kotlin
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}
```

```kotlin
fun max(a: Int, b: Int): Int = if (a > b) a else b
```

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b
```

- 접근 제어자 - 기본이 public
- 반환타입
    - Unit(void) : 생략가능
    - 리턴 타입을 추론 할 수 있어도 생략가능 (= 사용하는 경우)
- 함수의 block 이 하나의 결과 값이면 block 대신 = 사용 가능

2. default parameter

- 주어진 문자열을 n 번 출력하는 예제
- 기본으로 newLine 을 제공하고 싶다
- 오버로딩... 메서드 지옥에 빠지고 만다

```java
public void repeat(String str,int n,boolean newLine){
	for(int i=1;i<=n;i++){
	if(newLine)
	System.out.println(str);
	}else{
	System.out.print(str);
	}
	}
```

```java
public void repeat(String str,int n){
	repeat(str,n,true);
	}

```

---
kotlin 의 default parameter

- 캬...
- kotlin 에도 overloading 은 있다

```kotlin
fun repeat(
    str: String,
    n: Int,
    newLine: Boolean = true
) {
    for (i in 1..n) if (newLine) println(str) else print(str)
}
```

### named parameter

- 어떤 파라미터에 아규먼트를 제공할지 호출하는 쪽에서 선택 가능
- 빌더를 구현하지 않고 빌더의 장점을 가질 수 있다
- kotlin 에서 java 의 함수를 가져다 쓸 때는 named parameter 출력 할 수 없음

```kotlin
repeat("hello World", newLine = false)
```

### varargs

java

```java
public void pringAll(String...strings){
	for(String str:strings){
	System.out.println(str);
	}
	}
```

 ---
kotlin

```kotlin
fun printAll(vararg strings: String) {
    for (str in strings) {
        pringln(str)
    }
}

printAll("A","B","C")

// spread 연산자
printAll(*arrayOf("A","B","C"))
```