package advent2021

import java.io.FileReader

fun main(args: Array<String>) {
    val result = FileReader("src/main/resources/day1/depths")
        .readLines()
        .map(String::toInt)
        .fold(Pair(-1,0)) { acc, s ->
            Pair(if(s > acc.second) acc.first + 1 else acc.first, s)
        }
        .first

    println(result)
}