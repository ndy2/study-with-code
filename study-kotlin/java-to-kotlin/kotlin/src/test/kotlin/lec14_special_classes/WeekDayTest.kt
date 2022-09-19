package lec14_special_classes

import lec14_special_classes.code.WeekDay
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WeekDayTest {

    @Test
    internal fun name() {
        val mon = WeekDay.MON

        assertThat(mon).isNotNull()
        assertThat(mon.order).isEqualTo(1)
    }
}