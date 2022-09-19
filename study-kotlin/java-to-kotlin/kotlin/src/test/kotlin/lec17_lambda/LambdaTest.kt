package lec17_lambda

import lec17_lambda.code.Fruit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LambdaTest {


    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1000),
        Fruit("사과", 2000),
        Fruit("바나나", 3000),
        Fruit("바나나", 4000),
        Fruit("수박", 1000),
        Fruit("오렌지", 10000),
    )

    @Test
    internal fun lambda() {
        assertThat(isApple(fruits[0])).isTrue
        assertThat(isApple2(fruits[0])).isTrue

        assertThat(isApple.invoke(fruits[0])).isTrue
        assertThat(isApple2.invoke(fruits[0])).isTrue
    }

    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

    fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
        val results = mutableListOf<Fruit>()
        for (fruit in fruits) {
            if (filter(fruit)) {
                results.add(fruit)
            }
        }
        return results
    }

    @Test
    internal fun filterFruitsTest() {
        val apples = filterFruits(fruits, isApple)

        assertThat(apples).hasSize(3)
    }


    @Test
    internal fun filterFruitsTest2() {
        val apples1 = filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
        val apples2 = filterFruits(fruits) { fruit -> fruit.name == "사과" }
        val apples3 = filterFruits(fruits) { a -> a.name == "사과" }
        val apples4 = filterFruits(fruits) { it.name == "사과" }
    }


    @Test
    internal fun closureTest() {
        var targetFruitName = "바나나"
        targetFruitName = "수박"

        filterFruits(fruits) {it.name == targetFruitName}
    }
}