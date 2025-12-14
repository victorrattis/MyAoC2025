package com.vhra.aoc.y2025

import java.math.BigInteger

class PuzzleDay03: PuzzleExecutor() {
    override fun executeInput(file: String, isPart2: Boolean): String {
        return file
            .split(System.lineSeparator())
            .sumOf { getLargestJoltage(it, if (!isPart2) 2 else 12 ) }.toString()
    }

    private fun getLargestJoltage(line: String, digits: Int): BigInteger {
        val result = CharArray(digits)
        var largestDigital = '0'
        var largestIndex = 0

        for (i in 0 until digits) {
            for (x in (largestIndex) until line.length - (digits - 1 - i)) {
                if (largestDigital < line[x]) {
                    largestDigital = line[x]
                    largestIndex = x
                    if (largestDigital == '9') break
                }
            }
            result[i] = largestDigital
            largestDigital = '0'
            largestIndex++
        }
        return result.joinToString("").toBigInteger()
     }
}