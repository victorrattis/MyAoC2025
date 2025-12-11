package com.vhra.aoc.y2025

import java.math.BigInteger
import java.net.URL

class PuzzleDay02 {
    fun execute(file: URL, isPart2: Boolean = false): String = file.readText()
        .split(",")
        .map { it.split("-").let { range -> Pair(range[0].toBigInteger(), range[1].toBigInteger()) } }
        .map { it.sumRangeOf{ number ->
           if (!isPart2) isInvalidId(number.toString(), 2) else  isInvalidId(number.toString())
        }  }
        .sum()
        .toString()

    private inline fun Pair<BigInteger, BigInteger>.sumRangeOf(selector: (BigInteger) -> Boolean): BigInteger {
        var sum = BigInteger.ZERO
        var i = this.first
        while (i <= this.second) {
            if(selector(i)) {
                sum += i
            }
            i++
        }
        return sum
    }

    private fun Iterable<BigInteger>.sum(): BigInteger {
        var sum: BigInteger = BigInteger.ZERO
        for (element in this) {
            sum += element
        }
        return sum
    }

    private fun isInvalidId(number: String, divisions: Int = number.length): Boolean {
        var isValid = false
        for (i in 2..divisions) {
            if ((number.length % i) == 0) {
                val size = number.length / i
                isValid = true
                for (x in 0 until size) {
                    if (!allSame(number, x, size, i)) {
                        isValid = false
                        break
                    }
                }
                if (isValid) break
            }
        }
        return isValid
    }

    private fun allSame(number: String, index: Int, size: Int, n: Int): Boolean {
        val first = number[index]
        for (i in 1 until n) {
            if (first != number[index + (i * size)]) return false
        }
        return true
    }
}