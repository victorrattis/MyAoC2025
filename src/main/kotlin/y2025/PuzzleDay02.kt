package com.vhra.aoc.y2025

import java.math.BigInteger
import java.net.URL

class PuzzleDay02 {
    fun execute(file: URL, isPart2: Boolean = false): String = file.readText()
        .split(",")
        .map { it.split("-").let { range -> Pair(range[0].toBigInteger(), range[1].toBigInteger()) } }
        .map { it.sumRangeOf{ number -> isInvalidTwiceId(number.toString()) }  }
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

    /*
     * invalid IDs is made only of some sequence of digits repeated twice
     * */
    private fun isInvalidTwiceId(id: String): Boolean {
        // None of the numbers have leading zeroes;
        if ((id.length % 2) == 0) {
            val middle = id.length / 2
            var s1 = 0
            var s2 = middle
            while (s1 < middle && s2 < id.length) {
                if (id[s1] != id[s2]) return false
                s1++
                s2++
            }
            return true
        }
        return false
    }
}