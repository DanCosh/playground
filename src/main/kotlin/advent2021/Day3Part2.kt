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
    val oxygenReading = parsedInput.filterBitwise { sumOfBits, countOfBits -> sumOfBits * 2 >= countOfBits }
        .joinToString("")
        .toInt(2)
    val co2Reading = parsedInput.filterBitwise { sumOfBits, countOfBits -> sumOfBits * 2 < countOfBits }
        .joinToString("")
        .toInt(2)
    val result = co2Reading * oxygenReading

    println(result)
}

fun Sequence<List<Int>>.filterBitwise(bit: Int = 0, keepOneBitsIf: (sum: Int, count: Int) -> Boolean): List<Int> {
    val keepOneBits = keepOneBitsIf(sumOf { it[bit] }, count())
    val bitTest: (Int) -> Boolean = if (keepOneBits) { b -> b == 1 } else { b -> b == 0 }

    return with (filter { bitTest(it[bit]) }) {
        if (count() == 1) first() else filterBitwise(bit + 1, keepOneBitsIf)
    }
}
