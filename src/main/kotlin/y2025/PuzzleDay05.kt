package com.vhra.aoc.y2025

class PuzzleDay05: PuzzleExecutor() {
    override fun executeInput(file: String, isPart2: Boolean): String {
        val lines = file.split(System.lineSeparator()).iterator()
        val ranges = mutableListOf<Pair<Long, Long>>()
        val ingredients = mutableListOf<Long>()

        do {
            val line = lines.next()
            if (line != "") {
                line.split("-").let {
                    ranges.add(it[0].toLong() to it[1].toLong())
                }
            }
        } while (line != "")

        while (lines.hasNext()) {
            ingredients.add(lines.next().toLong())
        }

        return  ingredients.count { ingredient -> ranges.any { (start, end) -> ingredient in start..end } }.toString()
    }

}