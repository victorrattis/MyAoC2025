package com.vhra.aoc.y2025

class PuzzleDay05: PuzzleExecutor() {
    override fun executeInput(file: String, isPart2: Boolean): String {
        val input = PuzzleInput.parse(file)
        return if (!isPart2) executePart1(input.ranges, input.ingredients) else executePart2(input.ranges)
    }

    private fun executePart1(ranges: List<Pair<Long, Long>>, ingredients: List<Long>): String {
        return ingredients.count { ingredient ->
            ranges.any { (start, end) -> ingredient in start..end }
        }.toString()
    }

    private fun executePart2(ranges: List<Pair<Long, Long>>): String {
        var newRanges = setOf<Pair<Long,Long>>()
        ranges.forEach { range ->
            val conflictedRanges = (newRanges.filter {
                isInRange(it, range)
            }).toSet()

            if (conflictedRanges.isNotEmpty()) {
                val noConflictedRanges = newRanges - conflictedRanges
                newRanges = noConflictedRanges + joinRanges(conflictedRanges + range)
            } else {
                newRanges += range
            }
        }
        return newRanges.sumOf { it.end - it.start + 1L }.toString()
    }

    private fun joinRanges(ranges: Set<Pair<Long, Long>>): Pair<Long, Long> {
        var start: Long? = null
        var end: Long? = null
        ranges.forEach { range ->
            if (start == null || start!! > range.start) start = range.start
            if (end == null || end!! < range.end) end = range.end
        }
        return start!! to end!!
    }

    private fun isInRange(a: Pair<Long, Long>, b: Pair<Long, Long>) =
        (a.start <= b.start && b.start <= a.end) ||
        (a.start <= b.end && b.end <= a.end) ||
        (b.start <= a.start && a.start <= b.end) ||
        (b.start <= a.end && a.end <= b.end)

    private val Pair<Long, Long>.start: Long
        get() = this.first

    private val Pair<Long, Long>.end: Long
        get() = this.second

    private data class PuzzleInput(val ranges: List<Pair<Long, Long>>, val ingredients: List<Long>) {
        companion object {
            fun parse(text: String): PuzzleInput {
                val lines = text.split(System.lineSeparator()).iterator()
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

                return PuzzleInput(ranges, ingredients)
            }
        }
    }
}