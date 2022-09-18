package lec12_object

import lec12_object.code.Person
import org.junit.jupiter.api.Test

class CompanionObjectTest {

    @Test
    internal fun name() {
        val babyHaha = Person.newBaby("haha")
    }

    @Test
    internal fun name2() {
        println(Singleton.a)
        Singleton.a += 10
        println(Singleton.a)
    }
}

object Singleton {
    var a: Int = 0
}