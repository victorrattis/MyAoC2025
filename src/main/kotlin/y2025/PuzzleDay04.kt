package com.vhra.aoc.y2025

class PuzzleDay04: PuzzleExecutor() {
    companion object {
        const val ROLL_PAPER_TILE: Char = '@'
        const val EMPTY_TILE: Char = '.'
    }

    override fun executeInput(file: String, isPart2: Boolean): String {
        return if (!isPart2) executePart1(file) else executePart2(file)
    }

    private fun executePart1(file: String): String {
        val grid = file.split(System.lineSeparator()).map { it.toCharArray() }
        var result = 0
        for (x in grid.indices) {
            for (y in grid[x].indices) {
                if(getTile(x, y, grid) == ROLL_PAPER_TILE && isAccessed(x, y, grid)) {
                    result++
                }
            }
        }
        return result.toString()
    }

    private fun executePart2(file: String): String {
        val grid = file.split(System.lineSeparator()).map { it.toCharArray() }
        val rolls = mutableListOf<Pair<Int, Int>>()
        var result = 0

        do {
            rolls.clear()
            for (x in grid.indices) {
                for (y in grid[x].indices) {
                    if (getTile(x, y, grid) == ROLL_PAPER_TILE && isAccessed(x, y, grid)) {
                        rolls.add(x to y)
                    }
                }
            }
            result += rolls.size
            rolls.forEach { (x, y) -> grid[x][y] = EMPTY_TILE }
        } while (rolls.size > 0)

        return result.toString()
    }

    private fun isAccessed(x: Int, y: Int, grid: List<CharArray>): Boolean {
        var count = 0
        if (getTile(x-1, y-1, grid) == ROLL_PAPER_TILE) count++
        if (getTile(x,   y-1, grid) == ROLL_PAPER_TILE) count++
        if (getTile(x+1, y-1, grid) == ROLL_PAPER_TILE) count++

        if (getTile(x-1, y, grid) == ROLL_PAPER_TILE) count++
        if (getTile(x+1, y, grid) == ROLL_PAPER_TILE) count++

        if (getTile(x-1, y+1, grid) == ROLL_PAPER_TILE) count++
        if (getTile(x,   y+1, grid) == ROLL_PAPER_TILE) count++
        if (getTile(x+1, y+1, grid) == ROLL_PAPER_TILE) count++
        return count < 4
    }

    private fun getTile(x: Int, y: Int, grid: List<CharArray>): Char? {
        return try {
            grid[x][y]
        } catch (_: IndexOutOfBoundsException) {
            null
        }
    }
}