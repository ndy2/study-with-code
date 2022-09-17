package lec07_exception

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {


    fun printATxt() {
        val currentFile = File("")
        val file = File(currentFile.absolutePath + "/src/test/resources/a.txt")
        val reader = BufferedReader(FileReader(file))

        println(reader.readLine())
        reader.close()
    }

    fun print(s: String) {
        val currentFile = File("")

        BufferedReader(FileReader(File(currentFile.absolutePath + "/src/test/resources/a.txt"))).use {
            reader -> println(reader.readLine())
        }
    }
}