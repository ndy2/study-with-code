package lec13_nestedclass

import lec13_nestedclass.code.House
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class HouseTest {

    @Test
    internal fun name() {

        val house = House("hello")

        assertThat(house.address).isEqualTo("hello")
        assertThat(house.livingRoom.area).isEqualTo(10.0)
    }
}