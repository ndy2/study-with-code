package lec14_special_classes

import lec14_special_classes.code.PersonDto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataTest {

    @Test
    internal fun `data test`() {
        val personDto1 = PersonDto("하하", 26)
        val personDto2 = PersonDto("하하", 26)

        assertThat(personDto1).isEqualTo(personDto2)
        assertThat(personDto1.toString()).isEqualTo("PersonDto(name=하하, age=26)")
    }
}