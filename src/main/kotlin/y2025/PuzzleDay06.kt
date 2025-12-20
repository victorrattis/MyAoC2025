package com.vhra.aoc.y2025

class PuzzleDay06: PuzzleExecutor() {
    override fun executeInput(file: String, isPart2: Boolean): String {
        val worksheet = file.split(System.lineSeparator()).map { line ->
            line.trim().split("\\s+".toRegex())
        }
        var result = 0L
        worksheet.last().forEachIndexed { index, operator ->
            result += executeOperator(
                (0 until worksheet.size - 1).map { lineIndex -> worksheet[lineIndex][index].toLong() },
                operator
            )
        }
        return result.toString()
    }

    private fun executeOperator(number:List<Long>, operator: String): Long {
        return when (operator) {
            "*" -> number.foldRight(1L) { n, acc -> acc * n  }
            "+" -> number.foldRight(0L) { n, acc -> acc + n  }
            else -> 0L
        }
    }
}