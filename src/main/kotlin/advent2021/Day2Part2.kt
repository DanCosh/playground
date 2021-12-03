package advent2021

import java.io.FileReader

fun main(args: Array<String>) {
    val result = FileReader("src/main/resources/day2/moves")
        .readLines()
        .asSequence()
        .map { it.split(" ") }
        .filter { it.size >= 2 }
        .map { Pair(it[0], it[1].toInt()) }
        .map {
            when(it.first) {
                "forward" -> Triple(it.second, 0, 0)
                "down" -> Triple(0, 0, it.second)
                "up" -> Triple(0, 0, -it.second)
                else -> Triple(0,0,0)
            }
        }
        .reduce { acc, s ->
            Triple(acc.first + s.first, acc.second + (s.first * acc.third),acc.third + s.third)
        }
        .run { first * second }

    println(result)
}