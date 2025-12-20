package com.vhra.aoc.y2025

class PuzzleDay06: PuzzleExecutor() {
    override fun executeInput(file: String, isPart2: Boolean): String {
        return if (!isPart2) executePart1(file) else executePart2(file)
    }

    private fun executePart1(file: String): String {
        val worksheet = file.split(System.lineSeparator()).map { line ->
            line.trim().split("\\s+".toRegex())
        }
        return worksheet.last().foldIndexed(0L) { index, acc, operator ->
            acc + executeOperator(
                (0 until worksheet.size - 1).map { lineIndex -> worksheet[lineIndex][index].toLong() },
                operator
            )
        }.toString()
    }

    private fun executePart2(file: String): String {
        val worksheet = file.split(System.lineSeparator())
        val operators = worksheet.last().trim().split("\\s+".toRegex())
        return (worksheet[0].length - 1 downTo 0).map { column ->
            (worksheet.size - 2 downTo 0).map { lineIndex ->
                worksheet[lineIndex][column]
            }.fold("") { n, acc -> acc + n }
        }.fold(mutableListOf(mutableListOf<Long>())) { acc, number ->
            if (number.isBlank()) {
                acc.add(mutableListOf())
            } else {
                acc.last().add(number.trim().toLong())
            }
            acc
        }.foldIndexed(0L) { index, acc, numbers ->
            acc + executeOperator(numbers, operators[operators.size - 1 - index])
        }.toString()
    }

    private fun executeOperator(number:List<Long>, operator: String): Long {
        return when (operator) {
            "*" -> number.foldRight(1L) { n, acc -> acc * n  }
            "+" -> number.foldRight(0L) { n, acc -> acc + n  }
            else -> 0L
        }
    }
}