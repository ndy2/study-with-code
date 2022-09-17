package lec07_exception

import org.junit.jupiter.api.Test
import kotlin.NumberFormatException

class ExceptionTest {

    fun parseIntOrThrow(str: String): Int {
        try {
            return str.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("str is not string")
        }
    }

    fun parseIntOrNull(str: String): Int? {
        return try {
            str.toInt()
        } catch (e: NumberFormatException) {
            null
        }
    }

    @Test
    internal fun fileReaderTest() {
        val printer = FilePrinter()
        printer.printATxt()
    }

    @Test
    internal fun fileReadeWithPath() {
        val printer = FilePrinter()
        printer.print("a.txt")
    }
}