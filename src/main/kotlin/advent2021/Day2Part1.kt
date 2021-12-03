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
                "forward" -> Pair(it.second, 0)
                "down" -> Pair(0, it.second)
                "up" -> Pair(0, -it.second)
                else -> Pair(0,0)
            }
        }
        .reduce { acc, s ->
            Pair(acc.first + s.first, acc.second + s.second)
        }
        .run { first * second }

    println(result)
}