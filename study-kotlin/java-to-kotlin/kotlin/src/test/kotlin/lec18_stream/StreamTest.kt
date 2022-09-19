package lec18_stream

import org.junit.jupiter.api.Test

class StreamTest {

    val fruits = listOf(
        Fruit(1, "사과", 100, 200)
    )

    @Test
    internal fun name() {

        fruits.filter({ fruit -> fruit.name == "사과" })
        fruits.filter { fruit -> fruit.name == "사과" }

        fruits.filterIndexed { idx, fruit ->
            println(idx)
            fruit.name == "사과"
        }

        val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
            .map { apple -> apple.currentPrice }

        fruits.all { fruit -> fruit.name == "사과" }
        fruits.any { fruit -> fruit.name == "사과" }
        fruits.none { fruit -> fruit.name == "사과" }

        fruits.count()
        fruits.count { fruit -> fruit.name == "사과" }

        fruits.sortedBy { fruit -> fruit.currentPrice }
        fruits.sortedByDescending { fruit -> fruit.currentPrice }

        fruits.distinctBy { fruit -> fruit.name }
            .map { fruit -> fruit.name }

        fruits.first()
        fruits.firstOrNull()
    }

    @Test
    internal fun name2() {

        val groupBy = fruits.groupBy { fruit -> fruit.name }
        val associateBy = fruits.associateBy { fruit -> fruit.id }

        fruits.groupBy(
            { fruits -> fruits.id },
            { fruit -> fruit.factoryPrice }
        )
    }
}