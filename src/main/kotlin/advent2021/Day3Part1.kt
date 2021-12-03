package advent2021

import java.io.FileReader

fun main(args: Array<String>) {
    val parsedInput = FileReader("src/main/resources/day3/diagnostics")
        .readLines()
        .asSequence()
        .map {
            it.split("")
                .drop(1)
                .dropLast(1)
                .map(String::toInt)
        }
    val count = parsedInput.count()
    val sumOfEachBit = parsedInput.reduce{ acc, list ->
        acc.mapIndexed { index, i -> i + list[index] }
    }
    val gamma = sumOfEachBit.map { if (it * 2 > count) '1' else '0' }
        .joinToString("")
        .toInt(2)
    val epsilon = sumOfEachBit.map { if (it * 2 < count) '1' else '0' }
        .joinToString("")
        .toInt(2)
    val result = gamma * epsilon

    println(result)
}