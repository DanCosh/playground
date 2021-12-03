package advent2021

import java.io.FileReader

fun main(args: Array<String>) {
    val result = FileReader("src/main/resources/day4/sample")
        .readLines()
        .asSequence()

    println(result)
}
