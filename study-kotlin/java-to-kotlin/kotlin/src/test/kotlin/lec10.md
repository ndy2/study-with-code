## Inheritance

### 1. abstract class

```kotlin
abstract class Animal(
    protected val species: String,
    protected val legCount: Int
) {
    abstract fun move()
}

class Cat(
    species: String
) : Animal(species, 4) {

    override fun move() {
        println("고양 고양 고양 고양")
    }
}
 ```

- `extends` -> `:`
- `Override` -> `override`
- 추상 프로퍼티가 아니라면, 상속받을때 `open` 을 꼭 붙여야 한다

### 2. interface


### 3. ⚠️ warning

### 4. 지시어