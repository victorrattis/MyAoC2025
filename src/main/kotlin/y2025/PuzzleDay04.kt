package com.vhra.aoc.y2025

class PuzzleDay04: PuzzleExecutor() {
    override fun executeInput(file: String, isPart2: Boolean): String {
        val grid = file.split(System.lineSeparator())
        var result = 0

        for (x in grid.indices) {
            for (y in grid[x].indices) {
                if(getTile(x, y, grid) == '@' && isAccessed(x, y, grid)) {
                    result++
                }
            }
        }
        return result.toString()
    }

    private fun isAccessed(x: Int, y: Int, grid: List<String>): Boolean {
        var count = 0
        if (getTile(x-1, y-1, grid) == '@') count++
        if (getTile(x,   y-1, grid) == '@') count++
        if (getTile(x+1, y-1, grid) == '@') count++

        if (getTile(x-1, y, grid) == '@') count++
        if (getTile(x+1, y, grid) == '@') count++

        if (getTile(x-1, y+1, grid) == '@') count++
        if (getTile(x,   y+1, grid) == '@') count++
        if (getTile(x+1, y+1, grid) == '@') count++
        return count < 4
    }

    private fun getTile(x: Int, y: Int, grid: List<String>): Char? {
        return try {
            grid[x][y]
        } catch (_: IndexOutOfBoundsException) {
            null
        }
    }
}