## access modifier

java
- public - 모든 곳에서 접근 가능
- protected - 같은 패키지 또는 하위 클래스에서만 접근 가능
- default - 같은 패키지에서만 접근 가능
- private - 선언된 클래스 내에서만 접근 가능

kotlin
- public - 모든 곳에서 접근 가능
- protected - 선언된 클래스 또는 하위 클래스에서만 접근 가능
- internal - 같은 모듈에서만 접근 가능
- private - 선언된 클래스 내에서만 접근 가능

### - kotlin 에서는 package 를 접근 제어 용도로 사용하지 않음
### - kotlin 의 기본 접근 지시어는 public


---
### .kt file
- public - 어디서든 접근할 수 있다
- protected - 사용 불가능
- internal - 같은 모듈에서만 접근 가능
- private - 같은 파일에서만 접근 가능