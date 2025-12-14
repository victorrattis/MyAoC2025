package com.vhra.aoc.y2025

import java.net.URL

class PuzzleDay03 {
    fun execute(file: URL, isPart2: Boolean = false): String {
        return file.readText()
            .split(System.lineSeparator())
            .sumOf { getLargestJoltage(it) }.toString()
    }

    private fun getLargestJoltage(line: String): Int {
        var first = line[0]
        var second = '0'
        var index = 0

        for (i in 1 until line.length - 1) {
            if (first < line[i]) {
                first = line[i]
                index = i
                if (first == '9') break
            }
        }

        for (i in index + 1 until line.length) {
            if (second < line[i]) {
                second = line[i]
                if (second == '9') break
            }
        }

        return first.digitToInt() * 10 + second.digitToInt()
     }
}